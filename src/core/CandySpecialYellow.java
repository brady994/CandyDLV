package core;

import java.awt.Graphics;

public class CandySpecialYellow implements Candy {

	@Override
	public int getType() {

		return 10;
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(ImageLoader.getSpecialYellow(), x, y, null);

	}

}
