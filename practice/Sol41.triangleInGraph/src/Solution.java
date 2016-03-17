import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.16
 Problem : http://www.geeksforgeeks.org/number-of-triangles-in-a-undirected-graph/
 https://www.careercup.com/question?id=5988741646647296
 ==========================================================
 */
public class Solution {
	/*
	 * Given an Undirected simple graph, We need to find how many triangles it
	 * can have. For example below graph have 2 triangles in it.
	 * 
	 * Given a undirected graph with corresponding edges. Find the number of
	 * possible triangles? Example: 0 1 2 1 0 2 4 1 Answer: 1
	 */
	public static void main(String[] args) {
		int[][] edges = {{0, 1}, {2, 1}, {0, 2}, {4, 1}, {4, 2}};
		triangleInGraph(5, 5, edges);
	}

	private static void triangleInGraph(int node, int edge, int[][] edges) {
		List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
		for (int i = 0; i < node; i++) {
			graph.add(new HashSet<Integer>());
		}

		for (int i = 0; i < edge; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			// Adds an edge to node
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		System.out.println(graph.toString());
		List<List<Integer>> triangle1 = new ArrayList<List<Integer>>();
		helperVertex(triangle1, new ArrayList<Integer>(), 0, 3, graph);
		System.out.println(triangle1.toString());

		List<List<Integer>> triangle2 = new ArrayList<List<Integer>>();
		helperEdge(triangle2, graph);
		System.out.println(triangle2.toString());
		return;
	}

	// Make the triangles using vertex so the time complexity is O(n^3)
	private static void helperVertex(List<List<Integer>> triangle,
			List<Integer> list, int index, int num, List<Set<Integer>> graph) {
		if (num == 0) {
			triangle.add(list);
			return;
		}

		for (int i = index; i < graph.size(); i++) {
			boolean needToAdd = false;
			if (num == 3) {
				needToAdd = true;
			} else if (num == 2) {
				int node = list.get(0);
				if (graph.get(i).contains(node) == true) {
					needToAdd = true;
				}
			} else if (num == 1) {
				int nodeA = list.get(0);
				int nodeB = list.get(1);
				if (graph.get(i).contains(nodeA)
						&& graph.get(i).contains(nodeB)) {
					needToAdd = true;
				}
			}

			if (needToAdd) {
				List<Integer> newList = new ArrayList<Integer>(list);
				newList.add(i);
				helperVertex(triangle, newList, i + 1, num - 1, graph);
			}
		}
	}

	// Make the triangles using vertex and connected edges so the time
	// complexity is O(n*d^2)
	private static void helperEdge(List<List<Integer>> triangle,
			List<Set<Integer>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			List<Integer> list1 = new ArrayList<Integer>();
			list1.add(i);
			for (int neighbor : graph.get(i)) {
				List<Integer> list2 = new ArrayList<Integer>(list1);
				list2.add(neighbor);
				graph.get(neighbor).remove(i);
				for (int innerNeighbor : graph.get(neighbor)) {
					if (graph.get(i).contains(innerNeighbor)) {
						List<Integer> list3 = new ArrayList<Integer>(list2);
						list3.add(innerNeighbor);
						graph.get(innerNeighbor).remove(neighbor);
						triangle.add(list3);
					}
				}
			}
		}
	}
}