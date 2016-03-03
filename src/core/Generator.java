package core;

import java.util.Random;

public class Generator implements IGenerator {

	public Candy randomCandy(int type) 
	{
		
		if(type==1)
			return new Candy1();
		else if(type == 2)
				return new Candy2();
		else if(type == 3)
				return new Candy3();
		else
			return null;
		
	}

	@Override
	public void inizialize(Candy[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				Random r = new Random();
				c[i][j] = randomCandy(r.nextInt(3) + 1);

			}
		}

	}

}
