package vuesclient;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;

public class ContentPane extends Container{
	
	private static final long serialVersionUID = -2983386129974582126L;
	
	public ContentPane() {
		setLayout(new BorderLayout());
		add(new ConnectionPane(),BorderLayout.CENTER);
	}

}
