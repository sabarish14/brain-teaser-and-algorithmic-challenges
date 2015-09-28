package algorithms;

public class MergeSortMain {
	public static void main(String arg[])
	{
		MergeSort m=new MergeSort();
		int a[]={6,5,4,3,2,1};
		m.sort(a);
		for (int i=0;i<a.length;i++)
			System.out.print(a[i]);
		System.out.println();
		
	}

}
