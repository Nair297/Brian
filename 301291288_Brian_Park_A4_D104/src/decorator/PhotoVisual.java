//Displays text and image when interacting with photo object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class PhotoVisual extends ObjectVisual{
	
	private BufferedImage img;
	
	public PhotoVisual(Visual base) {
		this.base = base;
		img = Image.loadImage("Objects/sisters.png");
	}
	
	public void display(Graphics2D g2) {
		base.display(g2);
		AffineTransform t = g2.getTransform();
		g2.translate(Panel.W/2, Panel.H/3);
		
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(-150, -150, 300, 300));
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(10));
		g2.draw(new Rectangle2D.Double(-150, -150, 300, 300));
		
		g2.scale(0.2, 0.2);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setTransform(t);
		textBox(g2, "I remember when we took this photo together.", "", "", "");
	}
}
