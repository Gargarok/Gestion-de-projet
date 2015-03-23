package components;



import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     *
     */
    Image image = null;

    public ImagePanel(Image image) {
        this.image = image;


    }

    public ImagePanel() {
    }

    public void setImage(Image image) {
        this.image = image;
        repaint();
        Graphics g = null;
        if (isShowing() && image != null) {
            try {
                update(g);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
        }

    }

    public Image getImage() {
        return image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        if (image != null) { //there is a picture: draw it
            int height = this.getSize().height;
            int width = this.getSize().width;
            g.drawImage(image, 0, 0, this); //use image size          
            g.drawImage(image, 0, 0, width, height, this);
        }
    }
}// 