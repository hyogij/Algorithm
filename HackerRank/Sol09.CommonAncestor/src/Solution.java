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
		HashMap<String, Node> nodeMap = new HashMap<String, Node>();

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
				if (nodeMap.containsKey(name[0]) == true) {
					node = (Node) nodeMap.get(name[0]);
					node = insertChild(node, name[1]);
				} else {
					node = makeNewNode(name[0], name[1]);
				}

				// Insert parent node into nodeMap
				nodeMap.put(name[0], node);
				// Insert child node into nodeMap
				if (node.left.data.equals(name[1])) {
					nodeMap.put(name[1], node.left);
				} else {
					nodeMap.put(name[1], node.right);
				}
			}
			num++;
		}

		// Find root node, its tree node count equals the number of all nodes
		for (Node node : nodeMap.values()) {
			int current = getCount(node);
			if (current == count) {
				root = node;
				break;
			}
		}

		Node lowestCommonManager = lowestCommonAncestor(root,
				(Node) nodeMap.get(employee1), (Node) nodeMap.get(employee2));
		System.out.println(lowestCommonManager.data);
	}

	public static Node root = null;

	public static Node makeNewNode(String parent, String child) {
		Node node = new Node(parent);
		Node childNode = new Node(child);
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

	public static int getCount(Node node) {
		Node right = node.right;
		Node left = node.left;
		int count = 1;
		if (right != null)
			count += getCount(right);
		if (left != null)
			count += getCount(left);
		return count;
	}

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
