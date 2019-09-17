package pac1;

import java.util.Random;

public class Vampire extends Entities {
	private Random randomizer;
	private String name;

	public Vampire(int x, int y) {
		super(x, y);
		this.randomizer = new Random();
		this.name = "v";
		
		// TODO Auto-generated constructor stub
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return name + " " + getX() + " " + getY();
	}
	
	

}
