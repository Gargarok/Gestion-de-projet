package workpackage;

/**
 * A BookElement represent an element of a book.
 * It can be:
 * - a Book
 * - a Volume
 * - a Chapter
 * - a Paragraph
 * 
 * @see Book
 * @see Volume
 * @see Chapter
 * @see Paragraph 
 * 
 * @author Karine Siette
 * @version 1.0
 *
 */
public abstract class BookElement {
	/**
	 * number of created elements 
	 */
	public static long nb;
	/**
	 * ID of this element
	 */
	private long id;
	/**
	 * name of the element
	 */
	
	private String title;
	private String path;
	/**
	 * BookElement's default constructor
	 * <p>
	 * At the end of the construction, nb is incremented
	 * </p>
	 */
	
	protected BookElement(){
		id=nb;
		nb++;
	}
	/**
	 * BookElement's constructor
	 * @param title
	 * 			   the name of this element
	 */
	protected BookElement(String title, String path){
		id=nb;
		nb++;
		this.title=title;
		this.path=path;
	}
	/**
	 * Return the ID of this element
	 * @return id
	 */
	public long getId(){return id;}
	/**
	 * Return the name of this element
	 * @return title
	 */
	public String getTitle(){return title;}
	public String getPath(){return path;}
	public void setPath(){this.path=path;}

}
