package workpackage;

import java.io.File;
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
	 * @param title
	 *  			the name of this volume
	 */
	public Volume(String title,String path)
	{
		super(title,path);
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
	public Chapter add(String title)
	{
		Chapter chap=new Chapter(title,this.getPath()+File.separator+this.getTitle());
		chapters.put(chap.getId(), chap);
		return chap;
	}

}
