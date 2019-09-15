package pac1;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(1, 10);
			map.createEntities(3);
			for (int i = 0; i < 10; i++) {
				map.printMapLine(i);
			}
			System.out.println(map.getEntities());

	}

}
