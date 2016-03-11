import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/problems/course-schedule/
 ==========================================================
 */
public class Solution {
	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 * 
	 * For example: 2, [[1,0]] There are a total of 2 courses to take. To take
	 * course 1 you should have finished course 0. So it is possible.
	 * 
	 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1
	 * you should have finished course 0, and to take course 0 you should also
	 * have finished course 1. So it is impossible.
	 * 
	 * Note: The input prerequisites is a graph represented by a list of edges,
	 * not adjacency matrices. Read more about how a graph is represented.
	 * 
	 * Hints: This problem is equivalent to finding if a cycle exists in a
	 * directed graph. If a cycle exists, no topological ordering exists and
	 * therefore it will be impossible to take all courses. Topological Sort via
	 * DFS - A great video tutorial (21 minutes) on Coursera explaining the
	 * basic concepts of Topological Sort. Topological sort could also be done
	 * via BFS.
	 */
	public static void main(String[] args) {
		// int numCourses = 5;
		// int[][] prerequisites = {{2, 1}, {3, 0}, {4, 2}, {4, 3}};

		int numCourses = 10;
		int[][] prerequisites = {{5, 8}, {3, 5}, {1, 9}, {1, 9}, {4, 5},
				{0, 2}, {7, 8}, {4, 9}};

		// int numCourses = 2;
		// int[][] prerequisites = {{1, 0}};

		System.out.println("canFinish " + canFinish(numCourses, prerequisites));
		System.out.println("canFinishSimple "
				+ canFinishSimple(numCourses, prerequisites));
	}

	public static class Course {
		boolean isVisited = false;
		int num;
		int inbound = 0;
		List<Integer> outbound = null;
		public Course(int num) {
			this.num = num;
			outbound = new ArrayList<Integer>();
		}
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Course[] courses = new Course[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses[i] = new Course(i);
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int a = prerequisites[i][0];
			int b = prerequisites[i][1];

			courses[a].inbound++;
			courses[b].outbound.add(a);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (courses[i].inbound == 0 && courses[i].isVisited == false) {
				courses[i].isVisited = true;
				queue.add(i);
			};
		}

		while (queue.isEmpty() != true) {
			int course = queue.remove();
			List<Integer> outbound = courses[course].outbound;
			for (Integer num : outbound) {
				courses[num].inbound--;
			}

			for (int i = 0; i < numCourses; i++) {
				if (courses[i].inbound == 0 && courses[i].isVisited == false) {
					courses[i].isVisited = true;
					queue.add(i);
				};
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (courses[i].isVisited == false)
				return false;
		}
		return true;
	}

	public static boolean canFinishSimple(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			// pre ---> ready
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			indegree[ready]++;
			matrix[pre][ready]++;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int course = queue.remove();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					indegree[i] -= matrix[course][i];
					if (indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}
}
