package algorithms;

public class MazeSolver {
	
	Boolean solve(int maze[][],int x,int y)
	{
		
		
		if ( (x<0) || (x>3) ||(y<0) || (y>3) )
		{
			return false;
		}
		if (maze[x][y]==5)
			return true;
		if (maze[x][y]==1)
		{
			
			return false;
		 
		}
			
		maze[x][y]=1;
		
		if (solve(maze,x+1,y))
			return true;
		
		if (solve(maze,x-1,y))
			return true;
		
		if (solve(maze,x,y+1))
			return true;
		
		if(solve(maze,x,y-1))
			return true;
		
		
		
		
		return false;
	}

}
