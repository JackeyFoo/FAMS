package vl.component;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

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
	private String imagpath;
	private long clickTime = 0;

	public ImagePanel(String path) {

		imagpath = path;
		try {

			image = ImageIO.read(new File(path));

			height = image.getHeight() / (image.getWidth() / width);

			this.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {

					if (checkClickTime()) {
						try {
							
							Desktop d = Desktop.getDesktop();
							d.open(new File(imagpath));
							
						} catch (IOException ed) {
							System.out.println(ed);
						}

					}
				}

			});

		} catch (IOException ex) {
			// handle exception...
		}
	}

	public double getheight() {

		return height;
	}

	// Ê±¼äÅÐ¶Ïº¯Êý
	public boolean checkClickTime() {

		long nowTime = (new Date()).getTime();

		if ((nowTime - clickTime) < 300) {

			clickTime = nowTime;
			return true;
		}

		clickTime = nowTime;
		return false;
	}

	@Override
	public void paintComponent(Graphics g) {

		g.drawImage(image, 0, 0, (int) width, (int) height, null);

	}
}
