package pac1;

public class Human extends Entities {
	private String name;

	public Human(int x, int y) {
		super(x, y);
		this.name = "@";
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

}
