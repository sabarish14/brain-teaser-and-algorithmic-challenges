package algorithms;

public class TrieOpsMain {

	public static void main(String arg[])
	{
		TrieOps t=new TrieOps();
		t.insert("cat");
		t.insert("cats");
		System.out.println(t.search("cats"));
		System.out.println(t.search("at"));
	}
}
