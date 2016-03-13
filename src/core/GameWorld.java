package core;

import java.util.ArrayList;

public class GameWorld {
	private Candy[][] candies;
	private IGenerator g;
	private int score;

	private int rowS;
	private int colS;

	public GameWorld(int row, int col) {
		this.rowS = row;
		this.colS = col;
		this.candies = new Candy[row][col];
		this.g = new Generator();
		g.inizialize(candies);
		this.score = 0;

	}

	public void setCandies() {
		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				candies[i][j] = null;
			}
		}
	}

	public Candy getCandy(int r, int c) {
		return candies[r][c];
	}

	public int getHeight() {
		return candies.length;
	}

	public int getWidth() {
		return candies[0].length;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/*
	 * public void setCandies(Cell[] c) { if (c.length == 2) { int row =
	 * c[0].getRow(); int col = c[0].getCol(); int row1 = c[1].getRow(); int
	 * col1 = c[1].getCol(); int tmpRow1 = row1; int tmpCol1 = col1; int cont =
	 * 0;
	 * 
	 * System.out.println(row1); System.out.println(col1); col1 -= 1; // up in
	 * vertical while (col1 > 0 && c[0].getIcon().equals(candies[row1][col1])) {
	 * cont++; System.out.println("up vertical " + col1 + " " + row1 + "t1 " +
	 * candies[row][col].getType() + "t2 " + candies[row1][col1].getType());
	 * col1 -= 1;
	 * 
	 * }
	 * 
	 * col1 = tmpCol1; col1 += 1; // down in vertical System.out.println(row1);
	 * System.out.println(col1); while (col1 < colS &&
	 * candies[row][col].getType() == candies[row1][col1].getType()) { cont++;
	 * System.out.println("down vertical " + col1 + " " + row1 + "t1 " +
	 * candies[row][col].getType() + "t2 " + candies[row1][col1].getType());
	 * col1 += 1;
	 * 
	 * }
	 * 
	 * // orizzontal right col1 = tmpCol1; row1 += 1;
	 * 
	 * while (row1 < rowS && c[0].getIcon().equals(candies[row1][col1])) {
	 * cont++; System.out.println("orizzontal right " + col1 + " " + row1 +
	 * "t1 " + candies[row][col].getType() + "t2 " +
	 * candies[row1][col1].getType()); row1 += 1;
	 * 
	 * }
	 * 
	 * // orizzontal left row1 = tmpRow1; row1 -= 1; while (row1 > 0 &&
	 * c[0].getIcon().equals(candies[row1][col1])) { cont++;
	 * System.out.println("orizzontal left " + col1 + " " + row1 + "t1 " +
	 * candies[row][col].getType() + "t2 " + candies[row1][col1].getType());
	 * row1 -= 1;
	 * 
	 * }
	 * 
	 * System.out.println(cont + "cont"); row1 = tmpRow1; col1 = tmpCol1;
	 * 
	 * if (cont >= 2) { Candy tmp = getCandy(row, col); candies[row][col] =
	 * candies[row1][col1]; candies[row1][col1] = tmp; }
	 * 
	 * } }
	 */
	public void setCandies(int x, int y, int x1, int y1) {
		Candy tmp = candies[y][x];
		candies[y][x] = candies[y1][x1];
		candies[y1][x1] = tmp;
		if (!checkMoreCandies(x1, y1)) {
			Candy tmp1 = candies[y][x];
			candies[y][x] = candies[y1][x1];
			candies[y1][x1] = tmp1;
		}

	}

	public boolean checkMoreCandies(int x, int y) {
		int indice = 1;
		int countV = 1;
		int countO = 1;
		int tmp = candies[y][x].getType();

		while ((x < colS - 1) && (tmp == (candies[y][x + indice].getType()))) {
			countV++;
			indice++;
			if (x + indice >= colS)
				break;
		}

		indice = 1;
		while ((x > 0) && (tmp == (candies[y][x - indice].getType()))) {
			countV++;
			indice++;
			if (x - indice < 0)
				break;

		}
		if (countV >= 3) {
			System.out.println(countV + "finalV");
			return true;
		}
		countV = 1;
		countO = 1;
		indice = 1;
		while ((y < rowS - 1) && (tmp == (candies[y + indice][x].getType()))) {
			countO++;
			indice++;
			if (y + indice >= rowS)
				break;

		}

		indice = 1;

		while ((y > 0) && (tmp == (candies[y - indice][x].getType()))) {
			countO++;
			indice++;
			if (y - indice < 0)
				break;

		}
		if (countO >= 3) {
			System.out.println(countO + "final O");
			return true;
		}

		return false;
	}

	public ArrayList<Cell> checkAfterChangeV() {

		ArrayList<Cell> cell = new ArrayList<Cell>();

		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				// verticale
				if (j > 0 && candies[i][j].getType() == candies[i][j - 1].getType()) {

					cell.add(new Cell(i, j, candies[i][j]));

				} else if (j < colS - 1 && candies[i][j].getType() == candies[i][j + 1].getType()) {

					cell.add(new Cell(i, j, candies[i][j]));
				}

			}

		}

		ArrayList<Cell> tmp = new ArrayList<Cell>();
		int indTmp = 0;
		int indColTmp = 1;

		int count = 1;
		for (int k = 0; k < cell.size(); k++) {

			for (int a = k + 1; a < cell.size(); a++) {

				if (cell.get(k).getIcon().getType() == cell.get(a).getIcon().getType()
						&& cell.get(k).getRow() == cell.get(a).getRow()
						&& (cell.get(k).getCol() + indColTmp) == cell.get(a).getCol()) {
					indTmp = cell.get(a).getCol();
					count++;
					indColTmp++;

				}

			}
			indColTmp = 1;

			if (count >= 3) {

				for (int k2 = 0; k2 < count; k2++) {
					tmp.add(new Cell(cell.get(k).getRow(), indTmp - k2, candies[cell.get(k).getRow()][indTmp - k2]));
				}

				k += count - 1;
			}
			count = 1;
			indTmp = 0;
		}

		for (int k = 0; k < tmp.size(); k++) {
			System.out.println("I'm hashmap V" + " " + tmp.get(k).getRow() + " " + tmp.get(k).getCol() + " tipe "
					+ tmp.get(k).getIcon().getType());
		}
		System.out.println(tmp.size() + "size");
		return tmp;
	}

	public ArrayList<Cell> checkAfterChangeO() {
		ArrayList<Cell> cell = new ArrayList<Cell>();
		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {

				if (j > 0 && candies[j][i].getType() == candies[j - 1][i].getType()) {
					cell.add(new Cell(j, i, candies[j][i]));

				} else if (j < colS - 1 && candies[j][i].getType() == candies[j + 1][i].getType()) {
					cell.add(new Cell(j, i, candies[j][i]));

				}

			}
		}

		ArrayList<Cell> tmp = new ArrayList<Cell>();

		int indTmp = 0;
		int indRowTmp = 1;
		int count = 1;

		for (int k = 0; k < cell.size(); k++) {

			for (int a = k + 1; a < cell.size(); a++) {
				// orizzontali
				if (cell.get(k).getIcon().getType() == cell.get(a).getIcon().getType()
						&& cell.get(k).getCol() == cell.get(a).getCol()
						&& (cell.get(k).getRow() + indRowTmp) == cell.get(a).getRow()) {
					indTmp = cell.get(a).getRow();
					count++;
					indRowTmp++;

				}

			}
			indRowTmp = 1;

			if (count >= 3) {

				for (int k2 = 0; k2 < count; k2++) {
					tmp.add(new Cell(cell.get(k).getCol(), indTmp - k2, candies[cell.get(k).getCol()][indTmp - k2]));
				}

				k += count - 1;

			}
			count = 1;
			indTmp = 0;
		}

		for (int k = 0; k < tmp.size(); k++) {
			System.out.println("I'm hashmap O" + " " + tmp.get(k).getCol() + " " + tmp.get(k).getRow() + " tipe "
					+ tmp.get(k).getIcon().getType());
		}
		System.out.println(tmp.size() + "size");
		return tmp;

	}
}
