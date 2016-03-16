import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.10
 Problem : http://buttercola.blogspot.kr/2015/08/leetcode-graph-valid-tree.html
 https://leetcode.com/discuss/54211/ac-java-solutions-union-find-bfs-dfs
 ==========================================================
 */
public class Solution {
	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
	 * (each edge is a pair of nodes), write a function to check whether these
	 * edges make up a valid tree.
	 * 
	 * For example: Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]],
	 * return true. Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1,
	 * 4]], return false.
	 * 
	 * Hint: Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your
	 * return? Is this case a valid tree? According to the definition of tree on
	 * Wikipedia: "a tree is an undirected graph in which any two vertices are
	 * connected by exactly one path. In other words, any connected graph
	 * without simple cycles is a tree."
	 * 
	 * Note: you can assume that no duplicate edges will appear in edges. Since
	 * all edges are undirected, [0, 1] is the same as [1, 0] and thus will not
	 * appear together in edges.
	 */
	public static void main(String[] args) {
		int n = 5;
		int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println("validTree : " + validTree(n, edges1));
		System.out.println("validTree : " + validTree(n, edges2));

		System.out.println("validDFS : " + validDFS(n, edges1));
		System.out.println("validDFS : " + validDFS(n, edges2));

		System.out.println("validBFS : " + validBFS(n, edges1));
		System.out.println("validBFS : " + validBFS(n, edges2));
	}

	public static boolean validTree(int n, int[][] edges) {
		return unionFind(n, edges);
	}

	// Implement union find algorithm
	private static HashMap<Integer, Node> map = null;
	static class Node {
		int val;
		int parent;
		public Node(int val) {
			this.val = val;
			this.parent = val;
		}
	}

	private static boolean unionFind(int n, int[][] edges) {
		map = new HashMap<Integer, Node>();
		for (int i = 0; i < n; i++) {
			map.put(i, new Node(i));
		}

		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];

			if (find(a) == find(b)) {
				return false;
			}

			union(a, b);
		}

		return n == edges.length + 1;
	}

	private static int find(int node) {
		if (map.get(node).parent == node)
			return node;
		return find(map.get(node).parent);
	}

	private static void union(int a, int b) {
		map.get(a).parent = map.get(b).parent;
	}

	// Implement DFS on graph
	private static boolean validDFS(int n, int[][] edges) {
		// Make a graph
		List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
		// Make nodes in graph
		for (int i = 0; i < n; i++) {
			graph.add(new HashSet<Integer>());
		}
		// Adds edges to nodes
		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[n];
		// Add a node '0'
		stack.push(0);
		while (stack.isEmpty() != true) {
			int node = stack.pop();

			// If the node is already visited, then there is cycle in graph
			if (visited[node] == true)
				return false;

			visited[node] = true;
			for (int neighbor : graph.get(node)) {
				stack.push(neighbor);
				// Remove edge : Important!!
				graph.get(neighbor).remove(node);
			}
		}

		// Check the graph is fully connected.
		for (int i = 0; i < n; i++) {
			if (visited[i] == false)
				return false;
		}
		return true;
	}

	// BFS, using queue
	private static boolean validBFS(int n, int[][] edges) {
		// Build the graph using adjacent list
		List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
		for (int i = 0; i < n; i++)
			graph.add(new HashSet<Integer>());
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		// No cycle
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int node = queue.remove();
			if (visited[node]) {
				return false;
			}

			visited[node] = true;
			for (int neighbor : graph.get(node)) {
				queue.add(neighbor);
				graph.get(neighbor).remove(node);
			}
		}

		// fully connected
		for (boolean result : visited) {
			if (!result)
				return false;
		}

		return true;
	}
}
