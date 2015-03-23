/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Yoonux
 */
public class MenuButton extends JButton {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
    private String title;
    private String description;
    private boolean isSelected = false;
    private static Font BUTTON_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    public MenuButton(ImageIcon icon, String title, String description) {
        super();
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.build();
        this.setBackground(new Color(111, 160, 219));
        this.setForeground(Color.BLACK);
        this.setContentAreaFilled(false);
        this.setFocusable(false);
        this.setFont(BUTTON_FONT);

        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setContentAreaFilled(true);
                setForeground(new Color(38, 90, 154));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!isSelected) {                   
                    setForeground(Color.BLACK);
                }
                setContentAreaFilled(false);
            }
        });
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    public void setLargeText(String title, String description){
        this.title = title;
        this.description = description;

            this.setText("<html><b>" + this.title + "</b><br/>" + this.description + "</html>");

    }

    private void build() {
        this.setIcon(this.icon);

            this.setText("<html><b>" + this.title + "</b><br/>" + this.description + "</html>");
  
    }
}
