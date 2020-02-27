//uperclass for all Decorator subclasses

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import main.Panel;

public abstract class ObjectVisual implements Visual{
	
	protected Visual base;
	
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public static void textBox(Graphics2D g2, String s1, String s2, String s3, String s4) {
		Font f = new Font("ITC Legacy Sans", Font.PLAIN, 24);
		AffineTransform t = g2.getTransform();
		//g2.translate(0, 0);
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(0, 450, Panel.W, 150));
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(10));
		g2.draw(new Rectangle2D.Double(5, 445, Panel.W-8, 150));
		g2.setFont(f);
		g2.drawString(s1, 20, 480);
		g2.drawString(s2, 20, 512);
		g2.drawString(s3, 20, 544);
		g2.drawString(s4, 20, 576);
		g2.setTransform(t);
	}
}
