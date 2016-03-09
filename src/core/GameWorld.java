package core;

public class GameWorld {
	private Candy[][] candies;
	private IGenerator g;
	private int score;
	private int rowS;
	private int colS;
	private int Xt;
	private int Yt;
	
	public GameWorld(int row, int col) {
		this.rowS = row;
		this.colS = col;
		this.candies = new Candy[row][col];
		this.g = new Generator();
		g.inizialize(candies);
		this.score = 0;
	}

	public int getXt() 
	{
		return Xt;
	}
	public int getYt() 
	{
		return Yt;
	}
	public void setXt(int xt) 
	{
		this.Xt = xt;
	}
	public void setYt(int yt) 
	{
		this.Yt = yt;
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

	public void setCandies(int x,int y,int x1,int y1)
	{
		Candy tmp= candies[y][x];
		candies[y][x]=candies[y1][x1];
		candies[y1][x1]=tmp;
		setXt(x1);
		setYt(y1);
			
	}
	public boolean checkMoreCandies()
	{
		int indice=1;
		int count=1;
		int tmp=candies[getYt()][getXt()].getType();
		while((getYt()<colS) &&(tmp==(candies[getYt()][getXt()+indice].getType()))) 
		{	
			count++;
			indice++;
			if(getXt()+indice >= colS)
				break;
		}
		if(count>=3)
		{
			System.out.println(count);
			return true;
		}
		
		count=1;
		indice=1;
		while((getXt()>=0) && (tmp==(candies[getYt()][getXt()-indice].getType()))) 
		{
			count++;
			indice++;
			if(getXt()-indice < 0)
				break;
			
		}
		if(count>=3)
		{
			System.out.println(count);
			return true;
		}
		
		count=1;
		indice=1;
		while((getYt()<rowS) && (tmp==(candies[getYt()+indice][getXt()].getType()))) 
		{
			count++;
			indice++;
			if(getYt()+indice>=rowS)
				break;
			
		}
		if(count >= 3)
			return true;
		count=1;
		indice=1;
		
		while((getYt()>=0)&& (tmp==(candies[getYt()-indice][getXt()].getType())))
		{
			count++;
			indice++;
			if(getYt()-indice<0)
				break;
			
		}
		if(count >= 3)
			return true;
		
		
		return false;
	}			
				

}
