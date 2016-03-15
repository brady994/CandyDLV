package core;

import java.awt.Graphics;

public class Candy2 implements Candy {

	int type;
	@Override
	public int getType() {
		return 2;
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(ImageLoader.getCandyOrange(), x, y, null);

	}

	@Override
	public void setType(int x) 
	{
		this.type=type;
		
	}


	
}
