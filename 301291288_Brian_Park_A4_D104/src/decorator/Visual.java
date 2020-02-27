//Interface for all Object Visuals

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import main.Panel;

public abstract interface Visual {
	public abstract void display(Graphics2D g2);
}
