package pac1;

import java.util.ArrayList;

public class Map {
	private int height;
	private int widht;
	private ArrayList<Entities> entities;
	
	public Map(int height, int widht) {
		this.height = height;
		this.widht = widht;
		this.entities = new ArrayList<Entities>();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidht() {
		return widht;
	}

	public void setWidht(int widht) {
		this.widht = widht;
	}

	public ArrayList<Entities> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entities> entities) {
		this.entities = entities;
	}
	
	public void createEntities(int vampires) {
		Entities playerOne = new Human(0,0);
		entities.add(playerOne);
		for(int i = 0; i < vampires; i++) {
			entities.add(new Vampire( this.height, (i)));
		}
	}
	
	public Human getHero() {
		return (Human) this.entities.get(0);
	}
	
	public void printMapLine(int y) {
		String line = "";
		int tall = 1;
		while (this.widht > line.length()) {
			for (int j = 0; j < this.entities.size(); j++) {
				if (this.entities.get(j).getX() == y && this.entities.get(j).getY() == tall-1) {
					line += this.entities.get(j).getName();
				}
			}
			line += "·";
		}
		System.out.println(line);
	}
	
	

}
