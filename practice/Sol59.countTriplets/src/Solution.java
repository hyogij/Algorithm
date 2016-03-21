import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of distinct integers and a sum value. Find count of
	 * triplets with sum smaller than given sum value. Expected Time Complexity
	 * is O(n2).
	 * 
	 * Examples: Input : arr[] = {-2, 0, 1, 3} sum = 2. Output : 2 Explanation :
	 * Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3)
	 * 
	 * Input : arr[] = {5, 1, 3, 4, 7} sum = 12. Output : 4 Explanation : Below
	 * are triplets with sum less than 4 (1, 3, 4), (1, 3, 5), (1, 3, 7) and (1,
	 * 4, 5)
	 */
	public static void main(String[] args) {
		int[] arr1 = {-2, 0, 1, 3};
		System.out.println("countTriplets " + countTriplets(arr1, 2));

		int[] arr2 = {5, 1, 3, 4, 7};
		System.out.println("countTriplets " + countTriplets(arr2, 12));

		int[] arr3 = {1, 10, 55, 100};
		System.out.println("countTriplets " + countTriplets(arr3, 120));
	}

	public static int countTriplets(int[] arr, int num) {
		if (arr == null || arr.length == 0)
			return 0;

		Arrays.sort(arr);

		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int first = arr[i];
			int left = i + 1, right = arr.length - 1;
			while (left < right) {
				int sum = first + arr[left] + arr[right];
				if (sum < num) {
					System.out.println(first + ", " + arr[left] + ", "
							+ arr[right]);
					// This is important. For current i and j, there can be
					// total k-j third elements. Below are candidates (first,
					// left, right), (first, left, right-1), (first, left,
					// right-2), etc
					count += (right - left);
					left++;
				} else {
					right--;
				}
			}
		}
		return count;

	}
}
