//superclass for all interactive objects

package interactables;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class Object {
	
	protected double posx, posy, size;
	protected BufferedImage img;
	protected Rectangle2D.Double box;
	protected Area dBox;
	
	public Object(double x, double y, double s) {
		posx = x;
		posy = y;
		size = s;
	}
	
	public void drawObject(Graphics2D g2) {
		AffineTransform t = g2.getTransform();
		g2.translate(posx, posy);
		g2.scale(size, size);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setTransform(t);
	}
	
	public Rectangle2D getDBox() {
		return dBox().getBounds2D();
	}
	
	protected abstract void setShapeAttributes();
	public abstract Shape dBox();
}