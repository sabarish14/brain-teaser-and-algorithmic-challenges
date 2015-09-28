package algorithms;

public class WordBreakMain {
	public static void main(String arg[])
	{
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
		WordBreak w=new WordBreak(dictionary);
		String sentence="ilikesamsung";
		int n=sentence.length();
		w.findPossibleWordBreaks(sentence );
		/*for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if (wordBreaks[i][j]==1)
				{
					System.out.println(sentence.substring(i,j+1)+" ");
				}
					
			}
		}*/
	}

}
