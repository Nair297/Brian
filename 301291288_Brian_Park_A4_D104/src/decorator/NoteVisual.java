//Displays text when interacting with note object

package decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import tools.Image;

public class NoteVisual extends ObjectVisual{
	
	private BufferedImage img;
	private int notes;
	
	public NoteVisual(Visual base, int notes) {
		this.base = base;
		this.notes = notes;
	}
	
	public void display(Graphics2D g2) {
		if (notes == 1)
			textBox(g2, "This is my diary.", "", "", "");
		if (notes == 2)
			textBox(g2, 
			"September 6th:",
			"My little sister starts high school tomorrow. She seems super", 
			"excited to go to the same school as me. I hope everything goes", 
			"well. She always did have trouble making friends.");
		if (notes == 3)
			textBox(g2, 
			"October 11th:",
			"Lily was bullied again. This time they took her necklace and",
			"threw it in the toilet. I swear I'm going to beat the crap out of",
			"them.");
		if (notes == 4)
			textBox(g2, 
			"November 21st:",
			"Mom and dad were fighting this afternoon. Me and Lily could feel", 
			"the uneasiness spreading from the kitchen. I need a beer to calm", 
			"down. My parents would kill me if they ever saw me drinking.");
		if (notes == 5)
			textBox(g2,
			"November 26th:",
			"I changed the passcode on my laptop again. If you ever forget,",
			"future me, you can find it at the bottom of the poster.", "");
		if (notes == 6)
			textBox(g2,
			"December 18th:",
			"The bullying hasn't stopped. I ran out of alchohol. I lashed out at",
			"my parents saying it's their fault. Lily starts crying. I hate seeing",
			"her sad. And no drinks to help me get through the night...");
	}
}
