//Displays text when interacting with door object

package decorator;

import java.awt.Graphics2D;

public class BedVisual extends ObjectVisual{
	
	public BedVisual(Visual base) {
		this.base = base;
	}
	
	public void display(Graphics2D g2) {
		textBox(g2, "Maybe I should get some sleep.", "", "", "");
	}
}