import java.util.Random;


//Print a random element from the tree
//In O(log(n)) time
public class RandomTreeElement {

	public static void main(String args[]) {
		TreeNode n = new TreeNode(5, 3);
		n.left = new TreeNode(10, 1);
		n.right = new TreeNode(20, 1);

		Random r = new java.util.Random();
		int num = 0;
		while (num == 0)
			num = r.nextInt(4);

		System.out.println(num);
		printRandom(n, 3);
	}

	public static void printRandom(TreeNode n, int randomNum) {
		int leftSize = n.left == null ? 0 : n.left.size;
		if (randomNum == leftSize + 1)
			System.out.println(n.data);
		else if (randomNum > leftSize + 1)
			printRandom(n.right, randomNum - (leftSize + 1));
		else
			printRandom(n.left, randomNum);
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	int size;

	public TreeNode(int data, int size) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.size = size;
	}
}