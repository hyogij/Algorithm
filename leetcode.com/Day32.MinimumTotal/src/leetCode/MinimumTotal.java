package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.05
 Question Number : 129
 Link : https://leetcode.com/problems/triangle/
 ==========================================================
 */
public class MinimumTotal {
	/*
	 * Given a triangle, find the minimum path sum from top to bottom. Each step
	 * you may move to adjacent numbers on the row below.
	 * 
	 * For example, given the following triangle 
	 * [ 
	 *    [2], 
	 *   [3,4], 
	 *  [6,5,7],
	 * [4,1,8,3] 
	 * ] 
	 * 
	 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

	 * Note: Bonus point if you are able to do this using only O(n) extra space,
	 * where n is the total number of rows in the triangle.
	 */
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> height1 = new ArrayList<Integer>();
		List<Integer> height2 = new ArrayList<Integer>();
		List<Integer> height3 = new ArrayList<Integer>();
		List<Integer> height4 = new ArrayList<Integer>();
		
		height1.add(2);
		height2.add(3);
		height2.add(4);
		height3.add(6);		
		height3.add(5);		
		height3.add(7);		
		height4.add(4);		
		height4.add(1);		
		height4.add(8);				
		height4.add(3);				
		
		triangle.add(height1);
		triangle.add(height2);
		triangle.add(height3);
		triangle.add(height4);
		
		System.out.println("minimumTotal " + minimumTotal(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		// Edge case when given triangle is empty
		if (triangle.size() < 0) {
			return -1;
		}
		
		// Use dynamic programming approach to solve this problem.
		// That is, find the minimum path from bottom to top.
		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> tree = triangle.get(i);
			for (int j = 0; j < tree.size(); j++) {
				int min = tree.get(j)
						+ Math.min(triangle.get(i + 1).get(j),
								triangle.get(i + 1).get(j + 1));
				tree.set(j, min);
			}
			triangle.set(i, tree);
		}
		
		return triangle.get(0).get(0);
	}
}
