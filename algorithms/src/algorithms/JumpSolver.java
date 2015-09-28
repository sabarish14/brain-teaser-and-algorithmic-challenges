package algorithms;

public class JumpSolver {
	int findMinJumps(int a[])
	{
		int minJumps[]=new int[a.length];
		int i,j;
		for(i=0;i<a.length;i++)
		{
			minJumps[i]=Integer.MAX_VALUE;
		}
		int hops;
		minJumps[0]=0;
		for (i=0;i<a.length;i++)
		{
			hops=a[i];
			for (j=i+1;j<=hops && j<a.length;j++)
			{
				if (minJumps[i]+1<minJumps[j])
					minJumps[j]=minJumps[i]+1;
			}
			
		}
		return minJumps[i-1];
	}

}

// What we can do for this problem is find the array indices that we can reach from an index and update the minJumps for all these indices.Then in the outer loop start from the next index that is unreachable from the present index and the inner loop from the next of present index