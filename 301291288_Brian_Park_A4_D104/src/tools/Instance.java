//Holds booleans for instances of each interactive object

package tools;

import interactables.Bed;
import interactables.Door;
import interactables.Figure;
import interactables.Kitty;
import interactables.Lamp;
import interactables.Laptop;
import interactables.Notes;
import interactables.Object;
import interactables.Photo;
import interactables.Plant;
import interactables.Poster;
import interactables.Sloth;
import interactables.TV;
import interactables.Upod;

public class Instance {
	
	public static boolean bed(Object o) {
		return (o instanceof Bed);
	}
	
	public static boolean door(Object o) {
		return (o instanceof Door);
	}
	
	public static boolean figure(Object o) {
		return (o instanceof Figure);
	}
	
	public static boolean kitty(Object o) {
		return (o instanceof Kitty);
	}
	
	public static boolean lamp(Object o) {
		return (o instanceof Lamp);
	}
	
	public static boolean laptop(Object o) {
		return (o instanceof Laptop);
	}
	
	public static boolean notes(Object o) {
		return (o instanceof Notes);
	}
	
	public static boolean photo(Object o) {
		return (o instanceof Photo);
	}
	
	public static boolean plant(Object o) {
		return (o instanceof Plant);
	}
	
	public static boolean poster(Object o) {
		return (o instanceof Poster);
	}
	
	public static boolean sloth(Object o) {
		return (o instanceof Sloth);
	}
	
	public static boolean tv(Object o) {
		return (o instanceof TV);
	}
	
	public static boolean upod(Object o) {
		return (o instanceof Upod);
	}

}
