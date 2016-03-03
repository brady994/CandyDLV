package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import core.Candy;
import core.Cell;
import core.GameWorld;

public class Panel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private GameWorld gw;
	private Cell currentCell;
	private Cell nextCell;

	Panel(GameWorld gw) {
		this.gw = gw;
		addMouseListener(this);
		this.setBackground(Color.WHITE);

	}

	private void paintCell(Graphics g, int row, int col, Candy c) {
		int x = Cell.getSIZE() * row;
		int y = Cell.getSIZE() * col;

		g.drawRect(x, y, Cell.getSIZE(), Cell.getSIZE());
		c.paint(g, x, y);
	}

	private void hightOneCell(Graphics g, int row, int col) {
		int x = Cell.getSIZE() * row;
		int y = Cell.getSIZE() * col;
		g.setColor(Color.RED);
		g.drawRect(x, y, Cell.getSIZE(), Cell.getSIZE());
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
		if (currentCell != null) {
			hightOneCell(g, currentCell.getRow(), currentCell.getCol());
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = e.getX() / Cell.getSIZE();
		int col = e.getY() / Cell.getSIZE();
		currentCell = new Cell(row, col, gw.getCandy(row, col));
		System.out.println(row + " " + col);
		repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Cell tmp;
		int row = e.getX() / Cell.getSIZE();
		int col = e.getY() / Cell.getSIZE();
		System.out.println(row + "" + col + "release");
		tmp = new Cell(row, col, gw.getCandy(row, col));
		nextCell = currentCell;
		currentCell = tmp;
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//

	}

	@Override
	public void mouseExited(MouseEvent e) {
		//

	}

	public Cell getCurrentCell() {
		return currentCell;
	}
}
