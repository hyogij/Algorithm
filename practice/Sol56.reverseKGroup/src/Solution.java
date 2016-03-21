/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : https://leetcode.com/problems/reverse-nodes-in-k-group/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, 
	 * Given this linked list: 1->2->3->4->5 
	 * For k = 2, you should return: 2->1->4->3->5 
	 * For k = 3, you should return: 3->2->1->4->5
	 */
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);

		printLinkedList(list);

		ListNode list1 = reverseKGroup(list, 3);
		printLinkedList(list1);
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode root = null;

		if (head == null)
			return null;

		ListNode start = head, end = null;
		ListNode prev = null, next = null;
		ListNode current = head;
		int count = 1;
		while (current != null) {
			next = current.next;
			end = current;

			if (count % k == 0) {
				ListNode node = reverse(start, end);
				
				if (prev == null)
					root = node;

				for(int j = 0; j < k; j++) {
					prev = node;
					node = node.next;
				}
				prev.next = next;
			}

			current = current.next;
			count++;
		}

		// If linked list's size is smaller than k,
		if (root == null)
			root = head;

		return root;
	}

	private static ListNode reverse(ListNode start, ListNode end) {
		System.out.println("reverse : " + start.val + " -- " + end.val); 
		
		ListNode current = start;
		ListNode prev = null, next = null;
		while (prev != end) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	static class ListNode {
		int val;
		ListNode next = null;
		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void printLinkedList(ListNode head) {
		System.out.print("printLinkedList : ");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

}
