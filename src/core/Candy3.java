package core;

import java.awt.Graphics;

public class Candy3 implements Candy {

	@Override
	public int getType() {
		return 3;
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(ImageLoader.getCandyGreen(), x, y, null);

	}

}
