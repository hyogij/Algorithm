import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.12
 Problem : http://www.geeksforgeeks.org/bridge-in-a-graph/
 ==========================================================
 */
public class Solution {
	/*
	 * An edge in an undirected connected graph is a bridge iff removing it
	 * disconnects the graph. For a disconnected undirected graph, definition is
	 * similar, a bridge is an edge removing which increases number of connected
	 * components. Like Articulation Points,bridges represent vulnerabilities in
	 * a connected network and are useful for designing reliable networks. For
	 * example, in a wired computer network, an articulation point indicates the
	 * critical computers and a bridge indicates the critical wires or
	 * connections.
	 * 
	 * Following are some example graphs with bridges highlighted with red
	 * color.
	 */
	public static void main(String[] args) {
		int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}, {0, 3}, {3, 4}};
		System.out.println(bridge(5, edges1));

		int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {4, 3}};
		System.out.println(bridge(5, edges2));
	}

	public static class Graph {
		int data;
		List<Graph> neighbor;
		public Graph(int data) {
			this.data = data;
			neighbor = new ArrayList<Graph>();
		}
	}

	public static int bridge(int n, int[][] edges) {
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

		int count = 0;
		// Run until there is no candidates
		for (int i = 0; i < n; i++) {
			if (graph[i].neighbor.size() == 1) {
				// This is bridge in graph
				count++;
				Graph neighbor = graph[i].neighbor.get(0);

				// Remove Edges
				graph[i].neighbor.remove(neighbor);
				graph[neighbor.data].neighbor.remove(graph[i]);

				// Restart from 0 node
				i = 0;
			}
		}
		return count;
	}
}