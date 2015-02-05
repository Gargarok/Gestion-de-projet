package gestion_projet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.acl.NotOwnerException;
import java.util.ArrayList;

import org.junit.Test;

import workpackage.BookElement;
import workpackage.WorkPackage;

public class WPTest {

	@Test
	public void testWorkPackage() 
	{
		WorkPackage wp=new WorkPackage("","");
		assertNotNull(wp);
		assertTrue(wp.size()==1);
	}

	@Test(expected=NullPointerException.class)
	public void testWorkPackageWorkPackageListOfLongNull() 
	{
		WorkPackage wp=new WorkPackage("","");
		WorkPackage wp2=new WorkPackage("wp1",wp,null,"","");
		
	}
	@Test
	public void testWorkPackageWorkPackageListOfLong() 
	{
		WorkPackage wp=new WorkPackage("","");
		ArrayList<Long> l=new ArrayList<>();
		WorkPackage wp2=new WorkPackage("wp1",wp,l,"","");
		assertTrue(wp2.size()==0);
		l.add(BookElement.nb-1);
		wp2=new WorkPackage("wp2",wp,l,"","");
		assertTrue(wp2.size()==1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testWorkPackageWorkPackageListOfLongBadArg()
	{
		WorkPackage wp=new WorkPackage("","");
		ArrayList<Long> l=new ArrayList<>();
		l.add(-1555L);
		WorkPackage wp2=new WorkPackage("wp1",wp,l,"","");		
	}
	@Test
	public void testValidate() 
	{
		WorkPackage wp=new WorkPackage("","");
		assertFalse(wp.isValidate());
		try {
			wp.validate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(wp.isValidate());
	}

	@Test
	public void testAddVolume() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		wp.addVolume(BookElement.nb-1, "vol1", -1);
	}
	@Test(expected=NotOwnerException.class)
	public void testAddVolumeNotOwner() throws NotOwnerException 
	{
		WorkPackage wp=new WorkPackage("","");
		wp.addVolume(BookElement.nb-1, "vol1", 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddVolumeBabArg() throws NotOwnerException 
	{
		WorkPackage wp=new WorkPackage("","");
		wp.addVolume(0L, "vol1", -1);
	}
	
	@Test
	public void testAddChapter() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);

	}
	@Test(expected=NotOwnerException.class)
	public void testAddChapterNotOwner() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", 6);

	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddChapterBadArg() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, 0, "chap1", -1);

	}
	@Test
	public void testAddParagraph() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);
		long id3=BookElement.nb-1;
		wp.addParagraph(id, id2,id3, "p1", -1);

	}
	@Test(expected=NotOwnerException.class)
	public void testAddParagraphNotOwner() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);
		long id3=BookElement.nb-1;
		wp.addParagraph(id, id2,id3, "p1", 0);

	}
	@Test(expected=IllegalArgumentException.class)
	public void testAddParagraphBadArg() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);
		long id3=BookElement.nb-1;
		wp.addParagraph(id, id2,0, "p1", -1);

	}
	@Test
	public void testEditParagraph() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);
		long id3=BookElement.nb-1;
		wp.addParagraph(id, id2,id3, "p1", -1);
		wp.editParagraph(id, id2, id3,BookElement.nb-1, "test", -1);
	}
	
	@Test(expected=NotOwnerException.class)
	public void testEditParagraphNotOwner() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);
		long id3=BookElement.nb-1;
		wp.addParagraph(id, id2,id3, "p1", -1);
		wp.editParagraph(id, id2, id3,BookElement.nb-1, "test", 0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEditParagraphBadArg() throws NotOwnerException
	{
		WorkPackage wp=new WorkPackage("","");
		long id=BookElement.nb-1;
		wp.addVolume(id, "vol1", -1);
		long id2=BookElement.nb-1;
		wp.addChapter(id, id2, "chap1", -1);
		long id3=BookElement.nb-1;
		wp.addParagraph(id, id2,id3, "p1", -1);
		wp.editParagraph(id, id2, id3,0, "test", -1);
	}
	

}
