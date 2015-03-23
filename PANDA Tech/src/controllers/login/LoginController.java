package controllers.login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import panels.AdminPanel;
import panels.UserPanel;

import frames.LoginFrame;
import frames.MainFrame;

public class LoginController implements ActionListener {
	
	JTextField username; 
	JPasswordField password;
	JComboBox type;
	JLabel messageLabel;
	LoginFrame frame;
	MainFrame frame2;
	
	
	
	public LoginController(JTextField username, JPasswordField password, JComboBox type, JLabel messageLabel, LoginFrame frame, MainFrame frame2) {

		this.password = password;
		this.username = username;
		this.type=type;
		this.messageLabel=messageLabel;
		this.frame=frame;
		this.frame2=frame2;
	}

	public Boolean verifyUser(){
		
		if(this.username.getText())
			return true;
		else return false;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (verifyUser(username.getText(),password.getText())== true)
		{frame.dispose();
		 UserPanel up;
		 AdminPanel ap;
		if(type.getItemAt(type.getSelectedIndex())=="Writer")
		 {up=new UserPanel();
		  frame2.getContentPane().add(up, BorderLayout.CENTER);
		  }
		 else
		 {ap=new AdminPanel();
		 frame2.getContentPane().add(ap, BorderLayout.CENTER);
		 }
		 
		 
		 MainFrame.idfLabel.setText(" Connected  :  Admin");
		 MainFrame.firstNameLabel.setText(" First Name  :  Admin");
		 MainFrame.lastNameLabel.setText(" Last Name  :  Administrateur");
		 MainFrame.orgLabel.setText(" Organisation  : ");
		 MainFrame.fonctionLabel.setText(" Fonction  : ");
		 MainFrame.connected=true;
		 MainFrame.connectButton.setIcon(new ImageIcon(getClass().getResource("/icons/logout.png")));
		 
		}
		else messageLabel.setText("The username or the password is wrong !");
	}

}
