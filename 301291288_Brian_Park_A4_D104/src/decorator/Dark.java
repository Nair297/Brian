//darkens the screen when displayed

package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import main.Panel;

public class Dark extends ObjectVisual{
	
	public Dark(Visual base) {
		this.base = base;
	}

	@Override
	public void display(Graphics2D g2) {
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fill(new Rectangle2D.Double(0, 0, Panel.W, Panel.H));
		textBox(g2, "It's too dark. I need to turn on the lamp.", "", "", "");
	}
}
