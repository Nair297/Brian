//Displays text when interacting with upod object

package decorator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UpodVisual extends ObjectVisual{
	
	public UpodVisual(Visual base) {
		this.base = base;
	}
	
	public void display(Graphics2D g2) {
		textBox(g2, "It's my old Upod. Which song should I listen to?", "", "", "");
	}
}