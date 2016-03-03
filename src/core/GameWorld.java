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

}
