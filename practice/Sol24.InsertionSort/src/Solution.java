import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.09
 Problem : https://leetcode.com/problems/insertion-sort-list/
 ==========================================================
 */
public class Solution {
	/*
	 * Sort a linked list using insertion sort.
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(5);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(7);

		printList(head);
		ListNode list = insertionSortList(head);
		printList(list);
		
		int[] nums = {5, 6, 1, 2, 8, 12, 10};
		insertionSort(nums);
		insertionSortReverse(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	// Sort an array using insertion sort algorithm
	private static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0; j--) {
				if (nums[j] < nums[j - 1]) {
					int tmp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
	}

	private static void insertionSortReverse(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = i; j < nums.length - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		ListNode curr = head, next = null;
		while(curr != null) {
			next = curr.next;
			insert(dummyHead, curr);
			curr = next;
		}
		return dummyHead.next;
	}
	
	private static void insert(ListNode dummyHead, ListNode target) {
		// left to right scan to insert the target node
		ListNode curr = dummyHead;
		while (curr.next != null && curr.next.val < target.val) {
			curr = curr.next;
		}
		target.next = curr.next;
		curr.next = target;
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	private static void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
