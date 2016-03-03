import java.util.ArrayList;
import java.util.Collections;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.03
 Link : http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 ==========================================================
 */
public class Solution {
	/*
	 * Find k closest elements to a given value Given a sorted array arr[] and a
	 * value X, find the k closest elements to X in arr[]. Examples:
	 * 
	 * Input: K = 4, X = 35 arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53,
	 * 55, 56} Output: 30 39 42 45
	 * 
	 * Note that if the element is present in array, then it should not be in
	 * output, only the other closest elements are required.
	 */
	public static void main(String[] args) {
		int[] nums = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		findKClosest(nums, 12, 4);
	}

	public static void findKClosest(int[] nums, int target, int k) {
		int closest = findClosest(nums, target);

		// Traversals array from closest value to left side and right side
		ArrayList<Integer> list = new ArrayList<Integer>();
		int left = closest, right = closest + 1;
		int count = 0;
		int value1, value2;
		while (count < k) {
			if (left >= 0) {
				value1 = nums[left];
			} else {
				value1 = Integer.MIN_VALUE;
			}
			if (right < nums.length) {
				value2 = nums[right];
			} else {
				value2 = Integer.MIN_VALUE;
			}
			// insert closest value from target
			if (Math.abs(value1 - target) > Math.abs(value2 - target)) {
				list.add(value2);
				right++;
			} else {
				list.add(value1);
				left--;
			}
			count++;
		}
		Collections.sort(list);
		System.out.println(list.toString());
	}

	// Find the closest value in sorted array when target value is given
	private static int findClosest(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (right - left > 1) {
				if (nums[mid] == target) {
					return mid;
				} else if (nums[mid] > target) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (Math.abs(nums[mid] - nums[left]) > Math.abs(nums[mid]
						- nums[right])) {
					return right;
				} else {
					return left;
				}
			}
		}
		return -1;
	}
}
