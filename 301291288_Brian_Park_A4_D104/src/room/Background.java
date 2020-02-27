//Class for creating the base environment within the program

package room;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class Background {
	
	private BufferedImage img, img2;

	public Background(String file) {
		img = Image.loadImage(file);
	}

	public void drawRoom(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(0, 0);
		g2.drawImage(img, 0, 0, Panel.W, Panel.H, null);
		g2.setTransform(at);
	}
}
