package core;

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
			System.out.println(countO + "finalO");
			return true;
		}

		return false;
	}

}
