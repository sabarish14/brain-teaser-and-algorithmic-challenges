package algorithms;

public class BSTMain {
	public static void main(String arg[])
	{
	int a[]={1,3,5,7,9,11,17,18};
	BST t=new BST(a);
	Boolean flag=false;
	//t.display();
	//System.out.println(t.findCommonAncestorBinTree(t.root,9, 18,flag,flag).val);
	t.findSibling();
	t.displaySibling();
	
	}
}
