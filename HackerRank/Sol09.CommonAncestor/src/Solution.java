import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _count;
		_count = Integer.parseInt(in.nextLine());

		OutputCommonManager(_count, in);
	}

	static void OutputCommonManager(int count, Scanner in) {
		// Save all nodes in binary tree with <key, node> pairs
		HashMap<String, Node> binaryTreeMap = new HashMap<String, Node>();

		int num = 0;
		String employee1 = null, employee2 = null;

		// Run until user type ctrl + d
		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (num == 0) {
				employee1 = line;
			} else if (num == 1) {
				employee2 = line;
			} else {
				String[] name = line.split("\\s+");
				Node node = null;
				if (binaryTreeMap.containsKey(name[0]) == true) {
					node = (Node) binaryTreeMap.get(name[0]);
					node = insertChild(node, name[1]);
				} else {
					node = makeNode(name[0], name[1]);
				}

				// Insert parent node into nodeMap
				binaryTreeMap.put(name[0], node);

				// Insert child node into nodeMap
				if (node.left.data.equals(name[1])) {
					binaryTreeMap.put(name[1], node.left);
				} else {
					binaryTreeMap.put(name[1], node.right);
				}
			}
			num++;
		}

		// Find root node, its tree node count equals the number of all nodes
		for (Node node : binaryTreeMap.values()) {
			int current = getTreeSize(node);
			if (current == count) {
				root = node;
				break;
			}
		}

		// Find the lowest common ancestor in binary tree
		Node lowestCommonManager = lowestCommonAncestor(root,
				(Node) binaryTreeMap.get(employee1),
				(Node) binaryTreeMap.get(employee2));
		System.out.println(lowestCommonManager.data);
	}

	public static Node root = null;

	public static Node makeNode(String parent, String child) {
		Node node = new Node(parent);
		Node childNode = new Node(child);

		// Assign the child node to current's left node, when left child is null
		if (node.left == null) {
			node.left = childNode;
		} else {
			node.right = childNode;
		}
		return node;
	}

	public static Node insertChild(Node parentNode, String child) {
		Node childNode = new Node(child);
		if (parentNode.left == null) {
			parentNode.left = childNode;
		} else {
			parentNode.right = childNode;
		}
		return parentNode;
	}

	public static int getTreeSize(Node node) {
		Node right = node.right;
		Node left = node.left;
		int count = 1;
		if (right != null)
			count += getTreeSize(right);
		if (left != null)
			count += getTreeSize(left);
		return count;
	}

	// Print the binary tree via BFS
	public static void display(Node root) {
		if (root == null) {
			return;
		}
		System.out.print("display : ");

		Queue<Node> queue = new LinkedList<Node>();
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

		System.out.println();
	}

	// Find the lowest common ancestor in binary tree
	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	public static class Node {
		String data;
		Node left;
		Node right;

		public Node(String data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
}
