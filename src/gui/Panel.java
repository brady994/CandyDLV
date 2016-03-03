package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import core.Candy;
import core.Cell;
import core.GameWorld;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private GameWorld gw;

	Panel(GameWorld gw) {
		this.gw = gw;

	}

	private void paintCell(Graphics g, int row, int col, Candy c) {
		int x = Cell.getSIZE() * row;
		int y = Cell.getSIZE() * col;

		g.drawRect(x, y, Cell.getSIZE(), Cell.getSIZE());
		c.paint(g, x, y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < gw.getHeight(); i++) {
			for (int j = 0; j < gw.getWidth(); j++) {
				Candy c = gw.getCandy(i, j);
				paintCell(g, i, j, c);
			}
		}

	}
}
