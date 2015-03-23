package controllers.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WPComboBoxController implements ActionListener{
	
	private JTable sectionTable;
	private JComboBox wpBox;
	private JPanel panel;
	

	public WPComboBoxController(JTable sectionTable, JComboBox wpBox, JPanel panel) {
		this.sectionTable = sectionTable;
		this.wpBox=wpBox;
		this.panel=panel;
	}
	
	public void initTable(){
		
		DefaultTableModel dtm = (DefaultTableModel) sectionTable.getModel();

		while (dtm.getRowCount() != 0) {
            dtm.removeRow(0);
        }

		for (int i=1; i<11; i++){
			String section="Section "+i;
			
			String[] row = {section};
            dtm.addRow(row);
		}
	}
	
	public void initComboBox(){

		wpBox.addItem("No WorkPackage ");
		for (int i=1; i<11; i++){
			String section="Section : "+i;
			wpBox.addItem("WorkPackage "+i);

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		initTable();
		panel.repaint();
	}


}
