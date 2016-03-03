/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.03
 ==========================================================
 */
public class Solution {
	/*
	 * Find the closest element in sorted float array if target integer value is given.
	 */
	public static void main(String[] args) {
		float[] nums = {1.1f, 1.2f, 2.9f, 3.4f, 4.95f, 5.11f, 5.2f, 6.4f, 8f};
		System.out.println("findClosest " + findClosest(nums, 3));
		System.out.println("findClosest " + findClosest(nums, 5));
	}

	private static float findClosest(float[] nums, int num) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (right - left > 1) {
				if (nums[mid] > num) {
					right = mid;
				} else if (nums[mid] < num) {
					left = mid;
				} else if (nums[mid] == num) {
					return nums[mid];
				}
			} else {
				if (Math.abs(nums[left] - num) > Math.abs(nums[right] - num)) {
					return nums[right];
				} else {
					return nums[left];
				}
			}
		}
		return -1.0f;
	}
}