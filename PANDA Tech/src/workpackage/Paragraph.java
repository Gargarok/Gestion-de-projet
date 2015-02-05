package workpackage;

/**
 * A Paragraph represent a paragraph of a book
 * 
 * @author Karine Siette
 * @version 1.0
 *
 */
public class Paragraph extends BookElement 
{
	/**
	 * contents of this paragraph
	 */
	private String contents="";
	/**
	 * Paragraph's default constructor
	 */
	public Paragraph()
	{
		super();
	}
	/**
	 * Paragraph's constructor
	 * @param title
	 * 				the name of this paragraph
	 */
	public Paragraph(String title)
	{
		super(title);
	}
	/**
	 * Returns contents of this paragraph
	 * @return content
	 */
	public String getContents(){return contents;}
	/**
	 * Modify contents of this paragraph
	 * @param contents
	 * 				  the new contents
	 */
	public void setContent(String contents){this.contents=contents;}
}
