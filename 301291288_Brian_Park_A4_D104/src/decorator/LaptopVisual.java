//Displays text and passcode system when interacting with laptop object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class LaptopVisual extends ObjectVisual{
	
	String a, b, c, d;
	private int laptop;
	
	public LaptopVisual(Visual base, int laptop, String a, String b, String c, String d) {
		this.base = base;
		this.laptop = laptop;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public void display(Graphics2D g2) {
		base.display(g2);
		
		if (laptop > 0 && laptop < 6) {
			AffineTransform t = g2.getTransform();
			g2.translate(Panel.W/2, Panel.H/3);
		
			g2.setColor(Color.white);
			g2.fill(new Rectangle2D.Double(-150, -150, 300, 300));
			g2.setColor(Color.black);
			g2.setStroke(new BasicStroke(10));
			g2.draw(new Rectangle2D.Double(-150, -150, 300, 300));
		
			Font f = new Font("ITC Legacy Sans", Font.PLAIN, 50);
			g2.setFont(f);
			g2.drawString(a, -75, 0);
			g2.drawString(b, -35, 0);
			g2.drawString(c, 5, 0);
			g2.drawString(d, 45, 0);
			g2.setTransform(t);
		}
		
		if (laptop == 1)
			textBox(g2, 
			"I need to type in my passcode to unlock my laptop.", "", "", "");
		if (laptop == 5) textBox(g2, "WRONG PASSCODE. Try again.", "", "", "");
		if (laptop == 7) textBox(g2, "That was easy.", "", "", "");
		if (laptop == 9)
			textBox(g2, 
			"I have 1 email in my inbox.", 
			"Received on December 19th.", "", "");
		if (laptop == 11)
			textBox(g2, 
			"Hi Lucy,", 
			"How u holding up sis? Sorry you had to see me break down",
			"yesterday.", "");
		if (laptop == 13)
			textBox(g2, 
			"Btw, I noticed u were drinking again so I tidied ur room a bit. I",
			"found ur secret stash in ur closet. U still keep the key under the",
			"potted plant I see. Anyways, back to the topic.", "");
		if (laptop == 15)
			textBox(g2, 
			"Plase stop worrying about me anymore. It's only gonna hurt our",
			"family if you keep bringing it up. And if you fight with the bullies", 
			"again like last time, it'll only make matters worse.", "");
		if (laptop == 17)
			textBox(g2,
			"Don't take it too personally. Things will be better off this way.", 
			"", "", "- Lily.");
	}
}