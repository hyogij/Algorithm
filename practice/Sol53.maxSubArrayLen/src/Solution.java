import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : http://algobox.org/maximum-size-subarray-sum-equals-k/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array nums and a target value k, find the maximum length of a
	 * subarray that sums to k. If there isn¡¯t one, return 0 instead.
	 * 
	 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the
	 * subarray [1, -1, 5, -2] sums to 3 and is the longest)
	 * 
	 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the
	 * subarray [-1, 2] sums to 1 and is the longest)
	 * 
	 * Follow Up: Can you do it in O(n) time?
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, -1, 5, -2, 3};
		System.out.println("maxSubArrayLen " + maxSubArrayLen(3, nums1));
		System.out.println("maxSubArrayLenAdvanced "
				+ maxSubArrayLenAdvanced(3, nums1));

		int[] nums2 = {-2, -1, 2, 1};
		System.out.println("maxSubArrayLen " + maxSubArrayLen(1, nums2));
		System.out.println("maxSubArrayLenAdvanced "
				+ maxSubArrayLenAdvanced(1, nums2));
	}

	public static int maxSubArrayLen(int s, int[] nums) {
		int max = 0;
		if (nums == null || nums.length == 0)
			return max;

		int[] sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		// Find the sub array from i to j that sums to k
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int total = sum[j + 1] - sum[i];

				int length = j - i + 1;
				if (total == s && length > max)
					max = length;
			}
		}

		return max;
	}

	public static int maxSubArrayLenAdvanced(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int length = nums.length, sum = 0, maxSubLen = 0;

		// Using a hash map to store the sum of all the values before and
		// include nums[i]
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			sum += nums[i];
			if (sum == s) {
				maxSubLen = Math.max(maxSubLen, i + 1);
			} else if (map.containsKey(sum - s)) {
				maxSubLen = Math.max(maxSubLen, i - map.get(sum - s));
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxSubLen;
	}
}