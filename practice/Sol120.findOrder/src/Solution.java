import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : https://leetcode.com/problems/course-schedule-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs,
	 * return the ordering of courses you should take to finish all courses.
	 * 
	 * There may be multiple correct orders, you just need to return one of
	 * them. If it is impossible to finish all courses, return an empty array.
	 * 
	 * For example:
	 * 
	 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
	 * should have finished course 0. So the correct course order is [0,1]
	 * 
	 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To
	 * take course 3 you should have finished both courses 1 and 2. Both courses
	 * 1 and 2 should be taken after you finished course 0. So one correct
	 * course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
	 * 
	 */
	public static void main(String[] args) {
		// int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		// int[] orders = findOrder(4, prerequisites);
		int[][] prerequisites = { { 1, 0 } };
		int[] orders = findOrder(3, prerequisites);
		System.out.println(Arrays.toString(orders));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites == null || prerequisites.length == 0)
			return new int[] {};

		// Make graph nodes
		Graph[] g = new Graph[numCourses];
		for (int i = 0; i < numCourses; i++) {
			g[i] = new Graph(i);
		}

		// Make edges in grpah
		for (int i = 0; i < prerequisites.length; i++) {
			// node2 - > node1
			int node1 = prerequisites[i][0];
			int node2 = prerequisites[i][1];
			g[node2].addOutEdge(node1);
			g[node1].addInEdge();
		}

		int[] orders = new int[numCourses];
		boolean[] visited = new boolean[numCourses];

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == false && g[i].indegree == 0) {
				visited[i] = true;
				stack.push(i);
			}
		}

		int index = 0;
		while (!stack.isEmpty()) {
			int node = stack.pop();
			orders[index++] = node;

			// Remove all edges from i node
			for (int to : g[node].outdegree) {
				g[to].indegree--;
			}

			for (int i = 0; i < numCourses; i++) {
				if (visited[i] == false && g[i].indegree == 0) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}

		if (index == numCourses)
			return orders;
		return new int[] {};
	}

	public static class Graph {
		int course;
		int indegree = 0;
		List<Integer> outdegree = null;

		Graph(int num) {
			course = num;
			outdegree = new ArrayList<Integer>();
		}

		// Edge to other nodes
		public void addOutEdge(int num) {
			outdegree.add(num);
		}

		// Edge from other nodes
		public void addInEdge() {
			indegree++;
		}
	}
}
