package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

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
		addMouseMotionListener(new MyMouseMotionListener());
		this.setBackground(Color.WHITE);

	}

	public void paintString(String n) {

		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				getGraphics().drawString("Direzione errata", 550, 500);
			}
		}, 5 * 1000);
		getGraphics().drawString("", 550, 500);
	}

	private void paintCell(Graphics g, int row, int col, Candy c) {
		int x = Cell.getSIZE() * row;
		int y = Cell.getSIZE() * col;

		g.drawRect(x, y, Cell.getSIZE(), Cell.getSIZE());
		c.paint(g, x + 10, y + 10);
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
		if (nextCell != null) {
			hightOneCell(g, nextCell.getRow(), nextCell.getCol());
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int row = e.getX() / Cell.getSIZE();
		int col = e.getY() / Cell.getSIZE();
		if (e.getX() <= Cell.getAllSize() && e.getY() <= Cell.getAllSize()) {
			currentCell = new Cell(row, col, gw.getCandy(row, col));

			repaint();
		} else {

			paintString("Direzione errata");
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getX() <= Cell.getAllSize() && e.getY() <= Cell.getAllSize()) {
			gw.setCandies(new Cell[] { nextCell, currentCell });
			repaint();
		} else {
			paintString("Direzione errata");
			repaint();
		}

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

	private class MyMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			int row = e.getX() / Cell.getSIZE();
			int col = e.getY() / Cell.getSIZE();
			nextCell = new Cell(row, col, gw.getCandy(row, col));
			repaint();

		}

		@Override
		public void mouseMoved(MouseEvent e) {

		}
	}

}
