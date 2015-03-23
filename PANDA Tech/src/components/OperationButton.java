package components;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author user
 */
public class OperationButton extends JButton {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
    private String description;
    private static Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 13);

    public OperationButton(ImageIcon icon, String description) {
        super();
        this.icon = icon;
        this.description = description;
        this.build();
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFont(BUTTON_FONT);

        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setContentAreaFilled(false);
            }
        });
    }

    private void build() {
        this.setIcon(this.icon);
        this.setText("<html><div style='text-align : center'>" + this.description + "</div></html>");
    }
}
