package core;

import java.util.ArrayList;

public class GameWorld {
	public Candy[][] candies;
	private IGenerator g;
	private int score;

	public static int rowS;
	public static int colS;

	public GameWorld(int row, int col) {
		this.rowS = row;
		this.colS = col;
		this.candies = new Candy[row][col];
		this.g = new Generator();
		g.inizialize(candies);
		this.score = 0;

	}

	public void cancellaO(ArrayList<Cell> c) {
		if (c.size() == 3) {

			for (int i = 0; i < c.size(); i++) {

				candies[c.get(i).getRow()][c.get(i).getCol()] = null;

			}
		} else if (c.size() > 3) {
			for (int j = 0; j < c.size() - 1; j++) {

				candies[c.get(j).getRow()][c.get(j).getCol()] = null;

			}
			candies[c.get(c.size() - 1).getRow()][c.get(c.size() - 1).getCol()] = randomCandy(c.get(c.size() - 1).getIcon()
					.getType() * 10);
			// System.out.println(c.get(c.size() - 1).getRow() + " rc cc" +
			// c.get(c.size() - 1).getCol() + "ty "
			// + c.get(c.size() - 1).getIcon().getType() * 10);
		}

	}

	public void cancellaV(ArrayList<Cell> c) {
		if (c.size() == 3) {
			System.out.println("si canc");
			for (int i = 0; i < c.size(); i++) {
				candies[c.get(i).getRow()][c.get(i).getCol()] = null;
			}
		} else if (c.size() > 3) {
			System.out.println("verticale");
			for (int j = 0; j < c.size() - 1; j++) {
				candies[c.get(j).getRow()][c.get(j).getCol()] = null;
			}
			candies[c.get(c.size() - 1).getRow()][c.get(c.size() - 1).getCol()] = randomCandy(c.get(c.size() - 1).getIcon()
					.getType() * 10);
		}

	}

