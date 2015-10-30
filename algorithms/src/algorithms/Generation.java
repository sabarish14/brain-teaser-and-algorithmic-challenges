import java.io.*;
import java.util.*;
class Generation
{
	public static void main(String a[])
	{
		String input="Muthusamy->Subramanian,Subramanian->Sabarish,Subramanian->Ramya,Ramya->Mridav";
		String[] generation=input.split(",");
		int gen_num=4;
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for (String g:generation)
		{
			String[] parent_children=g.split("->");
			String parent=parent_children[0];
			String child=parent_children[1];
			if (map.containsKey(parent))
			{
				map.put(child,map.get(parent)+1);
			}
			else
			{
				map.put(parent,1);
				map.put(child,map.get(parent)+1);
			}
		}
		
		Set<String> keys=map.keySet();
		for (String k:keys)
		{
			if (map.get(k)==gen_num)
				System.out.println(k);
		}
		
	}
}
