package controllers.admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class FilesTableController  implements MouseListener{
	private JPanel panel;
	private JTable table;
	private JLabel titreLabel;
	private JLabel versionLabel;
	private JLabel dateLabel;
	private JLabel auteurLabel;
	private JLabel resumeLabel;
	
	

	public FilesTableController(JPanel panel, JTable table, JLabel titreLabel, JLabel versionLabel, JLabel dateLabel, JLabel auteurLabel, JLabel resumeLabel) {
		this.auteurLabel = auteurLabel;
		this.dateLabel = dateLabel;
		this.resumeLabel = resumeLabel;
		this.titreLabel = titreLabel;
		this.versionLabel = versionLabel;
		this.table=table;
		this.panel=panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		String s=table.getModel().getValueAt( table.getSelectedRow(),0).toString();
		titreLabel.setText("Title :  "+s);
		versionLabel.setText("Version : "+s);
		dateLabel.setText("Date :  "+s);
		auteurLabel.setText("Author :  "+s);
		resumeLabel.setText("Summary :  "+s);
		panel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
