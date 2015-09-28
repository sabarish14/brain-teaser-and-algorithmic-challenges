package algorithms;

public class MazeSolverMain 
{
	public static void main(String a[])
	{
		int maze[][]={ 
				{0, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 5}
		    };
		MazeSolver m=new MazeSolver();
		System.out.println(m.solve(maze, 0, 0));
				
	}

}
