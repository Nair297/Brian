//Window background during the day

package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import main.Panel;

public class Day extends ObjectVisual{
	
	private GeneralPath sun;
	
	public Day(Visual base) {
		this.base = base;
		
		int x[] = {83, 27, 55};
		int y[] = {96, 96, 0};
		sun = new GeneralPath();
		sun.moveTo(x[0], y[0]);
		for (int i = 1; i < x.length; i++)
			sun.lineTo(x[i], y[i]);
		sun.closePath();
	}
	
	public void display(Graphics2D g2) {
		AffineTransform t = g2.getTransform();
		g2.translate(Panel.W-140, Panel.H/3-120);
		g2.setColor(new Color(100, 180, 250));
		g2.fillRect(-100, -100, 300, 300);
		
		AffineTransform t2 = g2.getTransform();	
		g2.scale(0.3, 0.3);
		for (int i = 1; i <= 35; i++) {
			g2.rotate(10); // rotate the drawing space
			g2.setColor(new Color(250, 100, 100));
			g2.fill(sun);
		}
		g2.setTransform(t2);
		g2.setColor(Color.yellow);
		g2.fillOval(-25, -25, 50, 50);
		
		g2.setTransform(t);
	}
}
