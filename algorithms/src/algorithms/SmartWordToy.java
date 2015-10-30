package algorithms;

public class SmartWordToy 
{
	public int minPresses(String start, String end, String[] forbid)
	{
		int count=0;
		String temp=start;
		while (!temp.equals(end))
		{
			
		}
		if (temp.equals(end))
			return count;
		return -1;
	}
	/*String[] findPossibleStates(String s)
	{
		String[] states=new String[8];
		for (int i=0;i<s.length();i++)
		{
			String temp=s;
			char c=(char) (temp.charAt(i)+1);
			temp=temp.substring(0,i)+c+temp.substring(i+1,temp.length()+1);
			
			
		}
	}*/

}
