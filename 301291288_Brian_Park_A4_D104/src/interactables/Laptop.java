//Object for reading emails if password is correct

package interactables;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import tools.Image;

public class Laptop extends Object{

	public Laptop(double x, double y, double s) {
		super(x, y, s);
		img = Image.loadImage("Objects/laptop.png");
		setShapeAttributes();
	}
	
	@Override
	protected void setShapeAttributes() {
		box = 
	new Rectangle2D.Double(-img.getWidth()/4, -img.getHeight()/4+75, img.getWidth()/2.5, img.getHeight()/2);
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