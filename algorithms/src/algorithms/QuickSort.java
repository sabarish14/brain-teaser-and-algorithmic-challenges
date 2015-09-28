package algorithms;

public class QuickSort {
	void sort(int a[])
	{
		int l=0;
		int r=a.length-1;
		this.divide(a, l, r);
		
	}
	void divide(int a[],int l,int r)
	{
		if(l+1>=r)
			 return;
		 int pivot=a[l];
		 int i=l+1,j=r;
		 
		 while(i<j)
		 {
			 while ( (a[i]<pivot) && (i<j))
			 {
				 i++;
			 }
			 while((a[j]>=pivot)&&(j>l))
			 {
				 j--;
			 }
			 if (i<j)
				 this.swap(a, i, j);
			 
		 }
		 this.swap(a, l, j);
		 this.display(a);
		 this.divide(a, l,j);
		 this.divide(a, j+1, r);
		 
		 
		 
	}
	void swap(int a[],int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}
	void display(int a[])
	{
		for (int i=0;i<a.length;i++)
			System.out.print(a[i]);
		System.out.println();
	}

}
