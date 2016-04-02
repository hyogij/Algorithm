import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.02
 Link : http://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of integers, find the nearest smaller number for every
	 * element such that the smaller element is on left side.
	 */
	public static void main(String[] args) {
		int arr1[] = { 1, 3, 0, 2, 5 };
		printPrevSmaller(arr1);

		int arr2[] = { 1, 6, 4, 10, 2, 5 };
		printPrevSmaller(arr2);

		int arr3[] = { 1, 3, 0, 2, 5 };
		printPrevSmaller(arr3);
	}

	private static void printPrevSmaller(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		Stack<Integer> stack = new Stack<Integer>();
		for (int num : arr) {
			while (stack.isEmpty() != true && stack.peek() > num) {
				stack.pop();
			}
			if (stack.isEmpty() == true) {
				System.out.print("-1" + " ");
			} else {
				System.out.print(stack.peek() + " ");
			}

			stack.push(num);
		}
		System.out.println("");
	}
}