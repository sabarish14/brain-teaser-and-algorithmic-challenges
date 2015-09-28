package algorithms;

public class Trie {
	Boolean leaf;
	Trie[] children;
	
	Trie()
	{
		leaf=false;
		children=new Trie[26];
		for (Trie t:children)
		{
			t=null;
		}
	}
	

}
