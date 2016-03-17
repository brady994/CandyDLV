package core;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
	public  Candy[][] candies;
	private IGenerator g;
	private int score;
	

	public static   int rowS;
	public static int colS;

	public GameWorld(int row, int col) {
		this.rowS = row;
		this.colS = col;
		this.candies = new Candy[row][col];
		this.g = new Generator();
		g.inizialize(candies);
		this.score = 0;

	}
	
	public void cancella(int x,int y)
	{
		candies[x][y]=null;
		
	}
	
	public void setCandies() {
		for (int i = 0; i < rowS; i++) 
		{
			for (int j = 0; j < colS; j++) 
			{
				candies[i][j] = null;
			}
		}
	}
	public void setCell()
	{
			
			ArrayList<Cell> col1 = new ArrayList<Cell>();
			ArrayList<Cell> col2 = new ArrayList<Cell>();
			ArrayList<Cell> col3 = new ArrayList<Cell>();
			ArrayList<Cell> col4 = new ArrayList<Cell>();
			ArrayList<Cell> col5 = new ArrayList<Cell>();
			ArrayList<Cell> col6 = new ArrayList<Cell>();
			
			int i=0;
			for (int j = 0; j < rowS; j++) 
			{
				if (candies[i][j]!= null)
				{
					col1.add(new Cell(i,j,candies[i][j]));
					
				}
				
			}
			
			for (int j =col1.size()-1; j >=0;j--){
				Cell last = col1.get(j);
				for (int k = last.getCol()+1;k<rowS; k++ ){
					
					if (k < rowS && candies[i][k]==null){
						Candy tmpc = candies[last.getRow()][last.getCol()];
						candies[i][k]=tmpc;
						candies[i][last.getCol()]=null;
						
					}
				}
			}
			
			 i=1;
			for (int j = 0; j < rowS; j++) 
			{
				if (candies[i][j]!= null)
				{
					col2.add(new Cell(i,j,candies[i][j]));
					
				}
				
			}
			
			for (int j =col2.size()-1; j >=0;j--){
				Cell last = col2.get(j);
				for (int k = last.getCol()+1;k < rowS; k++ ){
					
					if (k < rowS && candies[i][k]==null){
						Candy tmpc = candies[last.getRow()][last.getCol()];
						candies[i][k]=tmpc;
						candies[i][last.getCol()]=null;
						
					}
				}
			}
			
			i=2;
			for (int j = 0; j < rowS; j++) 
			{
				if (candies[i][j]!= null)
				{
					col3.add(new Cell(i,j,candies[i][j]));
					
				}
				
			}
			
			for (int j =col3.size()-1; j >=0;j--){
				Cell last = col3.get(j);
				for (int k = last.getCol()+1;k<rowS; k++ ){
					
					if (k < rowS && candies[i][k]==null){
						Candy tmpc = candies[last.getRow()][last.getCol()];
						candies[i][k]=tmpc;
						candies[i][last.getCol()]=null;
						
					}
				}
			}
			
			 i=3;
			for (int j = 0; j < rowS; j++) 
			{
				if (candies[i][j]!= null)
				{
					col4.add(new Cell(i,j,candies[i][j]));
					
				}
				
			}
			
			for (int j =col4.size()-1; j >=0;j--){
				Cell last = col4.get(j);
				for (int k = last.getCol()+1;k<rowS; k++ ){
					
					if (k < rowS && candies[i][k]==null){
						Candy tmpc = candies[last.getRow()][last.getCol()];
						candies[i][k]=tmpc;
						candies[i][last.getCol()]=null;
						
					}
				}
			}
			
			i=4;
			for (int j = 0; j < rowS; j++) 
			{
				if (candies[i][j]!= null)
				{
					col5.add(new Cell(i,j,candies[i][j]));
					
				}
				
			}
			
			for (int j =col5.size()-1; j >=0;j--){
				Cell last = col5.get(j);
				for (int k = last.getCol()+1;k<rowS; k++ ){
				
					if (k < rowS && candies[i][k]==null){
						Candy tmpc = candies[last.getRow()][last.getCol()];
						candies[i][k]=tmpc;
						candies[i][last.getCol()]=null;
						
					}
				}
			}
			
			 i=5;
			for (int j = 0; j < rowS; j++) 
			{
				if (candies[i][j]!= null)
				{
					col6.add(new Cell(i,j,candies[i][j]));
					
				}
				
			}
			
			for (int j =col6.size()-1; j >=0;j--)
			{
				Cell last = col6.get(j);
				for (int k = last.getCol()+1;k<rowS; k++ )
				{
					
					if (k < rowS && candies[i][k]==null)
					{
						Candy tmpc = candies[last.getRow()][last.getCol()];
						candies[i][k]=tmpc;
						candies[i][last.getCol()]=null;
						
					}
				}
			}
			
			//for ()
			g.inizializeCell(candies);
			
	}
	public Candy randomCandy(int type) 
	{
		
		if(type==1)
			return new Candy1();
		else if(type == 2)
				return new Candy2();
		else if(type == 3)
				return new Candy3();
		else
			return null;
		
	}
	public Candy getCandy(int r, int c) 
	{
		return candies[r][c];
	}

	public int getHeight() 
	{
		return candies.length;
	}

	public int getWidth() 
	{
		return candies[0].length;
	}

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}

	
	public void setCandies(int x, int y, int x1, int y1) 
	{
		Candy tmp = candies[y][x];
		candies[y][x] = candies[y1][x1];
		candies[y1][x1] = tmp;
		if (checkMoreCandies(x1, y1) < 3) 
		{
			Candy tmp1 = candies[y][x];
			candies[y][x] = candies[y1][x1];
			candies[y1][x1] = tmp1;
		}

	}

	public int checkMoreCandies(int x, int y) 
	{
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
//		if (countV == 3) 
//		{
//			return 3;
//		}
//		else if(countV > 3)
//		{
//			return 4;
//		}
//		else 
//		{
//			return 2;
//		}
		
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
		if (countO == 3 ) 
			return 3;
		if(countV==3)
			return 3;
		if(countO > 3 )
			return 4;
		if( countO >3)
			return 4;
		if(countO < 3)
			return 2;
		if( countV < 3)
			return 2;
		return tmp;
		
		
	}

	public void checkAfterChangeV() 
	{

		ArrayList<Cell> cell = new ArrayList<Cell>();

		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				// verticale
				if (candies[i][j]!=null && j>0 && candies[i][j-1]!=null && candies[i][j].getType() == candies[i][j - 1].getType()) {

					cell.add(new Cell(i, j, candies[i][j]));

				} else if (candies[i][j]!=null && j < colS - 1 && candies[i][j+1]!=null && candies[i][j].getType() == candies[i][j + 1].getType()) {

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

//		for (int k = 0; k < tmp.size(); k++) {
//			System.out.println("I'm hashmap V" + " " + tmp.get(k).getRow() + " " + tmp.get(k).getCol() + " tipe "
//					+ tmp.get(k).getIcon().getType());
//		}
	
		for (int k = 0; k < tmp.size(); k++) 
		{
			cancella(tmp.get(k).getRow(),tmp.get(k).getCol());
		}
	}
		
	public void  checkAfterChangeO() {
		ArrayList<Cell> cell = new ArrayList<Cell>();
		for (int i = 0; i < rowS; i++) {
			for (int j = 0; j < colS; j++) {
				
					if (candies[j][i]!=null && j > 0 && candies[j-1][i]!=null && candies[j][i].getType() == candies[j - 1][i].getType() ) {
						cell.add(new Cell(j, i, candies[j][i]));

					} 
					else if (candies[j][i]!=null && j < colS - 1 && candies[j+1][i]!=null && candies[j][i].getType() == candies[j + 1][i].getType()) 
					{
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

			if (count >= 3) 
			{

				for (int k2 = 0; k2 < count; k2++) {
					tmp.add(new Cell(cell.get(k).getCol(), indTmp - k2, candies[cell.get(k).getCol()][indTmp - k2]));
			}

				k += count - 1;
			}
			count = 1;
			indTmp = 0;
		}
//		for (int k = 0; k < tmp.size(); k++) {
//			System.out.println("I'm hashmap O" + " " + tmp.get(k).getCol() + " " + tmp.get(k).getRow() + " tipe "
//					+ tmp.get(k).getIcon().getType());
		//}
		//System.out.println(tmp.size() + "sizeS");
	
 	for (int k = 0; k < tmp.size(); k++) 
 	{
 		cancella(tmp.get(k).getCol(),tmp.get(k).getRow());
	}

	}
}
