package core;	

public class GameWorld {
	private Candy[][] candies;
	private IGenerator g;
	private int score;
	
	
	public GameWorld(int row, int col) {
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
	public void setCandies(Cell[] c) 
	{
		if (c.length == 2) 
		{
			int row = c[0].getRow();
			int col = c[0].getCol();
			int row1 = c[1].getRow();
			int col1 = c[1].getCol();
			Candy tmp = getCandy(row, col);
			candies[row][col] = candies[row1][col1];
			candies[row1][col1] = tmp;
			
		}
	}
	public void moveCandies(int x,int y,int x1,int y1)
	{
		Candy tmp=candies[x][y];
		candies[x][y]=candies[x1][y1];
		candies[x1][y1]=tmp;
	}
}
