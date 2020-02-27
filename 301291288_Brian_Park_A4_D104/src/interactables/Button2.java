//Creates 5 buttons when interacting with upod

package interactables;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import main.Panel;

public class Button2 {
	
	private float x, y;
	private Rectangle2D.Double box1, box2, box3, box4, box5;
	private Area dBox1, dBox2, dBox3, dBox4, dBox5;
	
	public Button2() {
		this.x = 120;
		this.y = 70;
		setShapeAttributes();
	}
	
	public void drawButton(Graphics2D g2) {
		AffineTransform t2 = g2.getTransform();
		g2.translate(Panel.W/2, Panel.H);
		g2.setColor(Color.red);
		g2.fill(box1);
		g2.fill(box2);
		g2.fill(box3);
		g2.fill(box4);
		g2.fill(box5);
		Font f = new Font("ITC Legacy Sans", Font.PLAIN, 12);
		g2.setFont(f);
		g2.setColor(Color.white);
		g2.drawString("Pure Nostalgia", -41, -197);
		g2.drawString("Addictive K-Pop", -46, -287);
		g2.drawString("Something Classy", -49, -377);
		g2.drawString("For a Workout", -41, -467);
		g2.drawString("Video Game Music", -53, -557);
		g2.setTransform(t2);
	}
	
	private void setShapeAttributes() {
		box1 = new Rectangle2D.Double(-x/2, -y/2-200, x, y);
		box2 = new Rectangle2D.Double(-x/2, -y/2-290, x, y);
		box3 = new Rectangle2D.Double(-x/2, -y/2-380, x, y);
		box4 = new Rectangle2D.Double(-x/2, -y/2-470, x, y);
		box5 = new Rectangle2D.Double(-x/2, -y/2-560, x, y);
		
		dBox1 = new Area(box1);
		dBox2 = new Area(box2);
		dBox3 = new Area(box3);
		dBox4 = new Area(box4);
		dBox5 = new Area(box5);
	}

	public Shape dBox1() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, Panel.H);
		return at.createTransformedShape(dBox1);
	}
	
	public Shape dBox2() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, Panel.H);
		return at.createTransformedShape(dBox2);
	}
	
	public Shape dBox3() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, Panel.H);
		return at.createTransformedShape(dBox3);
	}
	
	public Shape dBox4() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, Panel.H);
		return at.createTransformedShape(dBox4);
	}
	
	public Shape dBox5() {
		AffineTransform at = new AffineTransform();		
		at.translate(Panel.W/2, Panel.H);
		return at.createTransformedShape(dBox5);
	}
	
	public boolean clicked1(MouseEvent e) {
		return dBox1().contains(e.getX(), e.getY());
	}
	
	public boolean clicked2(MouseEvent e) {
		return dBox2().contains(e.getX(), e.getY());
	}
	
	public boolean clicked3(MouseEvent e) {
		return dBox3().contains(e.getX(), e.getY());
	}
	
	public boolean clicked4(MouseEvent e) {
		return dBox4().contains(e.getX(), e.getY());
	}
	
	public boolean clicked5(MouseEvent e) {
		return dBox5().contains(e.getX(), e.getY());
	}
}
