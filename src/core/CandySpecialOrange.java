package core;

import java.awt.Graphics;

public class CandySpecialOrange implements Candy {

	@Override
	public int getType() {

		return 20;
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(ImageLoader.getSpecialOrange(), x, y, null);

	}

}
