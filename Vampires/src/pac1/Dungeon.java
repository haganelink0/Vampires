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
					System.out.println("YOU WON!. But you run out of light. "
							+ "And you are in the middle of a dungeon full of vampire corpses. "
							+ "Maybe you didn't win that much. But you did your job, I guess.");
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
	
	public void movementCorrection(int i) {
		if (this.dungeonMap.getEntities().get(i).getX() > this.dungeonMap.getWidht()) {
			this.dungeonMap.getEntities().get(i).setX(this.dungeonMap.getWidht());
		} else if (this.dungeonMap.getEntities().get(i).getX() < 0) {
			this.dungeonMap.getEntities().get(i).setX(0);
		}
		if (this.dungeonMap.getEntities().get(i).getY() > this.dungeonMap.getHeight()) {
			this.dungeonMap.getEntities().get(i).setY(this.dungeonMap.getHeight());
		} else if (this.dungeonMap.getEntities().get(i).getY() < 0) {
			this.dungeonMap.getEntities().get(i).setY(0);
		}
	}
	

	public void move(String move) {
		Movement m = new Movement(dungeonMap.getHero().getX(), dungeonMap.getHero().getY());
		m.readMovement(move);
		System.out.println(m);
		this.dungeonMap.getHero().move(m.getNewX(), m.getNewY());
		movementCorrection(0);
		System.out.println(dungeonMap.getHero());
		setTurns(this.getTurns() - 1);
		for(int i = 1; i < this.dungeonMap.getEntities().size(); i++) {
			if (this.dungeonMap.getEntities().get(i).getX() == this.dungeonMap.getHero().getX() && this.dungeonMap.getEntities().get(i).getY() == this.dungeonMap.getHero().getY()) {
				this.dungeonMap.getEntities().remove(i);
				this.vampires--;
			} else {
				m.readMovement(m.vampireMovement());
				System.out.println(m);
				this.dungeonMap.getEntities().get(i).move(m.getNewX(), m.getNewY());
				movementCorrection(i);
				System.out.println(this.dungeonMap.getEntities().get(i));
// esta es la parte del código que no funciona.				
//				while(m.vampireColision(this.dungeonMap.getEntities().get(i))) {
//					Movement n = new Movement(dungeonMap.getHero().getX(), dungeonMap.getHero().getY());
//					m.readMovement(n.vampireMovement());
//					System.out.println(this.dungeonMap.getEntities());
//					this.dungeonMap.getEntities().get(i).move(n.getNewX(), n.getNewY());
//					movementCorrection(i);
//					System.out.println(m);
//				}
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
