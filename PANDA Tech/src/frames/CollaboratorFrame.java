package frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import components.OperationButton;
import controllers.admin.AddUserController;
import controllers.login.LoginController;

public class CollaboratorFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane collabPane = null;
	private JTable collabTable = null;
	private OperationButton addButton = null;
	private OperationButton editButton = null;
	private OperationButton removeButton = null;
	/**
	 * @param owner
	 */
	public CollaboratorFrame(JPanel owner) {

		initialize();
		AddUserController auc = new AddUserController();
		addButton.addMouseListener(auc);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(820, 418);
		this.setTitle("Collaborators");
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(this.getParent());
		this.setModal(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.white);
			jContentPane.add(getCollabPane(), null);
			jContentPane.add(getAddButton(), null);
			jContentPane.add(getModifyButton(), null);
			jContentPane.add(getDeleteButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes collabPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getCollabPane() {
		if (collabPane == null) {
			collabPane = new JScrollPane();
			collabPane.setBorder(BorderFactory.createLineBorder(new Color(70, 187, 23), 2));
			collabPane.setSize(new Dimension(644, 316));
			collabPane.setLocation(new Point(29, 31));
			collabPane.getViewport().setBackground(Color.white);
			collabPane.setViewportView(getCollabTable());
		}
		return collabPane;
	}

	/**
	 * This method initializes collabTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getCollabTable() {
		if (collabTable == null) {
			DefaultTableModel modeltable = new DefaultTableModel();
            modeltable.addColumn("L.Name");
            modeltable.addColumn("F.Name");
            modeltable.addColumn("Prefession");
            collabTable = new JTable(modeltable) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            collabTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            collabTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
            collabTable.getTableHeader().setOpaque(false);
            collabTable.getTableHeader().setForeground(Color.WHITE);
            collabTable.setSelectionBackground(new Color(215, 240, 195));
            collabTable.setSelectionForeground(Color.BLACK);
            collabTable.getTableHeader().setBackground(new Color(70, 187, 23));
            collabTable.setGridColor(new Color(70, 187, 23));
            collabTable.setRowHeight(40);
		}
		return collabTable;
	}

	/**
	 * This method initializes addButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private OperationButton getAddButton() {
		if (addButton == null) {
			addButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/add.png")), "Add");
			addButton.setBounds(new Rectangle(700, 50, 80, 80));
			addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return addButton;
	}

	/**
	 * This method initializes modifyButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private OperationButton getModifyButton() {
		if (editButton == null) {
			editButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/edit.png")), "Edit");
			editButton.setBounds(new Rectangle(700, 150, 80, 80));
			editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return editButton;
	}

	/**
	 * This method initializes deleteButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private OperationButton getDeleteButton() {
		if (removeButton == null) {
			removeButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/remove.png")), "Remove");
			removeButton.setBounds(new Rectangle(700, 250, 80, 80));
			removeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return removeButton;
	}

}  //  @jve:decl-index=0:visual-constraint="48,0"
