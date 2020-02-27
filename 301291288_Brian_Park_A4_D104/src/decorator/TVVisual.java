//Displays text when interacting with tv object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class TVVisual extends ObjectVisual{

	private int tv;
	
	public TVVisual(Visual base, int tv) {
		this.base = base;
		this.tv = tv;
	}
	
	public void display(Graphics2D g2) {
		if (tv == 1)
			textBox(g2, "BREAKING NEWS", "", "", "");
		if (tv == 2)
			textBox(g2, 
			"On December 18th 11:34 pm, a young girl was found dead on",
			"the streets. It is presumed that she commited suicide by jumping", 
			"off the building behind her corpse. More information will be", 
			"revealed after autopsy.");
	}
}