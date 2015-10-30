package algorithms;

public class QuickSort {
	void sort(int a[],Boolean reverse)
	{
		int l=0;
		int r=a.length-1;
		this.divide(a, l, r,reverse);
		
	}
	void divide(int a[],int l,int r,Boolean reverse)
	{
		if(l+1>=r)
			 return;
		 int pivot=a[l];
		 int i=l+1,j=r;
		 if (!reverse)
		 {
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
		 }
		 else
		 {
			 while(i<j)
			 {
				 while ( (a[i]>pivot) && (i<j))
				 {
					 i++;
				 }
				 while((a[j]<=pivot)&&(j>l))
				 {
					 j--;
				 }
				 if (i<j)
					 this.swap(a, i, j);
				 
			 }
		 }
		 this.swap(a, l, j);
		 //this.display(a);
		 this.divide(a, l,j,reverse);
		 this.divide(a, j+1, r,reverse);
		 
		 
		 
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
