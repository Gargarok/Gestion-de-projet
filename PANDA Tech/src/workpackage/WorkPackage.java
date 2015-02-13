package workpackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.acl.NotOwnerException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A WorkPackage is a component which contain book elements.
 * 
 * @see BookElement
 * @author Karine Siette
 * @version 1.1
 */

public class WorkPackage 
{
	/**
	 * Hash table containing elements contained in this WorkPackage associated with their ID
	 * @see BookElement
	 */
	private Map<Long,BookElement> elements=new HashMap<>();
	/**
	 *  the state of this WorkPackage, can be: VALID, WAITFORVALID, NONVALID
	 */
	private String state;
	/**
	 * ID of the person who can change this WorkPackage
	 */
	private long id_rw=-1;
	/**
	 * the name of this WorkPackage
	 */
	private String name;
	/**
	 * creation date of this workpackage
	 */
	private Date date_create;
	private long id;
	private long nb;
	private String path_validate;
	private String path_to_validate;
	/**
	 * WorkPackage's default constructor
	 * <p>
	 * While WorkPackage's construction, a book is created in this WorkPackage
	 * </p>
	 */

	
	public WorkPackage(String name, String title, String path_to_validate,String path_validate,ServerRequest serv_req)
	{
		Book b=new Book(title,name);
		id=nb;
		nb++;
		elements.put(b.getId(), b);
		state="NONVALID";
		date_create = new Date(System.currentTimeMillis());
		serv_req.createFolder(path_to_validate,name);
		serv_req.createFolder(path_validate,name);
		String query="Insert into WorkPackage VALUES("+id+","+name+","+date_create+","+state+");";
		serv_req.executeQuery(query);
		query="INSERT INTO BookElement VALUES("+b.getId()+","+b.getTitle()+","+id_rw+","+path_validate+File.separator+b.getPath()+","+path_to_validate+File.separator+b.getPath()+","+state+","+id+");";
		serv_req.executeQuery(query);
		query="INSERT INTO Book VALUES("+b.getId()+",NULL);";
		serv_req.executeQuery(query);

		
	}
	/**
	 * WorkPackage's constructor
	 * <p>
	 * Constructs a WorkPackage from another WorkPackage and a list of elements contained in the another WorkPackage
	 * </p>
	 * @param wp
	 * 			 The WorkPackage from which we will build this WorkPackage
	 * @param name 
	 * 				the name of this WorkPackage
	 * @param id_elems
	 * 				   IDs of elements contained in the WorkPackage wp which will be created in this WorkPackage
	 * 
	 */
	public WorkPackage(String name, WorkPackage wp,List<Long> id_elems, String path_to_validate,String path_validate,ServerRequest serv_req)
	{
		state="NONVALID";
		date_create = new Date(System.currentTimeMillis());
		this.name=name;
		id=nb;
		nb++;
		for(long id :id_elems)
		{
			BookElement elem=wp.getItem(id);
			if(elem==null) throw new IllegalArgumentException();
			elements.put(id, elem);
			
		}
		serv_req.createFolder(path_to_validate,name);
		serv_req.createFolder(path_validate,name);
		String query="Insert into WorkPackage VALUES("+id+","+name+","+date_create+","+state+");";
		serv_req.executeQuery(query);
		
	}
	/**
	 * Returns an element of this WorkPackage
	 * 
	 * @param id_item
	 * 				  ID of the element
	 * 
	 * @return the element corresponding to the ID
	 */
	private BookElement getItem(long id_item)
	{
		return elements.get(id_item);
	}
	/**
	 * Returns the size of this WorkPackage
	 * 
	 * @return the number of elements contained in this WorkPackage
	 */
	public int size(){return elements.size();}
	/**
	 * Validate this WorkPackage
	 * @throws IOException path_to_validate or path_validate not exist
	 */
	public void validate(ServerRequest serv_req) throws IOException{
		state="VALID";
		for(BookElement e:elements.values())
			Files.copy(new File(path_to_validate+File.separator+e.getTitle()).toPath(),new File(path_validate+File.separator+e.getTitle()).toPath() );
		String query="UPDATE WorkPackage SET state="+state+" WHERE wp_id="+id+";";
		serv_req.executeQuery(query);
	}
	/**
	 * Indicates if this WorkPackage is validated
	 * 
	 * @return true if this WorkPackage is validated, else false 
	 */
	
