//Displays text and image when interacting with figure object

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

public class FigureVisual extends ObjectVisual{
	
	private BufferedImage img, img2;
	private int figure;
	private int f;
	
	public FigureVisual(Visual base, int figure, int flip) {
		this.base = base;
		f = flip;
		img = Image.loadImage("Objects/miku1.jpg");
		img2 = Image.loadImage("Objects/miku2.jpg");
		this.figure = figure;
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
		if (f == 0)
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		if (f == 1)
			g2.drawImage(img2, -img2.getWidth()/2, -img2.getHeight()/2, null);
		g2.setTransform(t);
		textBox(g2, "I'm pretty sure I got this from Japan.", "", "", "");
	}
}
