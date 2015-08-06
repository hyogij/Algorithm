package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.06
 Question Number : 59
 Link : https://leetcode.com/problems/delete-node-in-a-linked-list/
 ==========================================================
 */

public class deleteNode {
	/*
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		printNode(l1);
		deleteNode(l3);
		printNode(l1);
	}

	public static void deleteNode(ListNode node) {
		if(node == null) {
			return;
		}
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}

	public static void printNode(ListNode head) {
		System.out.print("printNode : ");
		while(head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}