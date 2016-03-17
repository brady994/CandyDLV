package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private int firstClickX = 0;
	private int firstClickY = 0;
	private boolean first=true;

	Panel(GameWorld gw) {
		this.gw = gw;
		this.currentCell = null;
		this.nextCell = null;
		addMouseListener(this);
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

	public int getFirstClickX() {
		return firstClickX;
	}

	public int getFirstClickY() {
		return firstClickY;
	}

	public void setFirstClickX(int firstClickX) {
		this.firstClickX = firstClickX;
	}

	public void setFirstClickY(int firstClickY) {
		this.firstClickY = firstClickY;
	}

	private void paintCell(Graphics g, int row, int col, Candy c,int b,int a) {
		int x = (Cell.getSIZE() * row);
		int y = (Cell.getSIZE() * col);

		g.drawRect(b+x, a+y, Cell.getSIZE(), Cell.getSIZE());
		if(c!=null)
			c.paint(g, b+x + 10,a+ y + 10);
	}

	private void hightOneCell(Graphics g, int row, int col) {
		int x = (Cell.getSIZE() * row)+270;
		int y = (Cell.getSIZE() * col)+100;
		g.setColor(Color.RED);
		g.drawRect(x, y, Cell.getSIZE(), Cell.getSIZE());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < gw.getHeight(); i++) 
		{
			int a = 100;
			for (int j = 0; j < gw.getWidth(); j++) 
			{
				int b = 270;
				Candy c = gw.getCandy(i, j);
				paintCell(g, i, j, c,b,a);
				b++;
			}
		}
		if (currentCell != null) 
		{
			hightOneCell(g, currentCell.getRow(), currentCell.getCol());
		}
		if (nextCell != null) 
		{
			hightOneCell(g, nextCell.getRow(), nextCell.getCol());
		}
		
		try{
			gw.setCell();
			gw.checkAfterChangeO();
			gw.checkAfterChangeV();
			Thread.sleep(250);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{

	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		int row = (e.getX()-270)/Cell.getSIZE();
		int col = (e.getY()-100)/ Cell.getSIZE();
		System.out.println(row + "                        mouse");
		System.out.println(col + " 							mouse");
		if (currentCell == null) {
			if ((e.getX() / Cell.getSIZE()) <= 8 && (e.getY() / Cell.getSIZE()) <= 8) {
				currentCell = new Cell(row, col, gw.getCandy(row, col));
			}
		} else if (nextCell == null) {
			if ((e.getX() / Cell.getSIZE()) <= 8 && (e.getY() / Cell.getSIZE()) <= 8) {
				nextCell = new Cell(row, col, gw.getCandy(row, col));
			}
		}

		if (currentCell != null && nextCell != null) {

			int difX = Math.abs(currentCell.getCol() - nextCell.getCol());
			int difY = Math.abs(currentCell.getRow() - nextCell.getRow());
			if (difX == 1 && difY == 0) {
				gw.setCandies(currentCell.getCol(), currentCell.getRow(), nextCell.getCol(), nextCell.getRow());
				repaint();
			} else {
				paintString("Puoi postare solo di una posizione");
			}
			if (difY == 1 && difX == 0) {

				gw.setCandies(currentCell.getCol(), currentCell.getRow(), nextCell.getCol(), nextCell.getRow());

				repaint();

			} 
			else 
			{
				paintString("Puoi postare solo di una posizione");
			}
			currentCell = null;
			nextCell = null;
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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