package algorithms;

/**
 * Linked List which will perform linked list related operations
 * @author sabarish
 *
 */
public class LinkedList 
{
	private Node head;
	private Node tail;
	public int size;
	/**
	 * Constructor
	 * @param num- Array of integers
	 */
	LinkedList(int num[])
	{
		Node temp=null;
		for (int i=0;i<num.length;i++)
		{
			Node newNode=new Node(num[i]);
			if (head==null)
			{
				head=newNode;
				temp=head;
			}
			else
			{
				temp.next=newNode;
				temp=newNode;	
			}
			
		}
		size=this.len();
	}
	LinkedList(Node head)
	{
		this.head=head;
	}
	
	
	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}


	/**
	 * Padding zeros to the linked list
	 * @param padLen
	 * @return
	 */
	void padding(int padLen)
	{
		for(int i=0;i<padLen;i++)
		{
		Node newNode= new Node(0);
		newNode.next=head;
		head=newNode;
		}
		
	}
	
	public Node add(Node head1, Node head2,int carry)
	{
		if(head1==null)
			return null;
		Node result= add(head1.next,head2.next,carry);
		int sum= head1.num+head2.num;
		if (sum>9)
		{
			carry=sum%10;
			sum=sum/10;
		}
		else
			carry=0;
		Node newNode=new Node(sum);
		if (result!=null)
		{
			newNode.next=result;
			result=newNode;
		}
				
		else
			result=newNode;
		return result;	
	}
	/**
	 * 
	 * @return
	 */
	private int len()
	{
		Node temp;
		int count=0;
		for (temp=head;temp.next!=null;temp=temp.next)
		{
			count++;
			
		}
		return count;
	}
	void display()
	{
		Node temp;
		System.out.println("List:");
		for (temp=head;temp!=null;temp=temp.next)
		{
			System.out.print(temp.num);
		}
		System.out.println();
		
	}
	void display(Node head)
	{
		Node temp;
		System.out.println("List:");
		for (temp=head;temp!=null;temp=temp.next)
		{
			System.out.print(temp.num);
		}
		System.out.println();
		
	}
	void partition(int x)
	{
		//Find tail
		tail=this.findTail();
		//find the node before Pivot
		Node beforePivot=this.findNodebyValue(x);
		//Assign the tail's next to Pivot
		tail.next=beforePivot.next;
		//Make pivot the tail
		tail=tail.next;
		//Connect the node before Pivot to the node after Pivot
		beforePivot.next=beforePivot.next.next;
		
		Node next,prev=null,temp;
		//loop till the temp reaches the pivot
		for (temp=head;temp.num!=x;)
		{
			
			next=temp.next;
			if(temp.num>x)
			{
				if (temp==head)
					head=head.next;
				else
					prev.next=temp.next;
				tail.next=temp;
				tail=temp;
				tail.next=null;
				
			}
			else
				prev=temp;
			temp=next;
			//this.display();
			
		}
		tail.next=null;	
	}
	private Node findTail()
	{
		Node temp;
		for (temp=head;temp.next!=null;temp=temp.next)
		{
			
		}
		return temp;
	}
	private Node findNodebyValue(int val)
	{
		Node temp;
		Node prev=head;
		for (temp=head;temp!=null;temp=temp.next)
		{
			if (temp.num==val)
				return prev;
			prev=temp;
			
		}
		return null;
	}

}
