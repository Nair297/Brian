//main class where object placement and interaction occur

package main;

import static tools.Image.loadImage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.Timer;

import interactables.Bed;
import interactables.Button;
import interactables.Button2;
import interactables.Door;
import interactables.Figure;
import interactables.Kitty;
import interactables.Lamp;
import interactables.Laptop;
import interactables.Notes;
import interactables.Object;
import interactables.ObjectFactory;
import interactables.Photo;
import interactables.Plant;
import interactables.Poster;
import interactables.Sloth;
import interactables.TV;
import interactables.Upod;
import room.Background;
import room.Ending;
import room.Lucy;
import room.Title;

import javax.swing.JFrame;
import javax.swing.JPanel;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import decorator.Base;
import decorator.BedVisual;
import decorator.Dark;
import decorator.Day;
import decorator.DoorVisual;
import decorator.FigureVisual;
import decorator.KittyVisual;
import decorator.LaptopVisual;
import decorator.Night;
import decorator.NoteVisual;
import decorator.PhotoVisual;
import decorator.PlantVisual;
import decorator.PosterVisual;
import decorator.SlothVisual;
import decorator.TVVisual;
import decorator.UpodVisual;
import decorator.Visual;
import tools.Image;
import tools.Instance;
import tools.Sound;
import main.Panel.MyMouseListener;
import main.Panel.MyKeyAdapter;

public class Panel extends JPanel implements ActionListener {
	public static int W = 800;
	public static int H = 600;
	public static Timer t;
	private ArrayList<Object> oList;
	private Lucy actor;
	private Title screen;
	private Ending screen2;
	private ObjectFactory maker;
	private Background room, room2;
	private Visual v, v2;
	private Button bt, bt3, bt4;
	private Button2 bt2;
	private boolean up, down, left, right;
	//if key > 0, door can be unlocked //end used to render black screen
	private int state = 0, key = 0, end = 0;
	//values each play different songs if more than 0
	private int s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0;
	//values for objects determines whether decorators are on or off
	private int photo, door, poster, tv, notes, plant, figure, kitty, sloth, upod, laptop, bed, f, f2, f3, f4;
	private double mouseX, mouseY;
	private Minim minim;
	private AudioPlayer song1, song2, song3, song4, song5, sfx1, sfx2, sfx3, sfx4, sfx5, sfx6, sfx7, sfx8, sfx9, sfx0, sfx10, sfx11, sfx12, sfx13;
	private String x = ""; String a = "_"; String b = "_"; String c = "_"; String d = "_";
	
