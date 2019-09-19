package pac1;

import java.util.ArrayList;
import java.util.Random;

public class Movement {
	private final int originalX;
	private final int originalY;
	private int newX;
	private int newY;
	private int movements;
	
	public Movement(int x, int y) {
		this.originalX = x;
		this.originalY = y;
		this.movements = 0;
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

	public int getOriginalX() {
		return originalX;
	}

	public int getOriginalY() {
		return originalY;
	}
	
	public void readMovement(String movement) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < movement.length(); i++) {
			String compare =""+ movement.charAt(i);
			if (compare.contains("w")) {
				x--;
				movements++;
			} else if (compare.contains("s")) {
				x++;
				movements++;
			} else if (compare.contains("a")) {
				y--;
				movements++;
			} else if (compare.contains("d")) {
				y++;
				movements++;
			}
		}
		this.newX = this.originalX + x;
		this.newY = this.originalY + y;
	}
	
	public String vampireMovement() {
		ArrayList<String> mO = new ArrayList<String>();
		mO.add("w");
		mO.add("s");
		mO.add("a");
		mO.add("d");
		Random rdm = new Random();
		String mv = "";
		for (int i = 0; i < this.movements; i++) {
			mv += mO.get(rdm.nextInt(3));
		}
		return mv;
	}

	public int getMovements() {
		return movements;
	}

	public void setMovements(int movements) {
		this.movements = movements;
	}

	@Override
	public String toString() {
		return "Movement [originalX=" + originalX + ", originalY=" + originalY + ", newX=" + newX + ", newY=" + newY
				+ "]";
	}
	
	public boolean vampireColision(Entities vampire) {
		if (vampire.getX() == getNewX() && vampire.getY() == getNewY()) {
			return false;
		} else {
			return true;
		}
	}
	
	

}
