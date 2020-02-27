//Displays text and image when interacting with plant object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class PlantVisual extends ObjectVisual{
	
	private BufferedImage img, img2;
	private int plant;
	private int key;
	
	public PlantVisual(Visual base, int plant, int key) {
		this.base = base;
		img = Image.loadImage("Objects/plant1.png");
		img2 = Image.loadImage("Objects/key.png");
		this.plant = plant;
		this.key = key;
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
		if (key == 0)
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		if (key == 1)
			g2.drawImage(img2, -img2.getWidth()/2, -img2.getHeight()/2+500, null);
		if (key > 0)
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2-300, null);
		
		g2.setTransform(t);
		if (key == 0)
			textBox(g2, "I'm surprised I managed to keep it alive for so long.", "", "", "");
		if (key == 2)
			textBox(g2, "I got the key under the plant! Now I can finally open my closet.", "", "", "");
	}
}