	Panel(JFrame f) {
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W, H));
		String name[] = {"lamp", "photo", "bed", "door", "plant", "figure", "kitty", "laptop",
				"notes", "poster", "sloth", "tv", "upod"};
		
		screen = new Title();
		actor = new Lucy(W/2, H/2, 0.3);
		room = new Background("Room Sprite/Room.png"); room2 = new Background("Room Sprite/Room2.png");
		maker = new ObjectFactory();
		bt = new Button(W/2, H-200, 255); bt2 = new Button2(); 
		bt3 = new Button(W/2, H/2+20, 0); bt4 = new Button(W/2, H/2-74, 0);
		this.oList = new ArrayList<>();
		for (int i = 0; i < name.length; i++) oList.add(maker.create(name[i]));
		screen2 = new Ending();
		
		minim = new Minim(new Sound());
		song1 = minim.loadFile("Nostalgia.mp3");
		song2 = minim.loadFile("K-Pop.mp3");
		song3 = minim.loadFile("Classy.mp3");
		song5 = minim.loadFile("Stylish.mp3");
		song4 = minim.loadFile("Workout.mp3");
		sfx1 = minim.loadFile("Beep.mp3");
		sfx1.setLoopPoints(0, 250);
		sfx2 = minim.loadFile("Lamp.mp3");
		sfx3 = minim.loadFile("RoomTone.mp3");
		sfx4 = minim.loadFile("DoorLocked.mp3");
		sfx4.setLoopPoints(0, 1000);
		sfx5 = minim.loadFile("Keyboard.mp3");
		sfx6 = minim.loadFile("Ding.mp3");
		sfx6.setLoopPoints(0, 1200);
		sfx7 = minim.loadFile("Wrong.mp3");
		sfx7.setLoopPoints(0, 500);
		sfx8 = minim.loadFile("Unlock.mp3");
		sfx9 = minim.loadFile("Rooster.mp3");
		sfx0 = minim.loadFile("Beep.mp3");
		
		sfx10 = minim.loadFile("Found.mp3");
		sfx11 = minim.loadFile("Whoosh.mp3");
		sfx11.setLoopPoints(0, 250);
		sfx12 = minim.loadFile("Move.mp3");
		sfx13 = minim.loadFile("Paper.mp3");
		
		MyMouseListener m1 = new MyMouseListener();
		addMouseListener(m1);
		addKeyListener(new MyKeyAdapter());

		t = new Timer(33, this);
		t.start();
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (state == 0) {
			screen.draw(g2);
		}
		
		else if (state == 1) {
			v2.display(g2);
			room.drawRoom(g2);
			actor.drawLucy(g2);
			for (Object o : oList)
				if(actor.collisionI(o) && Instance.lamp(o))
					actor.drawIcon(g2);
			for (Object o : oList) o.drawObject(g2);
			if (v != null) v.display(g2);
		}
		
		else if (state > 1) {
			v2.display(g2);
			if (door < 5) room.drawRoom(g2);
			if (door > 3) room2.drawRoom(g2);
			actor.drawLucy(g2);
			for (Object o : oList ) {
				if(actor.collisionI(o) && !Instance.lamp(o) && state < 3) actor.drawIcon(g2);
				o.drawObject(g2);
			}
			if (plant > 0) bt3.drawButton(g2);
			if (v != null) v.display(g2);
			if (figure == 1 || sloth == 1 || kitty == 1) bt.drawButton(g2);
			if (sloth == 1 && f2 == 1) bt4.drawButton(g2);
			if (upod > 0) bt2.drawButton(g2);
			if (laptop == 0) {
				a = "_"; b = "_"; c = "_"; d = "_";
			g2.setColor(Color.black);
			if (bed == 2) g2.fillRect(0, 0, W, H);
			}
		}
		
		if (state == 3) screen2.drawEnding(g2, end*2);
	}

	public void actionPerformed(ActionEvent e) {
		v = new Base();
		v2 = new Base();
		
		if (state == 1) {
			Visual base = new Base();
			v = new Dark(base);
		}
		
		if (state >= 1 && state < 3) {
			if (song1.isPlaying()) s1++;
			if (song2.isPlaying()) s2++;
			if (song3.isPlaying()) s3++;
			if (song4.isPlaying()) s4++;
			if (song5.isPlaying()) s5++;
			
			if (right && actor.collisionRight(oList)) actor.right();
			else if (left && actor.collisionLeft(oList)) actor.left();
			else if (up && actor.collisionUp(oList)) actor.up();
			else if (down && actor.collisionDown(oList)) actor.down();
			else actor.idle();
			actor.update();
			
			Visual base = new Base();
			if (photo == 1) v = new PhotoVisual(base);
			if (bed == 1) v = new BedVisual(base);
			if (door > 0) v = new DoorVisual(base, door);
			if (poster == 1) v = new PosterVisual(base);
			if (tv > 0) v = new TVVisual(base, tv);
			if (notes > 0) v = new NoteVisual(base, notes);
			if (plant > 0) v = new PlantVisual(base, plant, key);
			if (figure > 0) v = new FigureVisual(base, figure, f);
			if (sloth > 0) v = new SlothVisual(base, sloth, f2);
			if (kitty > 0) v = new KittyVisual(base, kitty, f3);
			if (upod > 0) v = new UpodVisual(base);
			if (laptop > 0) v = new LaptopVisual(base, laptop, a, b, c, d);
			if (f4 == 0) v2 = new Night(base);
			if (f4 == 1) v2 = new Day(base);					
			if(bed == 2) {
				end++;
				if (end == 40) {
					bed = 0;
					end = 0;
				}
				if (end == 39 && f4 == 0) {
					f4 = 1;
					sfx9.play(); sfx3.pause(); 
				}
				else if (end == 39 && f4 == 1) {
					f4 = 0;
					sfx3.loop(); sfx9.pause(); sfx9.rewind(); 
				}
			}
		}
		
		if (door == 15) state = 3;
		if (state == 3) {
			sfx3.pause();
			song1.pause(); song1.rewind();
			song2.pause(); song2.rewind();
			song3.pause(); song3.rewind();
			song4.pause(); song4.rewind();
			song5.pause(); song5.rewind();
			if (end < 255/2) end++;
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter {
	    public void keyPressed(KeyEvent e) {
	    	
	    	if(photo == 0 && door == 0 && poster == 0 && tv == 0 && notes == 0 && bed == 0 &&
				plant == 0 && figure == 0 && sloth == 0 && kitty == 0 && upod == 0 && laptop == 0) {
	    		
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            right = true;
	        	up = false;
	        	down = false;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	            left = true;
	            up = false;
	            down = false;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_UP) {
	            up = true;
	        	left = false;
	        	right = false;
	        }
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	            down = true;
	        	left = false;
	        	right = false;
	        }
	    	}
	        
	        for (Object o : oList) {
	        if (e.getKeyCode() == KeyEvent.VK_0)
	        	if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	        		if (laptop == 1) a = "0";
	        		if (laptop == 2) b = "0";
	        		if (laptop == 3) c = "0";
	        		if (laptop == 4) {
	        			d = "0";
	        			sfx7.play();
	        		}
	        		laptop++;
	        		sfx5.loop(0);
	        	}
	        if (e.getKeyCode() == KeyEvent.VK_1)
	        	if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	        		if (laptop == 1) a = "1";
	        		if (laptop == 2) b = "1";
	        		if (laptop == 3) c = "1";
	        		if (laptop == 4) {
	        			d = "1";
	        			sfx7.play();
	        		}
	        		laptop++;
	        		sfx5.loop(0);
	        	}
	        if (e.getKeyCode() == KeyEvent.VK_2)
	        	if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	        		if (laptop == 1) a = "2";
	        		if (laptop == 2) b = "2";
	        		if (laptop == 3) c = "2";
	        		if (laptop == 4) {
	        			d = "2";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	        if (e.getKeyCode() == KeyEvent.VK_3) 
	        	if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	        		if (laptop == 1) a = "3";
	        		if (laptop == 2) b = "3";
	        		if (laptop == 3) c = "3";
	        		if (laptop == 4) {
	        			d = "3";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	       	if (e.getKeyCode() == KeyEvent.VK_4)
	       		if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	       			if (laptop == 1) a = "4";
	        		if (laptop == 2) b = "4";
	        		if (laptop == 3) c = "4";
	        		if (laptop == 4) {
	        			d = "4";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	       	if (e.getKeyCode() == KeyEvent.VK_5)
	       		if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	       			if (laptop == 1) a = "5";
	        		if (laptop == 2) b = "5";
	        		if (laptop == 3) c = "5";
	        		if (laptop == 4) {
	        			d = "5";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	       	if (e.getKeyCode() == KeyEvent.VK_6) 
	       		if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	       			if (laptop == 1) a = "6";
	        		if (laptop == 2) b = "6";
	        		if (laptop == 3) c = "6";
	        		if (laptop == 4) {
	        			d = "6";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	       	if (e.getKeyCode() == KeyEvent.VK_7) 
	       		if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	       			if (laptop == 1) a = "7";
	        		if (laptop == 2) b = "7";
	        		if (laptop == 3) c = "7";
	        		if (laptop == 4) {
	        			d = "7";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	       	if (e.getKeyCode() == KeyEvent.VK_8)
	       		if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	       			if (laptop == 1) a = "8";
	        		if (laptop == 2) b = "8";
	        		if (laptop == 3) c = "8";
	        		if (laptop == 4) {
	        			d = "8";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	       	if (e.getKeyCode() == KeyEvent.VK_9)
	       		if(actor.collisionI(o) && Instance.laptop(o) && laptop >= 1 && laptop <= 4) {
	       			if (laptop == 1) a = "9";
	        		if (laptop == 2) b = "9";
	        		if (laptop == 3) c = "9";
	        		if (laptop == 4) {
	        			d = "9";
	        			sfx7.play();
	        		}
		        	laptop++;
		        	sfx5.loop(0);
		        }
	        
	        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    		if (state == 1 && actor.collisionI(o) && Instance.lamp(o)) {
	    			state = 2;
	    			sfx2.play();
	    		}
	    		
	    		if (state > 1 && actor.collisionI(o)) { 
	    			
	    			if (photo == 0 && poster == 0 && bed == 0 && tv == 0 && notes == 0 && plant == 0 && 
	    				figure == 0 && sloth == 0 && kitty == 0 && upod == 0 && laptop == 0) 
	    				if (!Instance.lamp(o) && !Instance.door(o)) sfx0.play();
	    			if (photo == 1 || poster == 1 || bed == 1 || tv == 1 || notes == 1 || plant == 1 || figure == 1 || 
		    			sloth == 1 || sloth == 4 ||kitty == 1 || upod == 1 || laptop == 5 || laptop == 7)
	    				if (!Instance.lamp(o) && !Instance.door(o)) {
	    					sfx0.rewind(); sfx0.pause();
	    				}
	    				
	    			if(Instance.photo(o) && photo < 2) photo++;
	    			if(Instance.photo(o) && photo == 2) photo = 0;
	    			
	    			if(Instance.door(o)) {
	    				if (door < 2) door++;
	    				if (key < 2 && door == 1) sfx4.loop(0);
	    				if (door == 2) door = 0;
	    				if (key == 2) door += 2;
	    				if (key == 2) sfx8.play();
	    			}
	    			
	    			if(Instance.poster(o) && poster < 2) poster++;
	    			if(Instance.poster(o) && poster == 2) poster = 0;
	    			
	    			if(Instance.bed(o) && bed < 2) bed++;
	    			
	    			if(Instance.tv(o) && tv < 3) tv++;
	    			if(Instance.tv(o) && tv == 3) tv = 0;
	    			
	    			if(Instance.notes(o) && notes < 7) notes++;
	    			if(Instance.notes(o) && notes == 7) notes = 0;
	    			
	    			if(Instance.plant(o) && plant < 2) plant++;
	    			if(Instance.plant(o) && plant == 2) plant = 0;
	    			
	    			if(Instance.figure(o) && figure < 2) figure++;
	    			if(Instance.figure(o) && figure == 2) figure = 0;
	    			
	    			if(Instance.kitty(o) && kitty < 2) kitty++;
	    			if(actor.collisionI(o) && Instance.kitty(o) && kitty == 2) kitty = 0;
	    			
	    			if(Instance.sloth(o) && sloth < 5) {
	    				sloth++;
	    				sfx13.rewind();
	    			}
	    			if(Instance.sloth(o) && sloth == 2) sloth = 0;
	    			if(Instance.sloth(o) && sloth == 5) sloth = 0;
	    			
	    			if(Instance.upod(o) && upod < 2) upod++;
	    			if(Instance.upod(o) && upod == 2) upod = 0;
	    			
	    			if(Instance.laptop(o)) {
	    				if (laptop < 6) laptop++;
	    				if (laptop == 2 || laptop == 3 || laptop == 4) {
	    					laptop = 5;
	    				}
	    				if (laptop == 5) sfx7.play();
	    				if (a == "1" && b == "2" && c == "6" && d == "_") {
	    					laptop += 2;
	    					if (laptop == 7) {
	    						sfx7.pause();
	    						sfx6.loop(0);
	    					}
	    				}
	    				if (laptop == 6 || laptop > 17) {
	    					sfx7.rewind();
	    					laptop = 0;
	    				}
	    			}
	    		}
	    		}
	        }
	    }

	    public void keyReleased(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
	        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
	        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
	    }
	}
	
	public class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			
			if (state == 0 && screen.clicked(e)) {
				sfx1.loop(0);
				state = 1;
				sfx3.loop();
			}
			if (bt.clicked(e)) {
				if (figure > 0 || sloth > 0 || kitty > 0 ) sfx11.loop(0);
				if (figure > 0 && f < 2) f++;
				if (figure > 0 && f == 2) f=0;
				if (sloth > 0 && f2 < 2) f2++;
				if (sloth > 0 && f2 == 2) f2=0;
				if (kitty > 0 && f3 < 2) f3++;
				if (kitty > 0 && f3 == 2) f3=0;
			}
			if (sloth == 1 && bt4.clicked(e) && f2 == 1) {
				sloth += 2;
				sfx13.play();
			}
			if (plant > 0 && bt3.clicked(e) && key < 2) {
				if (key == 0) sfx12.play();
				if (key == 1) sfx10.play();
				key += 1;
			}
			
			if (upod > 0 && bt2.clicked1(e) && s1 < 1) {
				song1.play();
				song2.pause(); song2.rewind();
				song3.pause(); song3.rewind();
				song4.pause(); song4.rewind();
				song5.pause(); song5.rewind();
			}
			if (upod > 0 && bt2.clicked1(e) && s1 > 1) {
				s1 = 0; song1.pause(); song1.rewind();
			}
			if (upod > 0 && bt2.clicked2(e) && s2 < 1) {
				song2.play();
				song1.pause(); song1.rewind();
				song3.pause(); song3.rewind();
				song4.pause(); song4.rewind();
				song5.pause(); song5.rewind();
			}
			if (upod > 0 && bt2.clicked2(e) && s2 > 1) {
				s2 = 0; song2.pause(); song2.rewind();
			}
			if (upod > 0 && bt2.clicked3(e) && s3 < 1) {
				song3.play();
				song2.pause(); song2.rewind();
				song1.pause(); song1.rewind();
				song4.pause(); song4.rewind();
				song5.pause(); song5.rewind();
			}
			if (upod > 0 && bt2.clicked3(e) && s3 > 1) {
				s3 = 0; song3.pause(); song3.rewind();
			}
			if (upod > 0 && bt2.clicked4(e) && s4 < 1) {
				song4.play();
				song2.pause(); song2.rewind();
				song3.pause(); song3.rewind();
				song1.pause(); song1.rewind();
				song5.pause(); song5.rewind();
			}
			if (upod > 0 && bt2.clicked4(e) && s4 > 1) {
				s4 = 0; song4.pause(); song4.rewind();
			}
			if (upod > 0 && bt2.clicked5(e) && s5 < 1) {
				song5.play();
				song2.pause(); song2.rewind();
				song3.pause(); song3.rewind();
				song4.pause(); song4.rewind();
				song1.pause(); song1.rewind();
			}
			if (upod > 0 && bt2.clicked5(e) && s5 > 1) {
				s5 = 0; song5.pause(); song5.rewind();
			}
			
			if (state == 3 && screen2.clicked(e)) {
				sfx1.loop(0);
				state = 0; key = 0; end = 0; door = 0;
				s1 = 0; s2 = 0; s3 = 0; s4 = 0; s5 = 0;
				f = 0; f2 = 0; f3 = 0; f4 = 0;
				sfx2.rewind(); sfx8.rewind(); sfx3.rewind(); sfx9.rewind(); sfx10.rewind(); sfx12.rewind();
				actor.resetPos();
			}
		}
	}
}