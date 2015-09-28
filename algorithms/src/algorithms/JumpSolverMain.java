package algorithms;

public class JumpSolverMain {
	public static void main(String a[])
	{
		JumpSolver j=new JumpSolver();
		int num[]={1, 3, 6, 1, 0, 9};
		System.out.println(j.findMinJumps(num));
	}

}
