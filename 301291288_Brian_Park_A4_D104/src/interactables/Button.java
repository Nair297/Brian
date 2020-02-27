//Creates button when interacting with the figure, sloth, kitty, or plant

package interactables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import decorator.Visual;
import main.Panel;

public class Button {
	
	private int x, y, o;
	private Rectangle2D.Double box;
	private Area dBox;
	
	public Button(int x, int y, int o) {
		this.x = x;
		this.y = y;
		this.o = o;
		setShapeAttributes();
	}
	
	public void drawButton(Graphics2D g2) {
		AffineTransform t2 = g2.getTransform();
		g2.translate(x, y);
		g2.setColor(new Color(200, 200, 200, o));
		g2.fill(box);
		g2.setColor(new Color(0, 0, 0, o));
		g2.drawString("Flip", -20, 5);
		//g2.draw(dBox);
		g2.setTransform(t2);
	}
	
	private void setShapeAttributes() {
		box = new Rectangle2D.Double(-120/2, -70/2, 120, 70);
		dBox = new Area(box);
	}

	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(x, y);
		return at.createTransformedShape(dBox);
	}
	
	public boolean clicked(MouseEvent e) {
		return dBox().contains(e.getX(), e.getY());
	}
}
