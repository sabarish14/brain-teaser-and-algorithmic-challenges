package algorithms;

public class Palindrome 
{
	public Boolean isPalindrome (String str) 
	{
	    // base case #1
		int n=str.length();
	    if (n<=1)
	    {
	        return true;
	    }
	    // base case #2
	    
	    // recursive case
	    
	     
	    else if(str.charAt(0)==str.charAt(n-1))
	    {
	        str=str.substring(1,n-1);
	        return isPalindrome(str);
	    }
	    return false;
	        
	}
}
