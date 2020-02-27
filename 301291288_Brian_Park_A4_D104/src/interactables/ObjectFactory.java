//Factory class for creating objects

package interactables;

public class ObjectFactory extends Factory{
	
	public Object create(String type) {
		if (type.equals("lamp"))
			return new Lamp(30, 330, 0.3);
		else if (type.equals("photo"))
			return new Photo(30, 410, 0.3);
		else if (type.equals("bed"))
			return new Bed(100, 500, 0.3);
		else if (type.equals("door"))
			return new Door(130, 50, 0.3);
		else if (type.equals("poster"))
			return new Poster(525, 60, 0.3);
		else if (type.equals("tv"))
			return new TV(158, 75, 1);
		else if (type.equals("plant"))
			return new Plant(730, 300, 0.3);
		else if (type.equals("sloth"))
			return new Sloth(730, 466, 0.3);
		else if (type.equals("figure"))
			return new Figure(730, 394, 0.3);
		else if (type.equals("kitty"))
			return new Kitty(730, 550, 0.3);
		else if (type.equals("upod"))
			return new Upod(250, 545, 0.3);
		else if (type.equals("laptop"))
			return new Laptop(353, 545, 0.3);
		else if (type.equals("notes"))
			return new Notes(455, 545, 0.3);
		else return null;
	}
	
	
}
