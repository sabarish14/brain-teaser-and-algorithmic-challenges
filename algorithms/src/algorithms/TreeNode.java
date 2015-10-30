package algorithms;

public class TreeNode {
	int val;
	TreeNode left,right,sibling;
	TreeNode(int val)
	{
		this.val=val;
		this.left=null;
		this.right=null;
	}
	TreeNode()
	{
		this.left=null;
		this.right=null;
		this.sibling=null;
	}

}
