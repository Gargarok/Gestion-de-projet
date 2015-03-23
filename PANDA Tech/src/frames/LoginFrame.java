package frames;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import components.ImagePanel;
import components.MenuButton;

import controllers.login.LoginController;

public class LoginFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private ImagePanel jContentPane = null;
	private JTextField userField = null;
	private JPasswordField passwordField = null;
	private JLabel userLabel = null;
	private JLabel passwordLabel = null;
	private MenuButton connectButton = null;
	private JLabel messageLabel = null;
	private JComboBox typeComboBox = null;
	/**
	 * @param owner
	 */
	public LoginFrame(Frame owner) {
		super(owner);
		initialize();
		LoginController lc = new LoginController(userField, passwordField, typeComboBox, messageLabel, LoginFrame.this, (MainFrame) owner);
		connectButton.addActionListener(lc);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(475, 303);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(this.getParent());
		this.setModal(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private ImagePanel getJContentPane() {
		if (jContentPane == null) {
			messageLabel = new JLabel();
			messageLabel.setBounds(new Rectangle(68, 226, 328, 35));
			messageLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			messageLabel.setText("");
			passwordLabel = new JLabel();
			passwordLabel.setBounds(new Rectangle(65, 80, 85, 30));
			passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			passwordLabel.setText("Password :");
			userLabel = new JLabel();
			userLabel.setBounds(new Rectangle(65, 30, 85, 30));
			userLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			userLabel.setText("Username:");
			jContentPane = new ImagePanel();
			jContentPane.setLayout(null);
			jContentPane.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/fond2.jpg")));
			jContentPane.add(getUserField(), null);
			jContentPane.add(getPasswordField(), null);
			jContentPane.add(userLabel, null);
			jContentPane.add(passwordLabel, null);
			jContentPane.add(getConnectButton(), null);
			jContentPane.add(messageLabel, null);
			jContentPane.add(getTypeComboBox(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes userField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUserField() {
		if (userField == null) {
			userField = new JTextField();
			userField.setBounds(new Rectangle(150, 30, 180, 30));
			userField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		}
		return userField;
	}

	/**
	 * This method initializes passwordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(150, 80, 180, 30));
			passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		}
		return passwordField;
	}

	/**
	 * This method initializes connectButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private MenuButton getConnectButton() {
		if (connectButton == null) {
			connectButton = new MenuButton(null,"Login","Enter your Username and Password to login");
			connectButton.setBounds(new Rectangle(149, 115, 184, 72));
			connectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}
		return connectButton;
	}

	/**
	 * This method initializes typeComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTypeComboBox() {
		if (typeComboBox == null) {
			typeComboBox = new JComboBox();
			typeComboBox.setBounds(new Rectangle(150, 194, 184, 25));
			typeComboBox.addItem("Writer");
			typeComboBox.addItem("Admin Chapter");
			typeComboBox.addItem("Admin Volume");
			typeComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return typeComboBox;
	}

}  //  @jve:decl-index=0:visual-constraint="116,72"
