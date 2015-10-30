package algorithms;

public class Pairs {
	public int countPairs(int x[],int y[])
	{
		int count=0;
		QuickSort q=new QuickSort();
		q.sort(y,true);
		for (Integer num:x)
		{
			count+=this.findIndex(num, y)+1;
		}
		return count;
	}
	private int findIndex(int num,int y[])
	{
		int index=0;
		int flag=0;
		while (true)
		{
			if (index>=y.length)
			{
				index=y.length-1;
			}
				
			if (y[index]==num)
				return index;
			else if (y[index]>num)
			{
				if (flag==1 || index==(y.length-1))
					return index;
				if (index==0)
					index+=2;
				else
					index*=2;
			}
			else
			{
				flag=1;
				index--;
			}
				
		}
	}

}
