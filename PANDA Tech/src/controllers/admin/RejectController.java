package controllers.admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class RejectController implements MouseListener{
	JPanel panel;

	public RejectController(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		panel.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		panel.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		panel.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		panel.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
