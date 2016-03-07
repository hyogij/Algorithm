import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.07
 Problem : http://articles.leetcode.com/here-is-phone-screening-question-from/
 ==========================================================
 */
public class Solution {
	/*
	 * Intersecting Two Sorted Integer Arrays 
	 * 
	 * An interesting problem I've run to recently is the following 
	 * (I tried to express it using Jon Bentley's convention):
	 * 
	 * Input: Two sorted integer arrays A and B in increasing order and of
	 * different sizes N and M, respectively.
	 * 
	 * Output: A sorted integer array C in increasing order that contains
	 * elements that appear in both A and B
	 */
	public static void main(String[] args) {
		int[] array1 = {3, 4, 6, 8, 9, 11};
		int[] array2 = {4, 5, 6, 9, 10, 11, 19, 20};

		findIntersection(array1, array2);
		findIntersectionAdvanced(array1, array2);
	}

	// O(m + n) : Use merge sort
	public static void findIntersection(int[] array1, int[] array2) {
		int index1 = 0, index2 = 0;
		while(index1 < array1.length && index2 < array2.length) {
			if(array1[index1] == array2[index2]) {
				System.out.print(array1[index1] + " ");
				index1++;
				index2++;
			} else if(array1[index1] > array2[index2]) {
				index2++;
			} else {
				index1++;
			}
		}
		System.out.println();
	}

	// O(nlogn) : Use binary search
	public static void findIntersectionAdvanced(int[] array1, int[] array2) {
		for(int i = 0; i < array1.length; i++) {
			int num = array1[i];
			int index = Arrays.binarySearch(array2, num);
			if(index >= 0) {
				System.out.print(array2[index] + " ");
			}
		}
	}
}