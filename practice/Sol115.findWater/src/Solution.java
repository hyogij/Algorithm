/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : http://www.geeksforgeeks.org/trapping-rain-water/
 ==========================================================
 */
public class Solution {
	/*
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {2, 0, 2} Output: 2 We can trap 2 units of water in the
	 * middle gap.
	 * 
	 * Input: arr[] = {3, 0, 0, 2, 0, 4} Output: 10 We can trap "3*2 units" of
	 * water between 3 an 2, "1 unit" on top of bar 2 and "3 units" between 2
	 * and 4. See below diagram also.
	 * 
	 * Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] Output: 6 Trap
	 * "1 unit" between first 1 and 2, "4 units" between first 2 and 3 and
	 * "1 unit" between second last 1 and last 2
	 */
	public static void main(String[] args) {
		int arr1[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("findWater " + findWater(arr1));

		int arr2[] = { 2, 0, 2 };
		System.out.println("findWater " + findWater(arr2));

		int arr3[] = { 3, 0, 0, 2, 0, 4 };
		System.out.println("findWater " + findWater(arr3));
	}

	public static int findWater(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;

		int[] leftHighest = new int[arr.length];
		int[] rightHighest = new int[arr.length];

		// Find the highest height from left
		leftHighest[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			leftHighest[i] = Math.max(leftHighest[i - 1], arr[i]);
		}

		// Find the highest height from right
		rightHighest[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightHighest[i] = Math.max(rightHighest[i + 1], arr[i]);
		}

		int area = 0;
		for (int i = 0; i < arr.length; i++) {
			int min = Math.min(leftHighest[i], rightHighest[i]);
			if (min > arr[i])
				area += (min - arr[i]);
		}

		return area;
	}

}
