package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.08
 Question Number : 17
 Link : https://leetcode.com/problems/maximum-product-subarray/
 ==========================================================
 */
public class MaxProductSubarray {
	/*
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 */
	public static void main(String[] args) {
		int[] nums = {-2, -3, 2, 4, -3};
		System.out.println("maxProduct : " + maxProductBruteFoce(nums));
	}

	// Below solution is not perfect if there are negative values, then product
	// will be positive. Below solution doesn't detect this case.
	public static int maxProduct(int[] nums) {
		int current = 1;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {

			current *= num;
			if (current > max) {
				max = current;
			}

			// Restart of the contiguous subarray if current product value is
			// negative value
			if (current < 0) {
				current = 1;
			}
		}
		return max;
	}

	// Below is brute-force solution, its time complexity is O(n^2)
	public static int maxProductBruteFoce(int[] nums) {
		int current = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// Initialize the current product value
			current = 1;
			for (int j = i; j < nums.length; j++) {
				current *= nums[j];
				if (current > max) {
					max = current;
				}
			}
		}
		return max;
	}
}
