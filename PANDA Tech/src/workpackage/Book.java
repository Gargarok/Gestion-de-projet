package workpackage;

import java.util.HashMap;
import java.util.Map;

/**
 * A Book represent a book which contain volumes
 * 
 * @see Volume
 * @author Karine Siette
 * @version 1.0
 */
public class Book extends BookElement {
	/**
	 * Hash table containing volumes contained in this book associated with their ID
	 * @see Volume
	 */
	private Map<Long,Volume> volumes=new HashMap<>();
	/**
	 * Book's default constructor
	 */
	public Book()
	{
		super();
	}
	/**
	 * Book's constructor
	 * @param title
	 * 			   the name of this book
	 */
	public Book(String title)
	{
		super(title);
	}
	/**
	 * Returns a Volume of this book
	 * @param id_item
	 * 				  ID of the Volume	
	 * @return the volume corresponding to the ID
	 * @see Volume
	 */
	public Volume getItem(long id_item)
	{
		return volumes.get(id_item);
	}
	/**
	 * Add a volume in this book
	 * @param vol
	 * 			  the volume to add
	 * @see Volume
	 */
	public void add(Volume vol)
	{
		volumes.put(vol.getId(), vol);
	}

}
