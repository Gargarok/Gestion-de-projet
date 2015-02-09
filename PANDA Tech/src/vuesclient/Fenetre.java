package vuesclient;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Fenetre  extends JFrame{

	private static final long serialVersionUID = -513694019027769592L;
	//-------------------------------------------------------------------------------------
	public Fenetre() {
		setVisible(true);
		setName("framename");
		setTitle("PANDA tech.");
		setMinimumSize(new Dimension(200, 200));
		//setPreferredSize(Constante.FRAME_PREFERED_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(window.getToolkit().getScreenSize()); // taille de l'ecran
		//setExtendedState(JFrame.MAXIMIZED_BOTH);	// ellargie
		setAlwaysOnTop(false);
		//setLocationRelativeTo(null); //positionne n'importe ou
		setLocation(10, 10);
		setResizable(true);
		validate();

		List<Image> icons = new ArrayList<Image>();
		icons.add(Toolkit.getDefaultToolkit().getImage("img/_icon_16x16_trans.png"));
		icons.add(Toolkit.getDefaultToolkit().getImage("img/_icon_40x40_trans.png"));
		icons.add(Toolkit.getDefaultToolkit().getImage("img/_icon_64x64_trans.png"));
		icons.add(Toolkit.getDefaultToolkit().getImage("img/_icon_128x128_trans.png"));
		setIconImages(icons);
		//-------------------------------------------------------------------------------------


		//-------------------------------------------------------------------------------------

		//setJMenuBar(JMenuBar);
		//setContentPane(ContentPane);
		
		setContentPane(new ConnectionPane());

		pack();
	}
	//******************************************************************************************
	/**
	 * Here is the only main method of the program, it launch the <b>client</b>.
	 * @param args the list of arguments send with the execution command. NOT USED
	 */
	public static void main(String[] args) {
		new Fenetre();
	}


}
