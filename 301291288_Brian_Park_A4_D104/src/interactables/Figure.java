//Object for displaying an image

package interactables;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import tools.Image;

public class Figure extends Object{

	public Figure(double x, double y, double s) {
		super(x, y, s);
		img = Image.loadImage("Objects/figure.png");
		setShapeAttributes();
	}

	protected void setShapeAttributes() {
		box = 
	new Rectangle2D.Double(-img.getWidth()/2, -img.getHeight()/2, img.getWidth(), img.getHeight()/1);
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