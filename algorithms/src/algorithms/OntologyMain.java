package algorithms;


import java.io.*;
import java.util.*;
//Tree contains name and a list to store children
class Tree
{	
	String name;
	LinkedList<Tree> children;
	public Tree(String name)
	{
		this.name=name;
		this.children=new LinkedList<Tree>();
	}

}
//Ontology Tree class contains methods to build, display and get children from Ontology tree
class OntologyTree
{
	Tree root=null;
	Tree prev=null;		
	//Method to build the ontology tree
	public void buildOntologyTree(String topics)
	{	
		int start=0;
		ArrayList<Tree> stack=new ArrayList<Tree>();
		for (int i=0;i<topics.length();i++)
		{	//If the character is blank, it means a topic substring can be extracted.
			if(topics.charAt(i)==' ')
			{
				//Topic is extracted as substring from string topics.
				String topic=topics.substring(start,i);
				//If it is (, then it means prev is the last child of current prev.See the syntax of topics for details
				if (topic.equals("("))
				{
					//If there is no child , it is the root.
					if (prev.children.size()>0)
					{
						prev=prev.children.getLast();
						stack.add(prev);
					}
					start=i+1;
					continue;
				}
				//If it is ), then remove the last element and then assign prev to the last element in the stack and  continue.
				if (topic.equals(")"))
				{
					//System.out.println(stack.get(stack.size()-1).name+" removed from stack");
					stack.remove(stack.size()-1);
					if (stack.size()>0)
						prev=stack.get(stack.size()-1);
					start=i+1;
					continue;	
					
				}
				//If root is null , create a tree for root
				if (root==null)
				{
					root=new Tree(topic);
					prev=root;
					stack.add(prev);
				}
				//Else create a new node and add this to prev node's children
				else
				{
					Tree newChild=new Tree(topic);
					//System.out.println(topic);
					prev.children.add(newChild);
					
				}
				start=i+1;
			}
		}
	}
	public void display()
	{
		LinkedList<Tree> children=new LinkedList<Tree>();
		children.add(root);
		System.out.println("\t"+root.name);
		while (!children.isEmpty())
	    {
			Tree root=children.removeFirst();	
			for (Tree child:root.children)
			{
				System.out.print(child.name+" ");
				children.add(child);
			}
			System.out.println();
		
		}
		
	}
	// This method returns the children of the node with name in the argument
	public LinkedList<String>  getChildren(String name)
	{
		LinkedList<Tree> queue=new LinkedList<Tree>();
		queue.add(root);
		LinkedList<String> children=null;
		
		//Loop till the queue becomes empty
		 while (!queue.isEmpty())
        {
            Tree root=queue.removeFirst();
			if (root.name.equals(name))
             {
				queue.clear();
				queue.add(root);
				children=this.bfs(queue);
				break;
			 }
            for (Tree child:root.children)
             {			
                queue.add(child);
             }
                       
         }
		return children;
	}

	public LinkedList<String>  bfs(LinkedList<Tree> queue)
	{
		LinkedList<String> children=new LinkedList<String>();
		children.add(queue.get(0).name);
		while (!queue.isEmpty())
	       {
			Tree root=queue.removeFirst();	
			for (Tree child:root.children)
			{
				//System.out.print(child.name+"\t");
				queue.add(child);
				children.add(child.name);
			}
			//System.out.println();
		
		}
		return children;
	}
}

class OntologyMain
{	
	Tree root=null;
	public static void main(String arg[]) throws IOException
	{
		OntologyTree ot=new OntologyTree();
		HashMap<String,ArrayList<String>> topic_question_map=new HashMap<String,ArrayList<String>>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int topic_length = Integer.parseInt(br.readLine());
		String topics=br.readLine();
		int question_length=Integer.parseInt(br.readLine());
		String questions[]=new String[question_length];
		for (int i=0;i<question_length;i++)
		{
			questions[i]=br.readLine();
		}
		int test_question_length=Integer.parseInt(br.readLine());
		String test_questions[]=new String[test_question_length];

		for (int i=0;i<test_question_length;i++)
        {
             test_questions[i]=br.readLine();
        }
		
		ot.buildOntologyTree(topics);
		//ot.display();
		for (String ques:questions)
		{
			String[] temp=ques.split(": ");
			if (topic_question_map.containsKey(temp[0]))
			{
				ArrayList<String> list=topic_question_map.get(temp[0]);
				list.add(temp[1]);
				topic_question_map.put(temp[0],list);
			}
			else
			{	
				ArrayList<String> list=new ArrayList<String>();
				list.add(temp[1]);

				topic_question_map.put(temp[0],list);
			}
		}

		for (String ques:test_questions)
        {
			int count=0;
			String[] temp=ques.split(" ");
		//	System.out.println("Test question:"+ques);
			LinkedList<String> match=ot.getChildren(temp[0]);
			//match.add(temp[0]);
			for (String name:match)
			{
				if (topic_question_map.containsKey(name))
				{
					count+=findMatch( topic_question_map.get(name),ques ); 
						
				}
			}
			System.out.println(count);
                        
		}
	
		
	}
	private static int  findMatch(ArrayList<String> total_ques,String ques)
	{
		int count=0;
		for (String q:total_ques)
		{
			int i=0,j=1;
			//System.out.println(q);
			String[] q_parts=q.split(" ");
			String [] ques_parts=ques.split(" ");
			Boolean flag=false;
			for (j=1;j<ques_parts.length;j++)
			{
				//int index=q_parts[i].startsWith(ques_parts[j], 0);
				//int index=q_parts[i].indexOf(ques_parts[j],0);
				if (q_parts[i].startsWith(ques_parts[j], 0))
				{
					flag=true;
				}
				else
				{	
					flag=false;
					break;
				}
				i++;
				//System.out.println();
			}
			if (flag)
			{
				System.out.println(q);
				count++;
			}
		}
		return count;
	}
	
}
