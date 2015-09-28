package algorithms;

public class TrieOps {

	Trie root;
	TrieOps()
	{
		root=new Trie();
	}
	void insert(String word)
	{
		Trie temp=root;
		for (int i=0;i<word.length();i++)
		{
			int character=(int)(word.charAt(i))-97;
			if (temp.children[character]==null)
			{
				temp.children[character]=new Trie();
				
			}
			temp=temp.children[character];
			
		}
		temp.leaf=true;
	}
	Boolean search(String word)
	{
	
		Trie temp=root;
		for (int i=0;i<word.length();i++)
		{
			int character=(int)(word.charAt(i))-97;
			temp=temp.children[character];
			if (temp==null)
			{
				
					return false;
			}
			if (temp.leaf)
				return true;
			
			
		}
		return false;
	}
}
