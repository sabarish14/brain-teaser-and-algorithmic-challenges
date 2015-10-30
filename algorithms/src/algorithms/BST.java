package algorithms;
import java.util.LinkedList;;
public class BST {
	TreeNode root;
	BST(int a[])
	{
		root=this.constructTree(a, 0, a.length-1);
	}
	/**
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private TreeNode constructTree(int a[],int start,int end)
	{
		TreeNode root;
		if (start>end || start==end)
		{
			
			root=new TreeNode(a[start]);
			return root;
		}
		int mid=(start+end)/2;
		root=new TreeNode(a[mid]);
		root.left=this.constructTree(a, start, mid-1);
		root.right=this.constructTree(a, mid+1, end);
		return root;	
	}
	/**
	 * 
	 */
	public void findSibling()
	{
		LinkedList<LinkedList<TreeNode>> list=new LinkedList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> parent=null,children=null;
		int level=1,levelSize=0;
		children=new LinkedList<TreeNode>();
		if (root!=null)
		{
			children.add(root);
			list.add(children);
			levelSize=1;
		}
		
		while (levelSize>0)
		{
			children=new LinkedList<TreeNode>();
			if (level>0)
			{
				parent=list.get(level-1);
			}
			int childrenCount=0;
			for (TreeNode p:parent)
			{
				if (children.size()>0)
					children.get(childrenCount-1).sibling=p.left;
				if (p.left!=null)
				{
					children.add(p.left);
					childrenCount++;
				}
				if (children.size()>0)
					children.get(childrenCount-1).sibling=p.right;
				if (p.right!=null)
				{
					children.add(p.right);
					childrenCount++;
				}
			}
			list.add(children);
			levelSize=list.get(level).size();
			level++;
			
		}
		
		
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int findCommonAncestor(int x,int y)
	{
		while (root!=null)
		{
			if (root.val>x && root.val>y)
				root=root.left;
			else if (root.val<x && root.val<y)
				root=root.right;
			else
				break;
		}
		if (root.val==x)
		{
			if (this.search(y, root))
				return root.val;
		}
		else 
		{
			if (this.search(x, root))
				return root.val;
		}
		return Integer.MIN_VALUE;	
	}
	
	TreeNode findCommonAncestorBinTree(TreeNode root,int x,int y,Boolean x_flag, Boolean y_flag)
	{
		
		if (root==null)
			return null;
		if (root.val==x || root.val==y)
		{
			return root;
		}
		TreeNode left=this.findCommonAncestorBinTree(root.left,x, y,x_flag,y_flag);
		TreeNode right=this.findCommonAncestorBinTree(root.right,x,y,x_flag,y_flag );
		if (left!=null && right!=null)
			return root;
		if (x_flag ||y_flag)
			return (left!=null)?left:right;
		if (left!=null)
		{
			if (left.val==x)
			{
				x_flag=true;
				y_flag=this.findBinTreeNode(y, left);
			}
			else
			{
				y_flag=true;
				x_flag=this.findBinTreeNode(x, left);
			}
			
			if (x_flag ||y_flag)
				return left;
			
		}
		if (right!=null)
		{
			if (right.val==x)
			{
				x_flag=true;
				y_flag=this.findBinTreeNode(y, right);
			}
			else
			{
				y_flag=true;
				x_flag=this.findBinTreeNode(x, right);
			}
			if (x_flag ||y_flag)
				return right;
			
		}
		return null;
		
		
	}
	
	
	private Boolean findBinTreeNode(int val, TreeNode root)
	{
		if (root==null)
			return false;
		if (root.val==val)
			return true;
		findBinTreeNode(val,root.left);
		findBinTreeNode(val,root.right);
		return false;
	}
	/**
	 * 
	 * @param val
	 * @param root
	 * @return
	 */
	private Boolean search(int val,TreeNode root)
	{
		while (root!=null)
		{
			if (root.val<val)
				root=root.right;
			else if (root.val>val)
				root=root.left;
			else if (root.val==val)
				return true;
		}
		return false;
	}
	/**
	 * 
	 */
	public void displaySibling()
	{
		this.inOrderSibling(root);
	}
	/**
	 * 
	 */
	public void display()
	{
		this.inOrder(root);
	}
	/**
	 * 
	 * @param root
	 */
	private void inOrderSibling(TreeNode root)
	{
		if (root==null)
			return;
		this.inOrderSibling(root.left);
		if (root.sibling!=null)
			System.out.println("Sibling of "+root.val+":"+root.sibling.val);
		this.inOrderSibling(root.right);
	}
	/**
	 * 
	 * @param root
	 */
	private void inOrder(TreeNode root)
	{
		if (root==null)
			return;
		this.inOrder(root.left);
		System.out.println(root.val);
		this.inOrder(root.right);
	}
}
