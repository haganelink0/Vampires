package pac1;


public class Vampire extends Entities {
	private String name;

	public Vampire(int x, int y) {
		super(x, y);
		this.name = "v";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void move(int x, int y) {
		setX(x);
		setY(y);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return name + " " + getX() + " " + getY();
	}
	
	

}
