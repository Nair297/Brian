//Object for displaying text

package interactables;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import main.Panel;
import tools.Image;

public class TV extends Object{

	public TV(double x, double y, double s) {
		super(x, y, s);
		img = Image.loadImage("Objects/TV.png");
		setShapeAttributes();
	}
	
	public void drawObject(Graphics2D g2) {
		AffineTransform t = g2.getTransform();
		g2.translate(posx, posy);
		g2.scale(size, size);
		//g2.draw(dBox);
		g2.setTransform(t);
	}

	@Override
	protected void setShapeAttributes() {
		box = 
	new Rectangle2D.Double(img.getWidth()/4, img.getHeight()/20, img.getWidth()/2, img.getHeight()/5);
		dBox = new Area(box);
	}

	@Override
	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(posx, posy);
		at.scale(size, size);
		return at.createTransformedShape(dBox);
	}

}