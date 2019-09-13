package pac1;

public class Movement {
	private final int originalX;
	private final int originalY;
	private int newX;
	private int newY;
	
	public Movement(int x, int y) {
		this.originalX = x;
		this.originalY = y;
	}

	public int getNewX() {
		return newX;
	}

	public void setNewX(int newX) {
		this.newX = newX;
	}

	public int getNewY() {
		return newY;
	}

	public void setNewY(int newY) {
		this.newY = newY;
	}
	
	

}
