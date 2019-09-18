package pac1;

import java.util.Scanner;

public class Dungeon {
	private Map dungeonMap;
	private int vampires;
	private int turns;
	private Scanner reader;
	
	public Dungeon(int x, int y, int vampires, int movements) {
		this.dungeonMap = new Map(x, y);
		this.vampires = vampires;
		this.setTurns(movements);
		this.reader = new Scanner(System.in);
	}
	
	public void start() {
		this.dungeonMap.createEntities(this.vampires);
		System.out.println("You got hired to kill all the vampires in this dungeon.");
		System.out.println("Your torch has light for " + turns + "And you have to kill " + vampires + " vampires.");
		while (true) {
			System.out.println("Light left: " + turns);
			this.dungeonMap.printEntities();
			this.dungeonMap.printMap();

			String movement = reader.nextLine();
			move(movement);
			if (turns == 0) {
				if (this.vampires == 0) {
					System.out.println("YOU WON!. But you run out of light. And you are in the middle of a dungeon full of vampire corpses. Maybe you didn't win that much. But you did your job");
					break;
				} else {
					System.out.println("You run out of light. You are going to die pretty soon. I guess you lose.");
					break;
				}
			}
			if (vampires == 0) {
				System.out.println("You killed them all and still have enough light to go home. That was easy.");
				break;
			}
		}
		
	}
	
	public void move(String move) {
		Movement m = new Movement(dungeonMap.getHero().getX(), dungeonMap.getHero().getY());
		m.readMovement(move);
		if (m.getNewX() > this.dungeonMap.getWidht()) {
			dungeonMap.getHero().setX(dungeonMap.getWidht());
		} else if (m.getNewX() < 0) {
			dungeonMap.getHero().setX(0);
		} else {
			dungeonMap.getHero().setX(m.getNewX());
		}
		if (m.getNewY() > this.dungeonMap.getHeight()) {
			dungeonMap.getHero().setY(dungeonMap.getHeight());
		} else if (m.getNewY() < 0) {
			dungeonMap.getHero().setY(0);
		} else {
			dungeonMap.getHero().setY(m.getNewY());
		}
		this.setTurns(this.getTurns() - 1);
		for(int i = 1; i < this.dungeonMap.getEntities().size(); i++) {
			this.dungeonMap.getEntities().get(i).setX(m.vampireMovement(this.dungeonMap.getEntities().get(i).getX(), this.dungeonMap.getEntities().get(i).getY()).getNewX());
			this.dungeonMap.getEntities().get(i).setY(m.vampireMovement(this.dungeonMap.getEntities().get(i).getX(), this.dungeonMap.getEntities().get(i).getX()).getNewY());
			if (this.dungeonMap.getEntities().get(i).getX() == m.getNewX() && this.dungeonMap.getEntities().get(i).getY() == m.getNewY()) {
				this.dungeonMap.getEntities().remove(i);
				this.vampires--;
			}
		}
		
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}
}
