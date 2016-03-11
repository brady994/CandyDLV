package core;

public class Cell {

	private int row;
	private int col;
	private Candy candy;
	private static int SIZE = 90;

	public Cell(int row, int col, Candy icon) {
		this.row = row;
		this.col = col;
		this.candy = icon;
	}
	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public Candy getIcon() {
		return candy;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setIcon(Candy icon) {
		this.candy = icon;
	}
	public static int getSIZE() {
		return SIZE;
	}
	public static int getAllSize()
	{
		return SIZE*6;   //be careful
		
	}

}
