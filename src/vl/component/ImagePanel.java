package vl.component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	
	private double height = 0;
	private double width = 450;

	public ImagePanel(String path) {
	
		
		try {
			
			image = ImageIO.read(new File(path));
			
			height = image.getHeight() / (image.getWidth() / width);
			
			
		} catch (IOException ex) {
			// handle exception...
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, (int)width, (int)height, null);
	}

}
