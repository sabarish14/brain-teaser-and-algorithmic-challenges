package algorithms;

public class Permutation {
	public void findPermutation(String s)
	{
		int possibleIndices[]=new int[s.length()];
		for (int count=0;count<s.length();count++)
			possibleIndices[count]=0;
		for (int i=0;i<s.length();i++)
		{
			String prefix="";
			this.permute(s, 0,i,prefix,possibleIndices);
		}
	}
	
	private void permute(String s,int outputIndex,int inputIndex,String prefix,int[] possibleIndices)
	{
			
		
			 prefix+=s.substring(inputIndex,inputIndex+1);
			 //System.out.println(prefix);
			 possibleIndices[inputIndex]=1;
			 if (outputIndex==s.length()-1)
			 {
				 s=s.substring(0,outputIndex);
				 System.out.println(prefix);
				 
			 }
			 else
			 {
				 for (int next=0;next<s.length();next++)
				 {
					 if (possibleIndices[next]!=1)
						 this.permute(s, outputIndex+1, next, prefix,possibleIndices);
				 }
				
			 }
			 possibleIndices[inputIndex]=0;
	}
	

}
