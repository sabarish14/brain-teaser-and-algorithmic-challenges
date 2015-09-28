package algorithms;
import java.util.*;

public class Priorityqueue {
	IntegerComparator comparator=new IntegerComparator();
	PriorityQueue<Integer> queue=new PriorityQueue<Integer>(10,comparator);

	void add(int a[])
	{
		for (int i:a)
		{
			this.queue.add(i);
		}
	}
	void display()
	{
		while(!queue.isEmpty())
		{
			System.out.println(queue.poll());
		}
	}
}


