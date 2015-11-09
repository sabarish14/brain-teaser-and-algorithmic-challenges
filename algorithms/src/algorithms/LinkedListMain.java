package algorithms;

public class LinkedListMain {
	public static void main(String a[])
	{
		
		int val[]={1,2,3};
		int val2[]={3,2};
		LinkedListOps l_ops=new LinkedListOps();
		LinkedList1 l1=new LinkedList1(val);
		LinkedList1 l2=new LinkedList1(val2);
		l1.display();
		
		l2.display();
		l_ops.add(l1, l2);
		
//		list.display();
//		list.partition(5);
//		list.display();
	}

}
