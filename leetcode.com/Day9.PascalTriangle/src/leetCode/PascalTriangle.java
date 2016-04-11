package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.15
 Question Number : 43
 Link : https://leetcode.com/problems/pascals-triangle/
 ==========================================================
 */
public class PascalTriangle {
	/*
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * [    [1], 
	 *     [1,1], 
	 *   [1,2,1], 
	 *  [1,3,3,1], 
	 * [1,4,6,4,1] ]
	 */
	public static void main(String[] args) {
		System.out.println("generate " + generate(3).toString());
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
		for (int i = 0; i < numRows; i++) {
			List<Integer> subList = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					subList.add(1);
				} else {
					int a = list.get(i - 1).get(j - 1);
					int b = list.get(i - 1).get(j);
					subList.add(a + b);
				}
			}
			list.add(subList);
		}

		return list;
	}
}
