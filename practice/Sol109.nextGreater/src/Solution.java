import java.util.Arrays;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.07
 Problem : http://www.geeksforgeeks.org/next-greater-element/
 ==========================================================
 */
public class Solution {
	/*
	 * Next Greater Element Given an array, print the Next Greater Element (NGE)
	 * for every element. The Next greater Element for an element x is the first
	 * greater element on the right side of x in array. Elements for which no
	 * greater element exist, consider next greater element as -1.
	 * 
	 * Examples: 
	 * a) For any array, rightmost element always has next greater
	 * element as -1. 
	 * b) For an array which is sorted in decreasing order, all
	 * elements have next greater element as -1. 
	 * c) For the input array [4, 5, 2, 25}, 
	 * the next greater elements for each element are as follows.
	 * Element NGE 
	 * 4 --> 5 
	 * 5 --> 25 
	 * 2 --> 25 
	 * 25 --> -1 
	 * d) For the input array [13, 7, 6, 12}, 
	 * the next greater elements for each element are as follows.
	 * Element NGE 
	 * 13 --> -1 
	 * 7 --> 12 
	 * 6 --> 12 
	 * 12 --> -1
	 */
	public static void main(String[] args) {
		int[] arr1 = {4, 5, 2, 25};
		printNGE(arr1);

		int[] arr2 = {13, 7, 6, 12};
		printNGE(arr2);
	}

	public static void printNGE(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0, great = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			num = arr[i];
			if (stack.isEmpty()) {
				great = -1;
			} else {
				while (!stack.isEmpty() && stack.peek() <= num) {
					stack.pop();
				}
				if (stack.isEmpty())
					great = -1;
				else
					great = stack.peek();
			}
			stack.push(num);
			result[i] = great;
		}
		System.out.println(Arrays.toString(result));
	}
}
