package core;

import java.awt.Graphics;

public class Candy1 implements Candy {

	@Override
	public int getType() 
	{

		return 1;
	}

	@Override
	public void paint(Graphics g, int x, int y) 
	{
		g.drawImage(ImageLoader.getCandyYellow(), x, y, null);
	}

}
