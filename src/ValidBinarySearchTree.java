
public class ValidBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(90);
		root.left.right = new Node(35);
		boolean isValid = isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(isValid);
	}
	
	public static boolean isValid(Node n, int min, int max) {
		if (n == null) 
			return true;
		if (n.val <= max && n.val >= min) {
			if (isValid(n.left, min, n.val) && isValid(n.right, n.val, max))
				return true;
		}
		return false;
	}

}

class Node {
	Node left;
	Node right;
	Integer val;
	
	Node(int val) {
		left = null;
		right = null;
		this.val = val;
	}
}