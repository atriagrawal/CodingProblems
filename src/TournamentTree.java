
public class TournamentTree {
	/**
	 * A tournament tree is a binary tree where the parent is the minimum of the
	 * two children. Given a tournament tree find the second minimum value in
	 * the tree. A node in the tree will always have 2 or 0 children. Also all
	 * leaves will have distinct and unique values. 2 / \ 2 3 / \ | \ 4 2 5 3
	 *
	 * In this given tree the answer is 3.
	 */

	class Node {
		Integer value;
		Node left, right;

		Node(Integer value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * This should return the second minimum int value in the given tournament
	 * tree
	 */
	public static Integer secondMin(Node root) {
		if (root.left != null && root.value == root.left.value) {
			return getSecondMin(root.left, root.right);
		} else if (root.right != null && root.value == root.right.value) {
			return getSecondMin(root.right, root.left);
		}
		return -1;
	}

	public static Integer getSecondMin(Node root, Node secondMin) {
		if (root.left == null && root.right == null) {
			return secondMin.value;
		}
		if (root.left != null && root.value == root.left.value) {
			if (secondMin.value < root.right.value)
				return getSecondMin(root.left, secondMin);
			else 
				return getSecondMin(root.left, root.right);
		} else if (root.right != null && root.value == root.right.value) {
			if (secondMin.value < root.left.value) 
				return getSecondMin(root.right, secondMin);
			else
				return getSecondMin(root.right, root.left);
		}
		return -1;
	}
}
