package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

import components.ImagePanel;
import components.OperationButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImagePanel jContentPane = null;
	private JPanel northPanel = null;
	public static OperationButton connectButton = null;
	private JLabel userLabel = null;
	public static JLabel idfLabel = null;
	public static JLabel firstNameLabel = null;
	public static JLabel lastNameLabel = null;
	public static JLabel orgLabel = null;
	public static JLabel fonctionLabel = null;
	public static boolean connected=false;
	/**
	 * This is the default constructor
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public MainFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize()  {
		    
		 	this.setSize(1200, 560);
	        this.setResizable(false);
	        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/panda_tech.jpg")));
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setContentPane(getJContentPane());
	        this.setTitle("PANDA_Tech");
	        this.setLocationRelativeTo(this.getParent());
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private ImagePanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new ImagePanel();		
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/fond.png")));
			jContentPane.add(getNorthPanel(), BorderLayout.NORTH);
			//jContentPane.add(getCenterPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes northPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getNorthPanel() {
		if (northPanel == null) {
			
			userLabel = new JLabel();
			userLabel.setBounds(new Rectangle(0, 0, 53, 80));
			userLabel.setText("");
			userLabel.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));
			
			idfLabel = new JLabel();
			idfLabel.setBounds(new Rectangle(80, 0, 200, 20));
			idfLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			idfLabel.setText("");
			
			firstNameLabel = new JLabel();
			firstNameLabel.setBounds(new Rectangle(80, 30, 200, 20));
			firstNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			firstNameLabel.setText("Disconnected ");
			
			lastNameLabel = new JLabel();
			lastNameLabel.setBounds(new Rectangle(80, 60, 200, 20));
			lastNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lastNameLabel.setText("");
			
			orgLabel = new JLabel();
			orgLabel.setBounds(new Rectangle(300, 0, 200, 20));
			orgLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			orgLabel.setText("");
			
			fonctionLabel = new JLabel();
			fonctionLabel.setBounds(new Rectangle(300, 30, 200, 20));
			fonctionLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			fonctionLabel.setText("");
			
			
			northPanel = new JPanel();
			northPanel.setLayout(null);
			northPanel.setPreferredSize(new Dimension(1, 80));
			northPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			northPanel.setBackground(new Color(255, 255, 255));
			northPanel.add(getConnectButton(), null);
			northPanel.add(userLabel, null);
			northPanel.add(idfLabel, null);
			northPanel.add(firstNameLabel, null);
			northPanel.add(lastNameLabel, null);
			northPanel.add(orgLabel, null);
			northPanel.add(fonctionLabel, null);
		}
		return northPanel;
	}



	/**
	 * This method initializes connectButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private OperationButton getConnectButton() {
		if (connectButton == null) {
			connectButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/login.png")), "");
			connectButton.setSize(new Dimension(78, 78));
			connectButton.setLocation(new Point(1114, 1));
			connectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			connectButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if ( ! connected)
					new LoginFrame(MainFrame.this).setVisible(true);
					else
					{
						int reponse = JOptionPane.showConfirmDialog(null, "<html> Do you want to quit the application ?</html>", "PANDA_Tech", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
		                if (reponse == JOptionPane.OK_OPTION) {
		                    
		                 MainFrame.this.jContentPane.remove(MainFrame.this.jContentPane.getComponent(1));
		                 MainFrame.this.jContentPane.repaint();
						 MainFrame.idfLabel.setText("");
						 MainFrame.firstNameLabel.setText("Disconnected");
						 MainFrame.lastNameLabel.setText("");
						 MainFrame.orgLabel.setText("");
						 MainFrame.fonctionLabel.setText("");
						 MainFrame.connected=false;
						 MainFrame.connectButton.setIcon(new ImageIcon(getClass().getResource("/icons/login.png")));
		                }
					}
					
				}

            });
		}
		return connectButton;
	}

	

}
