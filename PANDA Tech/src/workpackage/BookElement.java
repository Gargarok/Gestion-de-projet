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
	private String name;
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
	 * @param name
	 * 			   the name of this element
	 */
	protected BookElement(String name){
		id=nb;
		nb++;
		this.name=name;
	}
	/**
	 * Return the ID of this element
	 * @return id
	 */
	public long getId(){return id;}
	/**
	 * Return the name of this element
	 * @return name
	 */
	public String getName(){return name;}

}
