package vuesclient;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConnectionPane extends JPanel{
	private static final long serialVersionUID = -5998221824092664574L;

	JTextField login = new JTextField();
	JPasswordField password = new JPasswordField();
	JButton valider = new JButton("connection");
	
	public ConnectionPane() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = Constante.getGBC();
		
		login.setPreferredSize(Constante.normalsize);
		password.setPreferredSize(Constante.normalsize);
		valider.setPreferredSize(Constante.normalsize);

		gbc.gridy=0;
		add(new JLabel("Login :"),gbc);
		gbc.gridy=1;
		add(login,gbc);
		gbc.gridy=2;
		add(new JLabel("Password :"),gbc);
		gbc.gridy=3;
		add(password,gbc);
		gbc.gridy=4;
		add(new JLabel(" "),gbc);
		gbc.gridy=5;
		add(valider,gbc);
		
		
		
	}
}
