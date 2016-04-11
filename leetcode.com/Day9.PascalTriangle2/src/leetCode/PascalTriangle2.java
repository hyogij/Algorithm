package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.15
 Question Number : 44
 Link : https://leetcode.com/problems/pascals-triangle-ii/
 ==========================================================
 */
public class PascalTriangle2 {
	/*
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 */
	public static void main(String[] args) {
		System.out.println("getRow " + getRow(3));
	}

	public static List<Integer> getRow(int rowIndex) {
		rowIndex += 1; 
		List<List<Integer>> list = new ArrayList<List<Integer>>(rowIndex);
		for (int i = 0; i < rowIndex; i++) {
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

		return list.get(rowIndex-1);
	}
}
