package core;

import java.awt.Graphics;

public class CandySpecialGreen implements Candy {

	@Override
	public int getType() {
		return 30;
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(ImageLoader.getSpecialGreen(), x, y, null);

	}

}
