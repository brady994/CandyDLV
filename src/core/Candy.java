package core;

import java.awt.Graphics;

public interface Candy 
{
	
	int getType();
	void setType(int x);

	void paint(Graphics g, int x, int y);
	
	

}
