package algorithms;

public class MergeSort {
	void sort(int a[])
	{
		int l=0;
		int r=a.length-1;
		this.divide(a, l, r);
		
	}
	void divide(int a[],int l,int r)
	{
		if(l<r)
		{
			int m=(l+r)/2;
			this.divide(a,l,m);
			this.divide(a, m+1, r);
			this.merge(a, l, m, r);
			
		}
	}
	void merge(int a[],int l,int m,int r)
	{
		int leftLen=m-l+1;
		int rightLen=r-m;
		int left[]=new int[leftLen];
		int right[]=new int[rightLen];
		int i=0,j=0,k;
		for(k=0;k<leftLen;k++)
		{
			left[k]=a[k+l];
		}
		
//		System.out.println("Left len:"+left.length);
//		for (i=0;i<left.length;i++)
//			System.out.print(left[i]);
//		System.out.println();
		
		for(k=0;k<rightLen;k++)
		{
			right[k]=a[k+m+1];
		}
		
		
//		System.out.println("Right len:"+right.length);
//		for (i=0;i<right.length;i++)
//			System.out.print(right[i]);
//		System.out.println();
		
		i=0;
		j=0;
		k=l;
		while ((i<leftLen) && (j<rightLen))
		{
			if(left[i]<right[j])
			{
				a[k]=left[i];
				i++;
				
			}
			else
			{
				a[k]=right[j];
				j++;
			}
			k++;
		}
		while(i<leftLen)
		{
			a[k]=left[i];
			i++;
			k++;
		}
		while(j<rightLen)
		{
			a[k]=right[j];
			j++;
			k++;
		}

		
		
	}

}
