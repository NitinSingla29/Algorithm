// Java program to print top view of Binary tree
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;


// A class to represent a queue item. The queue is used to do Level
// order traversal. Every Queue item contains node and horizontal
// distance of node from root
class QItem
{
	TreeNode node;
	int hd;
	public QItem(TreeNode n, int h)
	{
		node = n;
		hd = h;
	}
}

// Class for a Binary Tree
class Tree
{
	public static void main(String[] args)
	{
		/* Create following Binary Tree
			1
		/ \
		2 3
		\
			4
			\
			5
			\
				6*/
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);
		Tree t = new Tree(root);

		t.printTopView();
		t.printLeftView();

		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		Tree tree = new Tree(root);
		System.out.println("Bottom view of the given binary tree:");
		tree.printBottomView();
	}

	TreeNode root;
	// Constructors
	public Tree() { root = null; }

	public Tree(TreeNode n) { root = n; }




	// This method prints nodes in top view of binary tree
	public void printBottomView()
	{
		TreeMap<Integer, TreeNode> postitionBasedDataMap = new TreeMap<>();
		LinkedList<QItem> nodeList = new LinkedList<QItem>();
		nodeList.add(new QItem(root, 0));
		while(!nodeList.isEmpty()) {
			QItem itemToVisit = nodeList.remove();
			if(itemToVisit.node!=null) {
				postitionBasedDataMap.put(itemToVisit.hd, itemToVisit.node);
				if(itemToVisit.node.left!=null) {
					nodeList.addLast(new QItem(itemToVisit.node.left, itemToVisit.hd-1));
				}
				if(itemToVisit.node.left!=null) {
					nodeList.addLast(new QItem(itemToVisit.node.right, itemToVisit.hd+1));
				}
			}
		}
		Collection<TreeNode> bottomViewNodes = postitionBasedDataMap.values();
		for (TreeNode treeNode : bottomViewNodes) {
			System.out.println(treeNode.key);
		}
	}


	// This method prints nodes in left view of binary tree
	public void printLeftView()
	{
		System.out.println("Following are nodes in left view of Binary Tree");
		//here hd represent vertical distance from root
		TreeMap<Integer, Integer> postitionBasedDataMap = new TreeMap<>();
		LinkedList<QItem> nodeList = new LinkedList<QItem>();
		nodeList.add(new QItem(root, 0));
		while(!nodeList.isEmpty()) {
			QItem itemToVisit = nodeList.remove();
			if(itemToVisit.node!=null) {
				if(!postitionBasedDataMap.containsKey(itemToVisit.hd)) {
					System.out.println(itemToVisit.node.key);
					postitionBasedDataMap.put(itemToVisit.hd, 1);
				}
				nodeList.addLast(new QItem(itemToVisit.node.left, itemToVisit.hd+1));
				nodeList.addLast(new QItem(itemToVisit.node.right, itemToVisit.hd+1));
			}
		}
	}

	// This method prints nodes in top view of binary tree
	public void printTopView()
	{
		System.out.println("Following are nodes in top view of Binary Tree");
		TreeMap<Integer, Integer> postitionBasedDataMap = new TreeMap<>();
		LinkedList<QItem> nodeList = new LinkedList<QItem>();
		nodeList.add(new QItem(root, 0));
		while(!nodeList.isEmpty()) {
			QItem itemToVisit = nodeList.remove();
			if(itemToVisit.node!=null) {
				if(!postitionBasedDataMap.containsKey(itemToVisit.hd)) {
					System.out.println(itemToVisit.node.key);
					postitionBasedDataMap.put(itemToVisit.hd, 1);
				}
				nodeList.addLast(new QItem(itemToVisit.node.left, itemToVisit.hd-1));
				nodeList.addLast(new QItem(itemToVisit.node.right, itemToVisit.hd+1));
			}
		}
	}



}

// Class for a tree node
class TreeNode
{
	// Members
	int key;
	TreeNode left, right;

	// Constructor
	public TreeNode(int key)
	{
		this.key = key;
		left = right = null;
	}

	@Override
	public String toString() {
		return "" + key;
	}


}
