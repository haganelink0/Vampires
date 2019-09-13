package pac1;

public class Dungeon {
	private Map dungeonMap;
	private Action actionMove;
	private int vampires;
	private int turns;
	
	public Dungeon(int x, int y, int vampires, int movements) {
		this.dungeonMap = new Map(x, y);
		this.actionMove = new Action();
		this.vampires = vampires;
		this.turns = movements;
	}
	
	public void start() {
		this.dungeonMap.createEntities(this.vampires);
	}
	
	public Movement readMovement(String movement) {
		Movement player = new Movement(this.dungeonMap.getHero().getX(), this.dungeonMap.getHero().getY());
		int newX = 0;
		int newY = 0;
		for (int i = 0; i < movement.length(); i++) {
			 char move = movement.charAt(i);
			 char ch1 = 'w';
			 char ch2 = 's';
			 char ch3 = 'a';
			 char ch4 = 'd';
			if (move == ch1) {
				newX++;
			} else if (move ==  ch2) {
				newX--;
			} else if (move == ch3) {
				newY--;
			} else if (move == ch4) {
				newY++;
			}
		}
		player.setNewX(newX);
		player.setNewY(newY);
		return player;
	}


}
