package pac1;

import java.util.Random;

public class Vampire extends Entities {
	private Random randomizer;

	public Vampire(int x, int y) {
		super(x, y);
		this.randomizer = new Random();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Vampire [getX()=" + getX() + ", getY()=" + getY() + "]";
	}
	
	

}
