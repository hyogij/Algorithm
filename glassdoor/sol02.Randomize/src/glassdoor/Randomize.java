package glassdoor;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.20
 Question Number : 2
 Link : http://www.geeksforgeeks.org/shuffle-a-given-array/
 ==========================================================
 */

public class Randomize {
	/*
	 * Given an array, write a program to generate a random permutation of array
	 * elements. This question is also asked as ¡°shuffle a deck of cards¡± or
	 * ¡°randomize a given array¡±.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		randomize(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	public static void randomize(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		// Set the numbers into the left position of array that are selected by
		// random function. Then all number are selected through this randomize
		// class.
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			index = (int) ((Math.random() * (nums.length - i))
					% (nums.length - i) + i);
			swap(nums, i, index);
		}
	}

	private static void swap(int[] nums, int a, int b) {
		int tmp = nums[b];
		nums[b] = nums[a];
		nums[a] = tmp;
	}
}
