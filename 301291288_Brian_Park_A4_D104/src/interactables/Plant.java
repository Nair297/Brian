//Object for displaying an image

package interactables;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import tools.Image;

public class Plant extends Object{

	public Plant(double x, double y, double s) {
		super(x, y, s);
		img = Image.loadImage("Objects/Plant.png");
		setShapeAttributes();
	}

	@Override
	protected void setShapeAttributes() {
		box = 
new Rectangle2D.Double(-img.getWidth()/3, -img.getWidth()/10, img.getHeight()/2, img.getWidth()/2);
		dBox = new Area(box);
	}

	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(posx, posy);
		at.scale(size, size);
		return at.createTransformedShape(dBox);
	}
}
