//player character with functions for moving and animating different sprites

package room;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import tools.Image;
import interactables.Object;
import processing.core.PVector;
import main.Panel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Lucy {
	
	private PVector pos, spd;
	private Dimension dim;
	private double scale;
	private BufferedImage img, img2;
	private float a1, a2, a3, a4, a5, b1, b2, b3, b4;
	private float p, r, l, u, d, r2, r3, l2, l3, u2, u3, d2, d3;
	private double hitx, hity;
	private Area dBox, dhit;
	private Rectangle2D.Double box, hit;
	
	public Lucy(float x, float y, double s) {
		this.pos = new PVector(x, y);
		this.scale = s;
		this.spd = new PVector(0, 0);
		img = Image.loadImage("Lucy Sprite/Lucy_Idle1.png");
		img2 = Image.loadImage("Lucy Sprite/Icon.png");
		
		//a1 to a4 used to animate character sprite while walking
		this.a1 = 0; this.a2 = 0; this.a3 = 0; this.a4 = 0;
		
		//a5 used to render certain sprites depending on values from 1 to 4;
		this.a5 = 5;
		
		//bottom variables used to render certain sprites in update method
		//if p equals any other bottom variables, loads certain images for sprites
		this.p = 4;
		this.r = 1; this.l = 2; this.u = 3; this.d = 4; this.r2 = 5; this.l2 = 6;
		this.u2 = 7; this.d2 = 8; this.r3 = 9; this.l3 = 10; this.u3 = 11;
		this.d3 = 12;
		setShapeAttributes();
	}
	
	public void drawLucy(Graphics2D g2) {
		AffineTransform t = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setColor(Color.black);
		AffineTransform t2 = g2.getTransform();
		g2.translate(hitx, hity);
		//g2.draw(hit);
		g2.setTransform(t2);
		g2.setTransform(t);
	}
	
	//Icon appears when near objects
	public void drawIcon(Graphics2D g2) {
		AffineTransform t = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.drawImage(img2, -img2.getWidth()/2, -img.getHeight(), null);
		g2.setTransform(t);
	}
	
	public void move() {
		spd.mult(0.2f);
		pos.add(spd);
	}
	
	public void update() {
		move();
		if (p == r) img = Image.loadImage("Lucy Sprite/Lucy_IdleRight.png");
		if (p == l) img = Image.loadImage("Lucy Sprite/Lucy_IdleLeft.png");
		if (p == u) img = Image.loadImage("Lucy Sprite/Lucy_IdleBack.png");
		if (p == d) img = Image.loadImage("Lucy Sprite/Lucy_Idle1.png");
		if (p == r2) img = Image.loadImage("Lucy Sprite/Lucy_WalkRight1.png");
		if (p == l2) img = Image.loadImage("Lucy Sprite/Lucy_WalkLeft1.png");
		if (p == u2) img = Image.loadImage("Lucy Sprite/Lucy_WalkBack1.png");
		if (p == d2) img = Image.loadImage("Lucy Sprite/Lucy_Walk1.png");
		if (p == r3) img = Image.loadImage("Lucy Sprite/Lucy_WalkRight2.png");
		if (p == l3) img = Image.loadImage("Lucy Sprite/Lucy_WalkLeft2.png");
		if (p == u3) img = Image.loadImage("Lucy Sprite/Lucy_WalkBack2.png");
		if (p == d3) img = Image.loadImage("Lucy Sprite/Lucy_Walk2.png");
	}
	
	protected void setShapeAttributes() {
		box = 
new Rectangle2D.Double(-img.getWidth()/2, -img.getHeight()/2, img.getWidth(), img.getHeight());
		dBox = new Area(box);
		hit =
new Rectangle2D.Double(0, 0, img.getHeight()/4, 1);
		dhit = new Area(hit);
	}
	
	public boolean touch(Object other) {
		return (this.dBox().intersects(other.getDBox()) &&
				other.dBox().intersects(getDBox()) );
	}
	
	public boolean interactable(Object other) {
		return (this.dhit().intersects(other.getDBox()) &&
				other.dBox().intersects(getDhit()) );
	}
	
	public boolean collisionI(Object o) {
			if (interactable(o))
				return true;
		return false;
	}
	
	public boolean collisionRight(ArrayList<Object> oList) {
		for (Object o : oList) {
			if (touch(o) && a5 == 1 || pos.x > 800-img.getWidth()/2 * scale) {
				spd.mult(-3);
				pos.add(spd);
				return false;
			}
		}
		return true;
	}
	
	public boolean collisionLeft(ArrayList<Object> oList) {
		for (Object o : oList)
			if (touch(o) && a5 == 2 || pos.x < img.getWidth()/2 * scale) {
				spd.mult(-3);
				pos.add(spd);
				return false;
			}
		return true;
	}
	
	public boolean collisionUp(ArrayList<Object> oList) {
		for (Object o : oList)
			if (touch(o) && a5 == 3 || pos.y < 180){
				spd.mult(-3);
				pos.add(spd);
				return false;
			}
		return true;
	}
	
	public boolean collisionDown(ArrayList<Object> oList) {
		for (Object o : oList)
			if (touch(o) && a5 == 4 || pos.y > 600-img.getHeight()/2 * scale){
				spd.mult(-3);
				pos.add(spd);
				return false;
			}
		return true;
	}
	
	//method for rendering character's sprite to idle when not walking
	public void idle() {
		if (a5 == 1) {
			p = r;
			a1 = 0;
			hitx = img.getWidth()/2;
			hity = 0;
		}
		if (a5 == 2) {
			p = l;
			a2 = 0;
			hitx = -1.75*img.getWidth()/2;
			hity = 0;
		}
		if (a5 == 3) {
			p = u;
			a3 = 0;
			hitx = -img.getWidth()/4;
			hity = -img.getHeight();
		}
		if (a5 == 4 || a5 == 5) {
			p = d;
			a4 = 0;
			hitx = -img.getWidth()/4;
			hity = img.getHeight()/1.5;
		}
	}
	
	public void right() {
	    spd.set(30, spd.y);
	    a5 = 1;
	    hitx = img.getWidth()/2;
		hity = 0;
	    a1++;
	    if (a1 < 10 && a1 > 0) p = r2;
	    if (a1 == 10) p = r;
    	if (a1 < 20 && a1 > 10) p = r3;
    	if (a1 == 20) p = r;
    	if (a1 > 20) a1 = 0;
	}

	public void left() {
	    spd.set(-30, spd.y);
	    a5 = 2;
	    hitx = -1.75*img.getWidth()/2;
		hity = 0;
	    a2++;
	    if (a2 == 0) p = l;
	    if (a2 < 10 && a2 > 0) p = l2;
	    if (a2 == 10) p = l;
    	if (a2 < 20 && a2 > 10) p = l3;
    	if (a2 == 20) p = l;
    	if (a2 > 20) a2 = 0;
	}

	public void up() {
	    spd.set(spd.x, -30);
	    a5 = 3;
	    hitx = -img.getWidth()/4;
		hity = -img.getHeight();
	    a3++;
	    if (a3 == 0) p = u;
	    if (a3 < 10 && a3 > 0) p = u2;
	    if (a3 == 10) p = u;
    	if (a3 < 20 && a3 > 10) p = u3;
    	if (a3 == 20) p = u;
    	if (a3 > 20) a3 = 0;
	}

	public void down() {
	    spd.set(spd.x, 30);
	    a5 = 4;
	    hitx = -img.getWidth()/4;
		hity = img.getHeight()/1.5;
	    a4++;
	    if (a4 == 0) p = d;
	    if (a4 < 10 && a4 > 0) p = d2;
	    if (a4 == 10) p = d;
    	if (a4 < 20 && a4 > 10) p = d3;
    	if (a4 == 20) p = d;
    	if (a4 > 20) a4 = 0;
	}
	
	public Rectangle2D getDBox() {
		return dBox().getBounds2D();
	}
	
	//character's hit box
	public Shape dBox() {
		AffineTransform at = new AffineTransform();		
		at.translate(pos.x, pos.y);
		at.scale(scale, scale);
		return at.createTransformedShape(dBox);
	}
	
	public Rectangle2D getDhit() {
		return dhit().getBounds2D();
	}
	
	//character's "object detector"
	public Shape dhit() {
		AffineTransform at = new AffineTransform();		
		at.translate(pos.x, pos.y);
		at.scale(scale, scale);		
		at.translate(hitx, hity);
		return at.createTransformedShape(dhit);
	}
	
	public void resetPos() {
		pos.x = Panel.W/2;
		pos.y = Panel.H/2;
		p = d;
		a5 = 5;
	}
}