	public boolean isValidate(){return state.equals("VALID");}
	/**
	 * Add a Volume in a book of this WorkPackage
	 * @param id_book
	 * 				  ID of the book
	 * @param name_vol
	 * 				   name of the added volume
	 * @param id_user
	 * 					ID of the user who add the volume
	 * 
	 * @throws NotOwnerException if the user who add the volume is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the book's ID is not in this WorkPackage
	 */
	public void addVolume(long id_book,String name_vol, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		
		if(id_user!=id_rw) throw new NotOwnerException();
		Book b=(Book) getItem(id_book);
		if(b==null) throw new IllegalArgumentException();
		Volume v=b.add(name_vol);
		String query="INSERT INTO BookElement VALUES("+v.getId()+","+v.getTitle()+","+id_rw+","+path_validate+File.separator+v.getPath()+","+path_to_validate+File.separator+v.getPath()+","+state+","+id+");";
		serv_req.executeQuery(query);
		query="INSERT INTO Volume VALUES("+v.getId()+",NULL,"+id_book+");";
		serv_req.executeQuery(query);
		
	}
	/**
	 * Add a Chapter in a volume of this WorkPackage
	 * @param id_vol
	 * 				 ID of the volume
	 * @param name_chap
	 * 					name of the added chapter
	 * @param id_user
	 * 				  ID of the user who add the chapter
	 * 
	 * @throws NotOwnerException if the user who add the chapter is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the volume's ID is not in this WorkPackage
	 */
	public void addChapter(long id_vol, String name_chap, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		if(id_user!=id_rw) throw new NotOwnerException();
		Volume vol=(Volume) getItem(id_vol);
		if(vol==null) throw new IllegalArgumentException();
		Chapter c=vol.add(name_chap);
		String query="INSERT INTO BookElement VALUES("+c.getId()+","+c.getTitle()+","+id_rw+","+path_validate+File.separator+c.getPath()+","+path_to_validate+File.separator+c.getPath()+","+state+","+id+");";
		serv_req.executeQuery(query);
		query="INSERT INTO Chapter VALUES("+c.getId()+",NULL,"+id_vol+");";
		serv_req.executeQuery(query);
		
	}
	/**
	 * Add a Chapter in a volume of a book of this WorkPackage
	 * @param id_book
	 * 				  ID of the book
	 * @param id_vol
	 * 				  ID of the volume
	 * @param name_chap
	 * 					name of the added chapter
	 * @param id_user
	 * 				  ID of the user who add the chapter
	 * 
	 * @throws NotOwnerException if the user who add the chapter is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the book's ID is not in this WorkPackage or the volume's ID is not in the book
	 */
	
