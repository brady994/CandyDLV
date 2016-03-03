package core;

import java.util.Random;

public class Generator implements IGenerator {

	public Candy randomCandy(int type) {
		switch (type) {
		case 1:
			return new Candy1();

		case 2:
			return new Candy2();
		default:
			break;
		}
		return null;

	}

	@Override
	public void inizialize(Candy[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				Random r = new Random();
				c[i][j] = randomCandy(r.nextInt(2) + 1);
				System.out.println(r.nextInt(2) + 1);

			}
		}

	}

}
