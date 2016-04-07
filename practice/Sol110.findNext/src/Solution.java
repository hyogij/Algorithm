import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.07
 Problem : https://leetcode.com/problems/next-permutation/
 http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 ==========================================================
 */
public class Solution {
	/*
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 
	 * 1,2,3 �� 1,3,2 
	 * 3,2,1 �� 1,2,3 
	 * 1,1,5 �� 1,5,1 
	 * 
	 * Input: n = "218765" Output: "251678"
	 * Input: n = "1234" Output: "1243"
	 * Input: n = "4321" Output: "Not Possible"
	 * Input: n = "534976" Output: "536479"
	 */
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		nextPermutation(arr1);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = {2, 3, 1};
		nextPermutation(arr2);
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = {1, 3, 2};
		nextPermutation(arr3);
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = {5, 3, 4, 9, 7, 6};
		nextPermutation(arr4);
		System.out.println(Arrays.toString(arr4));
		
		int[] arr5 = {2, 1, 8, 7, 6, 5};
		nextPermutation(arr5);
		System.out.println(Arrays.toString(arr5));
		
		int[] arr6 = {2, 3, 1};
		nextPermutation(arr6);
		System.out.println(Arrays.toString(arr6));
	}
	
//		Input:
//		[4,2,0,2,3,2,0]
//		Output:
//		[4,2,2,0,0,2,3]
//		Expected:
//		[4,2,0,3,0,2,2]

	public static void nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {

				// Find the first value which is smaller than left element
				if (nums[i] > nums[j]) {
					swap(nums, i, j);
					
					// Generate new small number with these indexes
					generateSmallNumber(nums, j + 1, nums.length);
					return;
				}
			}
		}

		generateSmallNumber(nums, 0, nums.length);
		return;
	}

	private static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	private static void generateSmallNumber(int[] nums, int left, int right) {
		Arrays.sort(nums, left, right);
	}
}
