package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Solution {
    public boolean wordPattern(String pattern, String str){
        LinkedHashSet<Character> pattern_set=new LinkedHashSet<Character>();
        HashMap<String,Character> map=new  HashMap<String,Character>();
        for(int i=0;i<pattern.length();i++)
        {
            pattern_set.add(pattern.charAt(i));
        }
        //System.out.println( pattern_set.toString() );
       String input[]=str.split(" ");
      // System.out.println( input[3].toString() );
       Iterator<Character> it=pattern_set.iterator();
       String output="";
       for (String in:input)
       {
           if (map.containsKey(in))
           {
               output+=String.valueOf(map.get(in));
           }
           else
           {
        	   //System.out.println(output);
               if (!it.hasNext())
                    return false;
                map.put(in,it.next());
                output+=String.valueOf(it.next());
                
           }
           
           
       }
       
       if (output.equals(pattern))
            return true;
       
        return false;
        
    }
    public static void main(String a[])
    {
    	String input="dog cat cat dog";
    	String pattern="abba";
    	Solution s=new Solution();
    	s.wordPattern(pattern,input);
    }
}