import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.12
 Problem : https://leetcode.com/discuss/questions/oj/number-of-connected-components-in-an-undirected-graph
 ==========================================================
 */
public class Solution {
	/*
	 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
	 * (each edge is a pair of nodes), write a function to find the number of
	 * connected components in an undirected graph.
	 * 
	 * Example 1: 0 3 | | 1 --- 2 4 Given n = 5 and edges = [[0, 1], [1, 2], [3,
	 * 4]], return 2. Example 2: 0 4 | | 1 --- 2 --- 3 Given n = 5 and edges =
	 * [[0, 1], [1, 2], [2, 3], [3, 4]], return 1. Note: You can assume that no
	 * duplicate edges will appear in edges. Since all edges are undirected, [0,
	 * 1] is the same as [1, 0] and thus will not appear together in edges.
	 */
	public static void main(String[] args) {
		int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(countComponents(5, edges1));
		System.out.println(countComponentsIterative(5, edges1));

		int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		System.out.println(countComponents(5, edges2));
		System.out.println(countComponentsIterative(5, edges2));
	}

	public static class Graph {
		int data;
		List<Graph> neighbor;
		public Graph(int data) {
			this.data = data;
			neighbor = new ArrayList<Graph>();
		}
	}

	public static int countComponents(int n, int[][] edges) {
		if (n == 0 || edges.length == 0 || edges[0].length == 0)
			return 0;

		Graph[] graph = new Graph[n];
		// Make a grpah
		for (int i = 0; i < n; i++) {
			graph[i] = new Graph(i);
		}

		// Add edges to the graph
		for (int i = 0; i < edges.length; i++) {
			// a <-> b
			int a = edges[i][0];
			int b = edges[i][1];

			graph[a].neighbor.add(graph[b]);
			graph[b].neighbor.add(graph[a]);
		}

		// Visit node using dfs recursive algorithm
		boolean[] visited = new boolean[n];
		int[] count = {0};
		for (int i = 0; i < n; i++) {
			if (visited[graph[i].data] == false) {
				count[0]++;
				dfs(graph[i], visited, count);
			}
		}

		return count[0];
	}

	public static void dfs(Graph graph, boolean[] visited, int[] count) {
		visited[graph.data] = true;
		for (Graph neighbor : graph.neighbor) {
			if (visited[neighbor.data] == false) {
				dfs(neighbor, visited, count);
			}
		}
	}

	public static int countComponentsIterative(int n, int[][] edges) {
		if (n == 0 || edges.length == 0 || edges[0].length == 0)
			return 0;

		Graph[] graph = new Graph[n];
		// Make a grpah
		for (int i = 0; i < n; i++) {
			graph[i] = new Graph(i);
		}

		// Add edges to the graph
		for (int i = 0; i < edges.length; i++) {
			// a <-> b
			int a = edges[i][0];
			int b = edges[i][1];

			graph[a].neighbor.add(graph[b]);
			graph[b].neighbor.add(graph[a]);
		}

		// Visit node using dfs iterative algorithm
		boolean[] visited = new boolean[n];
		int[] count = {0};

		for (int i = 0; i < n; i++) {
			if (visited[graph[i].data] == false) {
				count[0]++;
				dfsStack(graph[i], visited);
			}
		}

		return count[0];
	}

	public static void dfsStack(Graph graph, boolean[] visited) {
		Stack<Graph> stack = new Stack<Graph>();
		stack.push(graph);
		while (!stack.isEmpty()) {
			Graph current = stack.pop();
			visited[current.data] = true;
			for (Graph neighbor : current.neighbor) {
				if (!visited[neighbor.data]) {
					stack.push(neighbor);
				}
			}
		}
	}
}
