package workpackage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * A Chapter represent a chapter which contain paragraphs
 * 
 * @see Paragraph
 * @author Karine Siette
 * @version 1.0
 *
 */
public class Chapter extends BookElement
{
	/**
	 * Hash table containing paragraph contained in this chapter associated with their ID
	 * @see Paragraph
	 */
	private Map<Long, Paragraph> paragraphs=new HashMap<>();
	/**
	 * Chapter's default constructor
	 */
	public Chapter()
	{
		super();
	}
	/**
	 * Chapter's constructor
	 * @param title
	 *   		   the name of this chapter
	 */
	public Chapter(String title, String path)
	{
		super(title,path);
	}
	/**
	 * Returns a Paragraph of this chapter
	 * @param id_item
	 * 				  ID of the Paragraph
	 * @return the Paragraph corresponding to the ID
	 * @see Paragraph
	 */
	public Paragraph getItem(long id_item)
	{
		return paragraphs.get(id_item);
	}
	/**
	 * Add a Paragraph in this chapter
	 * @param p
	 *  		the paragraph to add
	 * @see Paragraph
	 */
	public Paragraph add(String title)
	{
		Paragraph p=new Paragraph(title,this.getPath()+File.separator+this.getTitle());
		paragraphs.put(p.getId(), p);
		return p;
	}

}
