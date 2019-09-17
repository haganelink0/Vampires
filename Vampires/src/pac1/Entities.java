package pac1;

public abstract class Entities {
	private String name;
	private int x;
	private int y;
	
	
	
	public Entities(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void move(int x, int y);
	
	@Override
	public String toString() {
		return name + getX() + getY();
	}

}
