//Ending screen that congratulates user for completing application

package room;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class Ending {
	
	private float x, y;
	private Rectangle2D.Double box;
	private Area dBox;
	private Color button;
	private BufferedImage img;
	
	public Ending() {
		this.x = 200;
		this.y = 75;
		this.button = (Color.green);
		setShapeAttributes();
		img = Image.loadImage("Objects/sisters.png");
	}

	public void drawEnding(Graphics2D g2, int o) {
		//background
		g2.setColor(new Color(0, 0, 0, o));
		g2.fill(new Rectangle2D.Double(0, 0, Panel.W, Panel.H));
		
		if (o >= 254) {
			//pic
			AffineTransform t = g2.getTransform();
			g2.translate(Panel.W/2, Panel.H/2-20);
			g2.scale(0.2, 0.2);
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
			g2.setTransform(t);
			
			//text
			AffineTransform at2 = g2.getTransform();
			g2.translate(Panel.W/2, Panel.H/6);
			Font f = new Font("Times New Roman", Font.BOLD, 54);
			g2.setFont(f);
			FontMetrics m = g2.getFontMetrics(f);
			g2.setColor(Color.white);		
			String s = String.format("THANK YOU FOR PLAYING"); 
			g2.drawString(s, -m.stringWidth(s)/2, 0);
			g2.setTransform(at2);	
			
			//restart button
			AffineTransform at3 = g2.getTransform();
			g2.translate(Panel.W/2, 2.5*Panel.H/3);
			g2.setColor(button);
			g2.fill(box);
			Font f2 = new Font("Times New Roman", Font.PLAIN, 36);
			g2.setFont(f2);
			FontMetrics m2 = g2.getFontMetrics(f2);
			g2.setColor(Color.black);
			String s2 = String.format("RESTART");
			g2.drawString(s2, -m2.stringWidth(s2)/2, 10);
			g2.setTransform(at3);
		}
	}
	
	private void setShapeAttributes() {
		box = new Rectangle2D.Double(-x/2, -y/2, x, y);
		dBox = new Area(box);
	}

	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, 2.5*Panel.H/3);
		return at.createTransformedShape(dBox);
	}
	
	public boolean clicked(MouseEvent e) {
		return dBox().contains(e.getX(), e.getY());
	}
}
