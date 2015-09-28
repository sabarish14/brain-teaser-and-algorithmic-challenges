package algorithms;

public class WordBreak 
{
	TrieOps t;
	String[] dict;
	String sentence;
	
	
	WordBreak(String[] dict)
	{
		this.dict=dict;
		
		t=new TrieOps();
	}
	
	public void findPossibleWordBreaks(String sentence)
	{
		this.sentence=sentence;
		int n=sentence.length();
		int wordBreaks[][]=new int[n][n];
		for (int k=0;k<wordBreaks.length;k++)
		{	
			for(int l=0;l<wordBreaks[k].length;l++)
			{
				//Indicates nodes are not visited (Intitialization)
				wordBreaks[k][l]=2;
			}
			
		}
		int beginIndex=0;
		String prefix="";
		this.breakSentence(wordBreaks,beginIndex);
		this.display(wordBreaks, beginIndex, prefix);
		
	}
	void display(int[][] wordBreaks, int beginIndex, String prefix)
	{
		
		for (int i=beginIndex;i<wordBreaks.length;i++)
		{
				if (wordBreaks[beginIndex][i]==1)
				{
					
					if (i==this.sentence.length()-1)
					{
						System.out.println(prefix+this.sentence.substring(beginIndex,i+1));
						break;
					}
					wordBreaks[beginIndex][i]=0;
					this.display(wordBreaks, i+1, prefix+this.sentence.substring(beginIndex,i+1)+" ");
				}	
		}
		
	}
	
	private void breakSentence(int[][] wordBreaks, int beginIndex)
	{
		for (int i=beginIndex;i<sentence.length();i++)
		{
			if (this.isValid(sentence.substring(beginIndex, i+1), dict)==false)
				wordBreaks[beginIndex][i]=0;
			else if (wordBreaks[beginIndex][i]!=0 &&this.isValid(sentence.substring(beginIndex, i+1), dict))
			{
				wordBreaks[beginIndex][i]=1;
				this.breakSentence(wordBreaks, i+1);
			}
		}
	}
	private Boolean isValid(String word,String[] dict)
	{
		for (String str:dict)
		{
			if (str.equals(word))
				return true;
		}
		return false;
	}
	

}
