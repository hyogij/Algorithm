package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.07
 Question Number : 13
 Link : https://leetcode.com/problems/minimum-size-subarray-sum/
 ==========================================================
 */
public class MinSubArrayLen {
	/*
	 * Given an array of n positive integers and a positive integer s, find the
	 * minimal length of a subarray of which the sum ≥ s. If there isn't one,
	 * return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
	 * has the minimal length under the problem constraint.
	 */
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 2, 4, 3};
		int result = minSubArrayLen(7, nums);
		System.out.println(result);
	}

	// i) 뒤에서부터 하나씩 더한다 
	// ii) 가장 뒤가 아닌 경우 그 전에 것을 포함한다 
	// 2개가 될 지, 3개가 될지는 어떻게 알어? 계속 추가하면 되는거야? 
	public static int minSubArrayLen(int s, int[] nums) {
		int count = 0;
		quickSort(nums, 0, nums.length - 1);
		return count;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}
}