	public void addChapter(long id_book,long id_vol,String name_chap, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		if(id_user!=id_rw) throw new NotOwnerException();
		Book b=(Book) getItem(id_book);
		if(b==null) throw new IllegalArgumentException();
		Volume vol= b.getItem(id_vol);
		if(vol==null) throw new IllegalArgumentException();
		Chapter c=vol.add(name_chap);
		String query="INSERT INTO BookElement VALUES("+c.getId()+","+c.getTitle()+","+id_rw+","+path_validate+File.separator+c.getPath()+","+path_to_validate+File.separator+c.getPath()+","+state+","+id+");";
		serv_req.executeQuery(query);
		query="INSERT INTO Chapter VALUES("+c.getId()+",NULL,"+id_vol+");";
		serv_req.executeQuery(query);
		
	}
	/**
	 * Add a paragraph in a chapter of this WorkPackage
	 * @param id_chap
	 * 				  ID of the chapter
	 * @param name_paragraph
	 * 						 name of the added paragraph
	 * @param id_user
	 * 				  ID of the user who add the paragraph
	 * 
	 * @throws NotOwnerException if the user who add the paragraph is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the chapter's ID is not in this WorkPackage
	 */
	public void addParagraph(long id_chap, String name_paragraph, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		if(id_user!=id_rw) throw new NotOwnerException();
		Chapter chap=(Chapter) getItem(id_chap);
		if(chap==null) throw new IllegalArgumentException();
		Paragraph p=chap.add(name_paragraph);
		String query="INSERT INTO BookElement VALUES("+p.getId()+","+p.getTitle()+","+id_rw+","+path_validate+File.separator+p.getPath()+","+path_to_validate+File.separator+p.getPath()+","+state+","+id+");";
		serv_req.executeQuery(query);
		query="INSERT INTO Paragraph VALUES("+p.getId()+",NULL,"+id_chap+");";
		serv_req.executeQuery(query);
		
	}
	/**
	 * Add a paragraph in a chapter of this WorkPackage
	 * @param id_book
	 * 				  ID of the book
	 * @param id_vol
	 * 				 ID of the volume
	 * @param id_chap
	 * 				  ID of the chapter
	 * @param name_paragraph
	 * 						 name of the added paragraph
	 * @param id_user
	 *       		  ID of the user who add the paragraph
	 *       
	 * @throws NotOwnerException if the user who add the paragraph is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the book's ID is not in this WorkPackage or the volume's ID is not in the book or the chapter's ID is not in the volume
	 */
	public void addParagraph(long id_book,long id_vol,long id_chap, String name_paragraph, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		if(id_user!=id_rw) throw new NotOwnerException();
		Book b=(Book) getItem(id_book);
		if(b==null) throw new IllegalArgumentException();
		Volume vol= b.getItem(id_vol);
		if(vol==null) throw new IllegalArgumentException();
		Chapter chap=vol.getItem(id_chap);
		if(chap==null) throw new IllegalArgumentException();
		Paragraph p=chap.add(name_paragraph);
		String query="INSERT INTO BookElement VALUES("+p.getId()+","+p.getTitle()+","+id_rw+","+path_validate+File.separator+p.getPath()+","+path_to_validate+File.separator+p.getPath()+","+state+","+id+");";
		serv_req.executeQuery(query);
		query="INSERT INTO Paragraph VALUES("+p.getId()+",NULL,"+id_chap+");";
		serv_req.executeQuery(query);
		
	}
	/**
	 * Edit a paragraph of this WorkPackage
	 * @param id_paragraph
	 * 						ID of the paragraph
	 * @param contents
	 * 					the new contents of the paragraph
	 * @param id_user
	 * 				  ID of the user who modify the paragraph
	 * 
	 * @throws NotOwnerException if the user who modify the paragraph is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the paragraph's ID is not in this WorkPackage
	 */
	public void editParagraph(long id_paragraph, String contents, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		if(id_user!=id_rw) throw new NotOwnerException();
		Paragraph p=(Paragraph) getItem(id_paragraph);
		if(p==null) throw new IllegalArgumentException();
		p.setContent(contents);
		
	}
	/**
	 * Edit a paragraph of a volume of a book of this WorkPackage
	 * @param id_book
	 * 				  ID of the book
	 * @param id_vol
	 * 				 ID of the volume
	 * @param id_chap
	 * 				  ID of the chapter
	 * @param id_paragraph
	 * 					   ID of the paragraph
	 * @param contents
	 * 				  the new contents of the paragraph
	 * @param id_user
	 * 				 ID of the user who modify the paragraph
	 * 
	 * @throws NotOwnerException if the user who modify the paragraph is not allowed to modify this WorkPackage
	 * 
	 * @throws IllegalArgumentException if the book's ID is not in this WorkPackage or the volume's ID is not in the book or the chapter's ID is not in the volume or the paragraph's ID is not in the chapter
	 */
	public void editParagraph(long id_book,long id_vol,long id_chap,long id_paragraph, String contents, long id_user,ServerRequest serv_req) throws NotOwnerException
	{
		
		if(id_user!=id_rw) throw new NotOwnerException();
		Book b=(Book) getItem(id_book);
		if(b==null) throw new IllegalArgumentException();
		Volume vol= b.getItem(id_vol);
		if(vol==null) throw new IllegalArgumentException();
		Chapter chap=vol.getItem(id_chap);
		Paragraph p=chap.getItem(id_paragraph);
		if(p==null) throw new IllegalArgumentException();
		p.setContent(contents);
		
	}
	
}
