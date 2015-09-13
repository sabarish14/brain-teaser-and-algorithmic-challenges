package algorithms;

public class LinkedListOps {
	
	void add(LinkedList l1, LinkedList l2)
	{
		if (l1.size< l2.size)
		{
			int padLength=l2.size-l1.size;
			l1.padding(padLength);
		}
		if(l2.size<l1.size)
		{
			int padLength=l1.size-l2.size;
			l2.padding(padLength);
		}
		int carry=0;
		Node result=l1.add(l1.getHead(),l2.getHead(),carry);
		LinkedList resultList=new LinkedList(result);
		resultList.display();
		
		
	}

}
