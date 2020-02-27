//Displays text and image when interacting with sloth object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class SlothVisual extends ObjectVisual{
	
	private BufferedImage img, img2;
	private int sloth;
	private int f;
	
	public SlothVisual(Visual base, int sloth, int flip) {
		this.base = base;
		f = flip;
		img = Image.loadImage("Objects/sloth1.jpg");
		img2 = Image.loadImage("Objects/sloth2.jpg");
		this.sloth = sloth;
	}
	
	public void display(Graphics2D g2) {
		base.display(g2);
		AffineTransform t = g2.getTransform();
		g2.translate(Panel.W/2, Panel.H/3);
		
		if (sloth == 1) {
			g2.setColor(Color.white);
			g2.fill(new Rectangle2D.Double(-150, -150, 300, 300));
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.draw(new Rectangle2D.Double(-150, -150, 300, 300));
		}
		
		g2.scale(0.2, 0.2);
		if (f == 0 && sloth == 1)
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		if (f == 1 && sloth == 1)
			g2.drawImage(img2, -img2.getWidth()/2, -img2.getHeight()/2, null);
		g2.setTransform(t);
		if (sloth == 1)
			textBox(g2, "I LOVE SLOTHS.", "", "", "");
		if (sloth == 3)
			textBox(g2, "It's a letter I got on my birthday.", "", "", "");
		if (sloth == 4)
			textBox(g2, 
			"HAPPY BIRTHDAY TO THE BEST BIG SISTER IN THE WORLD!", 
			"Hope you have a good one. Here's a sloth to add even more",
			"fluffiness to your life.", "	- love, Lily :)");
	}
}
