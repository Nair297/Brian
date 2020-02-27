//Title screen before initiating the project to instruct user and explain premise

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

import tools.Image;
import main.Panel;

public class Title {
	private float x, y;
	private BufferedImage img;
	private Rectangle2D.Double box;
	private Area dBox;
	private Color button;
	
	public Title() {
		this.x = 200;
		this.y = 75;
		this.button = (Color.LIGHT_GRAY);
		img = Image.loadImage("Lucy Sprite/portrait.png");
		setShapeAttributes();
	}
	
	public void draw(Graphics2D g2) {
		//background
		AffineTransform at = g2.getTransform();
		g2.translate(0, 0);
		g2.setColor(Color.black);
		g2.fillRect(0, 0, Panel.W, Panel.H);
		g2.setTransform(at);
		
		//title
		AffineTransform at2 = g2.getTransform();
		g2.translate(Panel.W/2, .5*Panel.H/4);
		Font f = new Font("Times New Roman", Font.BOLD, 72);
		g2.setFont(f);
		FontMetrics m = g2.getFontMetrics(f);
		g2.setColor(Color.white);		
		String s = String.format("THE ROOM"); 
		g2.drawString(s, -m.stringWidth(s)/2, 0);
		g2.setTransform(at2);		
		
		//instructions
		AffineTransform at4 = g2.getTransform();
		g2.translate(Panel.W/2.3, Panel.H/4);
		Font f3 = new Font("ITC Legacy Sans", Font.PLAIN, 24);
		g2.setFont(f3);
		FontMetrics m3 = g2.getFontMetrics(f3);
		String t1 = String.format("My name is Lucy"); 
		String t2 = String.format("and this is my room."); 
		String t3 = String.format("Something strange happened recently"); 
		String t4 = String.format("but I can't remember what."); 
		String t5 = String.format("The answer to this mystery may be");
		String t6 = String.format("in the closet...");
		g2.drawString(t1, 0, 0);
		g2.drawString(t2, 0, 25);
		g2.drawString(t3, 0, 50);
		g2.drawString(t4, 0, 75);
		g2.drawString(t5, 0, 100);
		g2.drawString(t6, 0, 125);	
		g2.setTransform(at4);	
		
		//controls
		AffineTransform at5 = g2.getTransform();
		g2.translate(Panel.W/10, 2.7*Panel.H/4);
		String t7 = String.format("Arrow Keys = Move"); 
		String t8 = String.format("Space = While '!' visible: Interact / Back"); 
		String t9 = String.format("Mouse = With certain objects: Select and Confirm"); 
		g2.drawString(t7, 0, 0);
		g2.drawString(t8, 0, 25);
		g2.drawString(t9, 0, 50);
		g2.setTransform(at5);	
		
		//pic
		AffineTransform at6 = g2.getTransform();
		g2.translate(Panel.W/5, 1.5*Panel.H/4);
		g2.scale(0.3, 0.3);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setTransform(at6);
		
		//button
		AffineTransform at3 = g2.getTransform();
		g2.translate(Panel.W/2, 2.7*Panel.H/3);
		g2.setColor(button);
		g2.fill(box);
		Font f2 = new Font("Times New Roman", Font.PLAIN, 36);
		g2.setFont(f2);
		FontMetrics m2 = g2.getFontMetrics(f2);
		g2.setColor(Color.black);
		String s2 = String.format("START");
		g2.drawString(s2, -m2.stringWidth(s2)/2, 10);
		g2.setTransform(at3);
	}
	
	private void setShapeAttributes() {
		box = new Rectangle2D.Double(-x/2, -y/2, x, y);
		dBox = new Area(box);
	}

	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, 2.7*Panel.H/3);
		return at.createTransformedShape(dBox);
	}
	
	public boolean clicked(MouseEvent e) {
		return dBox().contains(e.getX(), e.getY());
	}
}

