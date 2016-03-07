package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.14
 Question Number : 116
 Link : https://leetcode.com/problems/clone-graph/
 ==========================================================
 */

public class CloneGraph {
	/*
	 * Clone an undirected graph. Each node in the graph contains a label and a
	 * list of its neighbors.
	 * 
	 * OJ's undirected graph serialization: Nodes are labeled uniquely.
	 * 
	 * We use # as a separator for each node, and , as a separator for node
	 * label and each neighbor of the node. As an example, consider the
	 * serialized graph {0,1,2#1,2#2,2}.
	 * 
	 * The graph has a total of three nodes, and therefore contains three parts
	 * as separated by #.
	 * 
	 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. 
	 * Second node is labeled as 1. Connect node 1 to node 2. 
	 * Third node is labeled as 2. Connect node 2 to node 2 (itself), 
	 * thus forming a self-cycle.
	 * 
	 * Visually, the graph looks like the following:
	 * 
	 */
	public static void main(String[] args) {

	}

	// Recursive method to clone undirected graph
	public static UndirectedGraphNode cloneGraphRecursive(UndirectedGraphNode node) {
		if (node == null)
			return null;

		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		return cloneGraphHelper(node, map);
	}

	public static UndirectedGraphNode cloneGraphHelper(
			UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
		if (map.containsKey(node.label))
			return map.get(node.label);

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(newNode.label, newNode);
		for (UndirectedGraphNode tmp : node.neighbors) {
			newNode.neighbors.add(cloneGraphHelper(tmp, map));
		}

		return newNode;
	}

	public static UndirectedGraphNode cloneGraphIterative(
			UndirectedGraphNode node) {
		if (node == null)
			return null;

		// Use queue to clone graph
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		queue.add(node);
		map.put(node.label, newNode);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.pop();
			for (UndirectedGraphNode neighbor : curr.neighbors) {
				if (map.containsKey(neighbor.label) == false) {
					UndirectedGraphNode copy = new UndirectedGraphNode(
							neighbor.label);
					map.put(neighbor.label, copy);
					map.get(curr.label).neighbors.add(copy);
					queue.add(neighbor);
				} else {
					map.get(curr.label).neighbors.add(map.get(neighbor.label));
				}
			}
		}

		return newNode;
	}

	// Definition for undirected graph.
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
