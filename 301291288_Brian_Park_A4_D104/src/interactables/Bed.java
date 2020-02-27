//This object will change the time of day

package interactables;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import tools.Image;

public class Bed extends Object{

	public Bed(double x, double y, double s) {
		super(x, y, s);
		img = Image.loadImage("Objects/Bed.png");
		setShapeAttributes();
	}

	@Override
	protected void setShapeAttributes() {
		box = 
new Rectangle2D.Double(-img.getWidth()/2, -img.getHeight()/2, img.getWidth(), img.getHeight());
		dBox = new Area(box);
	}

	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(posx-10, posy+50);
		at.scale(size, size);
		return at.createTransformedShape(dBox);
	}
}
