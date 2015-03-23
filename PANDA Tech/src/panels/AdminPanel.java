package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import components.ImagePanel;
import components.OperationButton;

import controllers.admin.DownloadController;
import controllers.admin.FilesTableController;
import controllers.admin.PromoteController;
import controllers.admin.RejectController;
import controllers.admin.SynchronizeController;
import controllers.admin.ValidateController;
import controllers.admin.WPComboBoxController;
import frames.CollaboratorFrame;

public class AdminPanel extends ImagePanel {
private static final long serialVersionUID = 1L;
	
	private JPanel leftPanel = null;
	private ImagePanel centerPanel = null;
	private JScrollPane sectionPane = null;
	private JTable sectionTable = null;
	private JComboBox wpComboBox = null;
	private JPanel informationPanel = null;

	private JLabel titreLabel = null;
	private JLabel versionLabel = null;
	private JLabel dateLabel = null;
	private JLabel auteurLabel = null;
	private JLabel resumeLabel = null;

	private OperationButton downLoadButton = null;
	private OperationButton upLoadButton = null;
	private OperationButton synchroButton = null;
	private OperationButton validateButton = null;
	private OperationButton rejectButton = null;

	private JLabel fileLabel = null;

	private JButton collabButton = null;

	/**
	 * This is the default constructor
	 */
	public AdminPanel() {
		initialize();
		WPComboBoxController apcbc =new WPComboBoxController(sectionTable, wpComboBox, this);
		apcbc.initComboBox();
		wpComboBox.addActionListener(apcbc);
		FilesTableController aptc=new FilesTableController(this,sectionTable, titreLabel, versionLabel, dateLabel, auteurLabel, resumeLabel);
		sectionTable.addMouseListener(aptc);
		
		DownloadController dc = new DownloadController(this);
		downLoadButton.addMouseListener(dc);
		
		SynchronizeController sc=new SynchronizeController(this);
		synchroButton.addMouseListener(sc);
		
		PromoteController pc = new PromoteController(this);
		upLoadButton.addMouseListener(pc);
		
		ValidateController vc = new ValidateController(this);
		validateButton.addMouseListener(vc);
		
		RejectController rc = new RejectController(this);
		rejectButton.addMouseListener(rc);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1200, 480);
		this.setLayout(new BorderLayout());
		this.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/fond.png")));
		this.add(getLeftPanel(), BorderLayout.WEST);
		this.add(getCenterPanel(), BorderLayout.CENTER);
	}
	
	/**
	 * This method initializes leftPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getLeftPanel() {
		if (leftPanel == null) {
			leftPanel = new JPanel();
			leftPanel.setLayout(null);
			leftPanel.setPreferredSize(new Dimension(300, 1));
			leftPanel.setBackground(new Color(255, 255, 255,80));
			leftPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			leftPanel.add(getSectionPane(), null);
			leftPanel.add(getWpComboBox(), null);
			leftPanel.add(getCollabButton(), null);
		}
		return leftPanel;
	}
	

	/**
	 * This method initializes centerPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			
			centerPanel = new ImagePanel();
			centerPanel.setLayout(null);
			centerPanel.setBackground(new Color(255, 255, 255,80));
			centerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			centerPanel.add(getInformationPanel(), null);
			
			
		}
		return centerPanel;
	}

	/**
	 * This method initializes sectionPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSectionPane() {
		if (sectionPane == null) {
			sectionPane = new JScrollPane();
			sectionPane.setBounds(new Rectangle(30, 44, 264, 363));
			sectionPane.getViewport().setBackground(Color.WHITE);
			sectionPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(102, 153, 0), 2), "Files :", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.BOLD, 16), new Color(51, 153, 0)));
			sectionPane.setViewportView(getSectionTable());
			
		}
		return sectionPane;
	}

	/**
	 * This method initializes sectionTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
    private JTable getSectionTable() {
        if (sectionTable == null) {
            DefaultTableModel modeltable = new DefaultTableModel();
            modeltable.addColumn("File");
            modeltable.addColumn("State");
            sectionTable = new JTable(modeltable) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            sectionTable.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            sectionTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
            sectionTable.getTableHeader().setOpaque(false);
            sectionTable.getTableHeader().setForeground(Color.WHITE);
            sectionTable.setSelectionBackground(new Color(215, 240, 195));
            sectionTable.setSelectionForeground(Color.BLACK);
            sectionTable.getTableHeader().setBackground(new Color(102, 153, 0));
            sectionTable.setGridColor(new Color(70, 187, 23));
            sectionTable.setRowHeight(40);
            
            sectionTable.addMouseListener(new java.awt.event.MouseAdapter() {

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
  
                }
            });
        }
        return sectionTable;
    }

	/**
	 * This method initializes wpComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getWpComboBox() {
		if (wpComboBox == null) {
			wpComboBox = new JComboBox();
			wpComboBox.setBounds(new Rectangle(30, 10, 262, 28));
			wpComboBox.setOpaque(false);
			
		}
		return wpComboBox;
	}

	/**
	 * This method initializes informationPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getInformationPanel() {
		if (informationPanel == null) {
			
			
			fileLabel = new JLabel();
			fileLabel.setBounds(new Rectangle(38, 138, 58, 56));
			fileLabel.setIcon(new ImageIcon(getClass().getResource("/icons/file.png")));
			fileLabel.setText("");
			titreLabel = new JLabel();
			titreLabel.setBackground(Color.black);
			titreLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			titreLabel.setBounds(new Rectangle(100, 140, 300, 25));
			titreLabel.setText("Title : ");
			
			versionLabel = new JLabel();
			versionLabel.setBackground(Color.black);
			versionLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			versionLabel.setBounds(new Rectangle(100, 170, 300, 25));
			versionLabel.setText("Version : ");
			
			dateLabel = new JLabel();
			dateLabel.setBackground(Color.black);
			dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			dateLabel.setBounds(new Rectangle(100, 200, 300, 25));
			dateLabel.setText("Date : ");
			
			auteurLabel = new JLabel();
			auteurLabel.setBackground(Color.black);
			auteurLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			auteurLabel.setBounds(new Rectangle(100, 230, 300, 25));
			auteurLabel.setText("Author : ");
			
			resumeLabel = new JLabel();
			resumeLabel.setBackground(Color.black);
			resumeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			resumeLabel.setBounds(new Rectangle(100, 260, 661, 48));
			resumeLabel.setVerticalTextPosition(SwingConstants.TOP);
			resumeLabel.setText("Summary : ");
			
			informationPanel = new JPanel();
			informationPanel.setLayout(null);
			informationPanel.setBounds(new Rectangle(16, 40, 821, 411));
			informationPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(102, 153, 0), 2), "Informations :", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.BOLD, 16), new Color(51, 153, 0)));
			informationPanel.setBackground(new Color(255, 255, 255,100));
			informationPanel.add(titreLabel, null);
			informationPanel.add(versionLabel, null);
			informationPanel.add(dateLabel, null);
			informationPanel.add(auteurLabel, null);
			informationPanel.add(resumeLabel, null);
			informationPanel.add(fileLabel, null);
			informationPanel.add(getDownLoadButton(), null);
			informationPanel.add(getUpLoadButton(), null);
			informationPanel.add(getSynchroButton(), null);
			informationPanel.add(getValidateButton(), null);
			informationPanel.add(getRejectButton(), null);
			
			
		}
		return informationPanel;
	}

	/**
	 * This method initializes downLoadButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDownLoadButton() {
		if (downLoadButton == null) {
			downLoadButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/down.png")), "Download");
			downLoadButton.setBounds(new Rectangle(715, 15, 100, 70));
			downLoadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return downLoadButton;
	}
	
	/**
	 * This method initializes upLoadButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUpLoadButton() {
		if (upLoadButton == null) {
			upLoadButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/up.png")), "Promote");
			upLoadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			upLoadButton.setBounds(new Rectangle(715, 95, 100, 70));
		}
		return upLoadButton;
	}
	
	/**
	 * This method initializes synchroButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSynchroButton() {
		if (synchroButton == null) {
			synchroButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/refresh.png")), "Synchronize");
			synchroButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			synchroButton.setBounds(new Rectangle(715, 175, 100, 70));
		}
		return synchroButton;
	}
	
	/**
	 * This method initializes validateButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValidateButton() {
		if (validateButton == null) {
			validateButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/ok.png")), "Validate");
			validateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			validateButton.setBounds(new Rectangle(715, 255, 100, 70));
		}
		return validateButton;
	}
	
	/**
	 * This method initializes rejectButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRejectButton() {
		if (rejectButton == null) {
			rejectButton = new OperationButton(new ImageIcon(getClass().getResource("/icons/no.png")), "Reject");
			rejectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			rejectButton.setBounds(new Rectangle(715, 335, 100, 70));
		}
		return rejectButton;
	}

	/**
	 * This method initializes collabButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCollabButton() {
		if (collabButton == null) {
			collabButton = new JButton("Show collaborators");
			collabButton.setBounds(new Rectangle(30, 419, 262, 25));
			collabButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			collabButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					new CollaboratorFrame(AdminPanel.this).setVisible(true);
				
				}

            });
		}
		return collabButton;
	}


	
}
