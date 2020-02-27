//Window background during the night

package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import main.Panel;
import processing.core.PApplet;

public class Night extends ObjectVisual{
	
	private PApplet p;
	private float x, y, start;

	public Night(Visual base) {
		this.base = base;
		p = new PApplet();
		start = (float) (Math.random()*10);
		x = start;
		y = (float) (Math.random()*10);
	}
	
	public void display(Graphics2D g2) {
		AffineTransform t = g2.getTransform();
		g2.translate(Panel.W-140, Panel.H/3-120);	
		g2.setColor(new Color(50, 50, 150));
		g2.fillRect(-100, -100, 300, 300);
		
		g2.setColor(new Color(250, 250, 150));
		g2.fillOval(-5, -25, 35, 35);
		g2.setColor(new Color(50, 50, 150));
		g2.fillOval(5, -20, 26, 26);
		
		g2.setColor(new Color(180, 180, 180));
		g2.scale(0.5,  0.5);		
		g2.translate(45, 30);
		cloud2(g2, 0, 0, 40);	
		g2.scale(0.9,  0.9);	
		g2.translate(110, -80);
		cloud2(g2, 0, 0, 30);
		
		g2.setTransform(t);
	}
	
	public void cloud2(Graphics2D g2, float x, float y, float d) {
		AffineTransform at = g2.getTransform();
		g2.translate(x, y);
		g2.fill(new Ellipse2D.Float(-d/2, -d/2, d, d ));
		g2.fill(new Ellipse2D.Float(-d/2-10, -d/2+10, d, d ));
		g2.setTransform(at);
	
		if (d > 20) {
			d *= 0.7;
			cloud2(g2, x+d, y, d);
			cloud2(g2, x-d, y, d);
		}
	}
	
	//unused
	public void cloud(Graphics2D g2) {
		float noise;
		
		for (int y = 0; y <= 10; y += 1) {
			y += 0.1;
			x = start;
			
			for (int x = 0; x <= 30; x += 1) {
				x += 0.1;
				noise = p.noise(x, x);
				
				AffineTransform t = g2.getTransform();
				g2.translate(x, y);
				g2.rotate(noise * 31000);
				float d = noise*35;
				int g = (int) (150 + (noise*50));
				int o = (int) (150 + (noise*105));
				g2.setColor(new Color(g, g, g, o));
				g2.fill(new Ellipse2D.Float(-d/2, -d/4, d, d));
				g2.setTransform(t);
			}
		}
	}
}
