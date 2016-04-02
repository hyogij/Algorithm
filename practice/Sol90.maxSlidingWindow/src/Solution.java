import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.01
 Link : https://leetcode.com/problems/sliding-window-maximum/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array nums, there is a sliding window of size k which is moving
	 * from the very left of the array to the very right. You can only see the k
	 * numbers in the window. Each time the sliding window moves right by one
	 * position.
	 * 
	 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
	 * 
	 * Window position Max 
	 * --------------- ----- 
	 * [1 3 -1] -3 5 3 6 7 	3 
	 * 1 [3 -1-3] 5 3 6 7 	3 
	 * 1 3 [-1 -3 5] 3 6 7 	5
	 * 1 3 -1 [-3 5 3] 6 7 	5 
	 * 1 3 -1 -3 [5 3 6] 7 	6 
	 * 1 3 -1 -3 5 [3 6 7] 	7 
	 * Therefore, return the max sliding window as  [3,3,5,5,6,7].
	 * 
	 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size
	 * for non-empty array.
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(Arrays.toString(maxSlidingWindow(nums1, 3)));
		System.out.println(Arrays.toString(maxSlidingWindowAdvnaced(nums1, 3)));
		System.out.println(Arrays.toString(maxSlidingWindowLinkedList(nums1, 3)));

		int[] nums2 = { 9, 10, 9, -7, -4, -8, 2, -6, 5 };
		System.out.println(Arrays.toString(maxSlidingWindow(nums2, 5)));
		System.out.println(Arrays.toString(maxSlidingWindowAdvnaced(nums2, 5)));
		System.out.println(Arrays.toString(maxSlidingWindowLinkedList(nums2, 5)));
		
		int[] nums3 = { -1, 3, -2, -4, -5, -6, -7, -8 };
		System.out.println(Arrays.toString(maxSlidingWindow(nums3, 3)));
		System.out.println(Arrays.toString(maxSlidingWindowAdvnaced(nums3, 3)));
		System.out.println(Arrays.toString(maxSlidingWindowLinkedList(nums3, 3)));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		// Return empty array when inputs are not valid
		if (nums == null || nums.length == 0 || nums.length < k)
			return new int[0];

		int[] result = new int[nums.length - k + 1];

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

		int index = 0;
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		result[index++] = heap.peek();

		for (int i = k, j = 0; j < nums.length - k; i++, j++) {
			heap.remove(nums[j]);
			heap.add(nums[i]);
			result[index++] = heap.peek();
		}
		return result;
	}
	
	public static int[] maxSlidingWindowAdvnaced(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// Store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// Remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// Remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// Q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}

	// We can use linked list like deque
	public static int[] maxSlidingWindowLinkedList(int[] nums, int k) {
		// Return empty array when inputs are not valid
		if (nums == null || nums.length == 0 || nums.length < k)
			return new int[0];

		int[] result = new int[nums.length - k + 1];

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < k - 1; i++) {
			addValue(list, nums[i]);
		}
		for (int i = k - 1, j = 0; j < nums.length - k + 1; i++, j++) {
			System.out.println(nums[j]  + " : " + list.toString());
			
			addValue(list, nums[i]);
			result[j] = list.getFirst();

			if (list.getFirst() == nums[j])
				list.removeFirst();
		}
		return result;
	}

	// Insert new value into the linked list by desc order, if current value is
	// greater than the value of linked list then remove that nodes.
	private static void addValue(LinkedList<Integer> list, int value) {
		while (list.isEmpty() != true && value > list.getLast())
			list.removeLast();
		list.add(value);
	}
}