	public void setCandies() {
		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				candies[i][j] = null;
			}
		}
	}

	public void setCell() {

		ArrayList<Cell> col1 = new ArrayList<Cell>();
		ArrayList<Cell> col2 = new ArrayList<Cell>();
		ArrayList<Cell> col3 = new ArrayList<Cell>();
		ArrayList<Cell> col4 = new ArrayList<Cell>();
		ArrayList<Cell> col5 = new ArrayList<Cell>();
		ArrayList<Cell> col6 = new ArrayList<Cell>();

		int i = 0;
		for (int j = 0; j < rowS; j++) {
			if (candies[i][j] != null) {
				col1.add(new Cell(i, j, candies[i][j]));

			}

		}

		for (int j = col1.size() - 1; j >= 0; j--) {
			Cell last = col1.get(j);
			for (int k = last.getCol() + 1; k < rowS; k++) {

				if (k < rowS && candies[i][k] == null) {
					Candy tmpc = candies[last.getRow()][last.getCol()];
					candies[i][k] = tmpc;
					candies[i][last.getCol()] = null;

				}
			}
		}

		i = 1;
		for (int j = 0; j < rowS; j++) {
			if (candies[i][j] != null) {
				col2.add(new Cell(i, j, candies[i][j]));

			}

		}

		for (int j = col2.size() - 1; j >= 0; j--) {
			Cell last = col2.get(j);
			for (int k = last.getCol() + 1; k < rowS; k++) {

				if (k < rowS && candies[i][k] == null) {
					Candy tmpc = candies[last.getRow()][last.getCol()];
					candies[i][k] = tmpc;
					candies[i][last.getCol()] = null;

				}
			}
		}

		i = 2;
		for (int j = 0; j < rowS; j++) {
			if (candies[i][j] != null) {
				col3.add(new Cell(i, j, candies[i][j]));

			}

		}

		for (int j = col3.size() - 1; j >= 0; j--) {
			Cell last = col3.get(j);
			for (int k = last.getCol() + 1; k < rowS; k++) {

				if (k < rowS && candies[i][k] == null) {
					Candy tmpc = candies[last.getRow()][last.getCol()];
					candies[i][k] = tmpc;
					candies[i][last.getCol()] = null;

				}
			}
		}

		i = 3;
		for (int j = 0; j < rowS; j++) {
			if (candies[i][j] != null) {
				col4.add(new Cell(i, j, candies[i][j]));

			}

		}

		for (int j = col4.size() - 1; j >= 0; j--) {
			Cell last = col4.get(j);
			for (int k = last.getCol() + 1; k < rowS; k++) {

				if (k < rowS && candies[i][k] == null) {
					Candy tmpc = candies[last.getRow()][last.getCol()];
					candies[i][k] = tmpc;
					candies[i][last.getCol()] = null;

				}
			}
		}

		i = 4;
		for (int j = 0; j < rowS; j++) {
			if (candies[i][j] != null) {
				col5.add(new Cell(i, j, candies[i][j]));

			}

		}

		for (int j = col5.size() - 1; j >= 0; j--) {
			Cell last = col5.get(j);
			for (int k = last.getCol() + 1; k < rowS; k++) {

				if (k < rowS && candies[i][k] == null) {
					Candy tmpc = candies[last.getRow()][last.getCol()];
					candies[i][k] = tmpc;
					candies[i][last.getCol()] = null;

				}
			}
		}

		i = 5;
		for (int j = 0; j < rowS; j++) {
			if (candies[i][j] != null) {
				col6.add(new Cell(i, j, candies[i][j]));

			}

		}

		for (int j = col6.size() - 1; j >= 0; j--) {
			Cell last = col6.get(j);
			for (int k = last.getCol() + 1; k < rowS; k++) {

				if (k < rowS && candies[i][k] == null) {
					Candy tmpc = candies[last.getRow()][last.getCol()];
					candies[i][k] = tmpc;
					candies[i][last.getCol()] = null;

				}
			}
		}

		// for ()
		g.inizializeCell(candies);

	}

	public Candy randomCandy(int type) {

		if (type == 1)
			return new Candy1();
		else if (type == 2)
			return new Candy2();
		else if (type == 3)
			return new Candy3();
		else if (type == 30) {
			return new CandySpecialGreen();
		} else if (type == 20) {
			return new CandySpecialOrange();
		} else if (type == 10) {
			return new CandySpecialYellow();
		}
		return null;

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

	public void setCandies(int x, int y, int x1, int y1) {
		Candy tmp = candies[y][x];
		candies[y][x] = candies[y1][x1];
		candies[y1][x1] = tmp;
		if (checkMoreCandiesV(x1, y1) < 3 && checkMoreCandiesO(x1, y1) < 3) {
			Candy tmp1 = candies[y][x];
			candies[y][x] = candies[y1][x1];
			candies[y1][x1] = tmp1;
		}

	}

	public int checkMoreCandiesV(int x, int y) {
		int indice = 1;
		int countV = 1;

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
		System.out.println(countV + " count v");
		return countV;
		// if (countV == 3)
		// {
		// return 3;
		// }
		// else if(countV > 3)
		// {
		// return 4;
		// }
		// else
		// {
		// return 2;
		// }

	}

	public int checkMoreCandiesO(int x, int y) {
		int countO = 1;
		int indice = 1;
		int tmp = candies[y][x].getType();
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
		System.out.println(countO + " count o");
		return countO;
	}

	public ArrayList<Cell> checkAfterChangeV() {

		ArrayList<Cell> cell = new ArrayList<Cell>();

		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				// verticale
				if (candies[i][j] != null && j > 0 && candies[i][j - 1] != null
						&& candies[i][j].getType() == candies[i][j - 1].getType()) {

					cell.add(new Cell(i, j, candies[i][j]));

				} else if (candies[i][j] != null && j < colS - 1 && candies[i][j + 1] != null
						&& candies[i][j].getType() == candies[i][j + 1].getType()) {

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
		return tmp;

		// for (int k = 0; k < tmp.size(); k++) {
		// System.out.println("I'm hashmap V" + " " + tmp.get(k).getRow() + " "
		// + tmp.get(k).getCol() + " tipe "
		// + tmp.get(k).getIcon().getType());
		// }

	}

	public void cancellaTmpV(ArrayList<Cell> tmp) {
		ArrayList<Cell> canc = new ArrayList<Cell>();
		int count1 = 1;
		int indTmp1 = 0;
		int indColTmp1 = 1;

		for (int k = 0; k < tmp.size(); k++) {

			for (int a = k + 1; a < tmp.size(); a++) {

				if (tmp.get(k).getIcon().getType() == tmp.get(a).getIcon().getType()
						&& tmp.get(k).getRow() == tmp.get(a).getRow()
						&& (tmp.get(a).getCol() + indColTmp1) == tmp.get(k).getCol()) {

					indTmp1 = tmp.get(a).getCol();
					count1++;
					indColTmp1++;
				}

			}
			indColTmp1 = 1;

			for (int k2 = 0; k2 < count1; k2++) {
				canc.add(new Cell(tmp.get(k).getRow(), indTmp1 + k2, candies[tmp.get(k).getRow()][indTmp1 + k2]));
			}

			k += count1 - 1;
			count1 = 1;
			indTmp1 = 0;

			cancellaV(canc);
			canc.clear();
		}

	}

	public ArrayList<Cell> checkAfterChangeO() {
		ArrayList<Cell> cell = new ArrayList<Cell>();
		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {

				if (candies[j][i] != null && j > 0 && candies[j - 1][i] != null
						&& candies[j][i].getType() == candies[j - 1][i].getType()) {

					cell.add(new Cell(j, i, candies[j][i]));

				} else if (candies[j][i] != null && j < colS - 1 && candies[j + 1][i] != null
						&& candies[j][i].getType() == candies[j + 1][i].getType()) {

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
					// System.out.println("inf " + (indTmp - k2));
					tmp.add(new Cell(indTmp - k2, cell.get(k).getCol(), candies[indTmp - k2][cell.get(k).getCol()]));

				}

				k += count - 1;
			}
			count = 1;
			indTmp = 0;
		}
		// for (int k = 0; k < tmp.size(); k++) {
		// System.out.println("I'm hashmap O" + " " + tmp.get(k).getRow() + " "
		// + tmp.get(k).getCol() + " tipe "
		// + tmp.get(k).getIcon().getType());
		// }
		// System.out.println(tmp.size() + "sizeS");

		return tmp;

	}

	public void tmpCancellaO(ArrayList<Cell> tmp) {
		ArrayList<Cell> canc = new ArrayList<Cell>();
		int indTmp1 = 0;
		int indRowTmp1 = 1;
		int count1 = 1;

		for (int k = 0; k < tmp.size(); k++) {
			System.out.println(k + " k");
			for (int a = k + 1; a < tmp.size(); a++) {

				// System.out.println((tmp.get(k).getRow()) + " r c " +
				// tmp.get(k).getCol());
				if (tmp.get(k).getIcon().getType() == tmp.get(a).getIcon().getType()
						&& tmp.get(k).getCol() == tmp.get(a).getCol()
						&& (tmp.get(a).getRow() + indRowTmp1) == tmp.get(k).getRow()) {
					// System.out.println("si");
					// System.out.println(tmp.get(a).getCol() + indRowTmp1 + " "
					// + tmp.get(k).getCol());

					indTmp1 = tmp.get(a).getRow();
					count1++;
					indRowTmp1++;
				}
			}

			indRowTmp1 = 1;

			for (int k2 = 0; k2 < count1; k2++) {
				canc.add(new Cell(indTmp1 + k2, tmp.get(k).getCol(), candies[indTmp1 + k2][tmp.get(k).getCol()]));

			}

			k += count1 - 1;
			System.out.println(k + " k");

			count1 = 1;
			indTmp1 = 0;

			cancellaO(canc);
			canc.clear();
		}
	}

	public boolean check() {
		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				if (candies[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void start() {
		setCell();
		if (check()) {
			System.out.println("si");
			checkAfterChangeO();
			checkAfterChangeV();
		}
	}
	public boolean checkSpecialCandy()
	{
		for (int i = 0; i < rowS ; i++) 
		{
			for (int j = 0; j < colS; j++) 
			{
				if((candies[i][j].getType()==30 || candies[i][j].getType()==20 || candies[i][j].getType()==10) && candies[i][j]!=null)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public void removeSpecialCandy()
	{
		int tmp=0;
		boolean exit=false;
		for (int i = 0; i < rowS && !exit; i++) 
		{
			for (int j = 0; j < colS ; j++) 
			{
				if((candies[i][j].getType()==30 || candies[i][j].getType()==20 || candies[i][j].getType()==10) && candies[i][j]!=null)
				{
					tmp=candies[i][j].getType();
					break;
				}
			}
			if(tmp!=0)
				exit=true;
		}
		for (int i = 0; i < rowS; i++) 
		{
			for (int j = 0; j < colS; j++) 
			{
				if((candies[i][j].getType()==(tmp/10) || candies[i][j].getType() ==tmp) && candies[i][j]!=null)
				{
					candies[i][j]=null;
				}
			}
		}
	}
	
}
