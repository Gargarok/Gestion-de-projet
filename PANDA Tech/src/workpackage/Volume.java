package workpackage;

import java.util.HashMap;
import java.util.Map;

/**
 * A Volume represent a volume which contain chapters
 * 
 * @see Chapter
 * @author Karine Siette
 * @version 1.0
 *
 */
public class Volume extends BookElement 
{
	/**
	 * Hash table containing chapters contained in this volume associated with their ID
	 * @see Chapter
	 */
	private Map<Long,Chapter> chapters=new HashMap<>();
	/**
	 * Volume's default constructor
	 */
	public Volume()
	{
		super();
	}
	/**
	 * Volume's constructor
	 * @param name
	 *  			the name of this volume
	 */
	public Volume(String name)
	{
		super(name);
	}
	/**
	 * Returns a Chapter of this volume
	 * @param id_item
	 * 				  ID of the Chapter	
	 * @return the chapter corresponding to the ID
	 * @see Chapter
	 */
	public Chapter getItem(long id_item)
	{
		return chapters.get(id_item);
	}
	/**
	 * Add a chapter in this volume
	 * @param chap
	 *  		   the chapter to add
	 * @see Chapter
	 */
	public void add(Chapter chap)
	{
		chapters.put(chap.getId(), chap);
	}

}
