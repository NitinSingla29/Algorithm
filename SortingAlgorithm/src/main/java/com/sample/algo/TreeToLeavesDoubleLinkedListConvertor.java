//http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
public class TreeToLeavesDoubleLinkedListConvertor {

	public static TreeNode convertLeavesInToDOubleLinkedList(TreeNode root) {
		if(root == null) {
			return null;
		}
		if(root.left ==null && root.right == null ) {
			return root;
		}
		return join(convertLeavesInToDOubleLinkedList(root.left), convertLeavesInToDOubleLinkedList(root.right));
	}

	private static TreeNode join(TreeNode leftDll, TreeNode rightDll) {
		TreeNode temp = leftDll;
		if(leftDll!=null) {
			while(temp.right !=null) {
				temp = temp.right;
			}
			temp.right = rightDll;
			return leftDll;
		}
		return rightDll;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		TreeNode leavesDll = convertLeavesInToDOubleLinkedList(root);

		while(leavesDll!=null) {
			System.out.print(leavesDll.key + "<-->");
			leavesDll = leavesDll.right;
		}
		System.out.println("Null");

	}
}