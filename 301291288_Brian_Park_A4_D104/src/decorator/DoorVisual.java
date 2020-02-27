//Displays text when interacting with door object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class DoorVisual extends ObjectVisual{
	
	private BufferedImage img, img2;
	private int door;
	
	public DoorVisual(Visual base, int door) {
		this.base = base;
		this.door = door;
		img = Image.loadImage("Objects/Shrine1.png");
		img2 = Image.loadImage("Lucy Sprite/Portrait.png");
	}
	
	public void display(Graphics2D g2) {
		base.display(g2);	
		AffineTransform t = g2.getTransform();
		g2.translate(Panel.W/2, Panel.H/3);
		
		if (door > 8 && door < 14) {
			g2.setColor(Color.white);
			g2.fill(new Rectangle2D.Double(-150, -150, 300, 300));
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.draw(new Rectangle2D.Double(-150, -150, 300, 300));
		}
		if (door > 8 && door < 12) {
			g2.scale(0.2, 0.2);
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		}
		if (door == 13) {
			g2.scale(0.45, 0.45);
			g2.drawImage(img2, -img2.getWidth()/2, -img2.getHeight()/2, null);
		}
		g2.setTransform(t);
		
		if (door == 1)
			textBox(g2, "The door to the closet is locked. I need to find the key.", "", "", "");
		if (door == 3)
			textBox(g2, "The door is unlocked. let's see what's inside.", "", "", "");
		if (door == 5)
			textBox(g2, "...", "", "", "");
		if (door == 7)
			textBox(g2, "This is...", "", "", "");
		if (door == 9)
			textBox(g2, "...a memorial shrine.", "", 
					"There's a photo of someone...", "...and a message.");
		if (door == 11)
			textBox(g2, "May your spirit find peace on the other side...", "", "", "");
		if (door == 13)
			textBox(g2, "Lucy.", "", "", "");
	}
}
