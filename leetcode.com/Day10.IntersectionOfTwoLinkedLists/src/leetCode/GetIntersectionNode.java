package leetCode;

import java.util.HashSet;
import java.util.Set;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.16
 Question Number : 47
 Link : https://leetcode.com/problems/intersection-of-two-linked-lists/
 ==========================================================
 */
public class GetIntersectionNode {
	/*
	 * Write a program to find the node at which the intersection of two singly
	 * linked lists begins.
	 * 
	 * For example, the following two linked lists:
	 * 
	 * A:        a1 ¡æ a2 
	 *                         ¢Ù c1 ¡æ c2 ¡æ c3 
	 *                         ¢Ö 
	 * B: b1 ¡æ b2 ¡æ b3 
	 * begin to intersect at node c1.
	 * 
	 * Notes:
	 * 
	 * If the two linked lists have no intersection at all, return null. The
	 * linked lists must retain their original structure after the function
	 * returns. You may assume there are no cycles anywhere in the entire linked
	 * structure. Your code should preferably run in O(n) time and use only O(1)
	 * memory.
	 */
	public static void main(String[] args) {
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA, sizeB;
		int forward = 0;

		if ((headA == null && headB == null)
				|| (headA == null && headB != null)
				|| (headA != null && headB == null)) {
			return null;
		}

		sizeA = getNodeSize(headA);
		sizeB = getNodeSize(headB);
		
		if(sizeA >= sizeB) {
			// Moves next node from listnode A
			forward = sizeA - sizeB;
			while(forward >0) {
				headA = headA.next;
				forward--;
			}
		} else {
			// Moves next node from listnode A
			forward = sizeB - sizeA;		
			while(forward >0) {
				headB = headB.next;
				forward--;
			}
		}
		
		while(headA != null && headB != null) {
			if(headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	// Gets a node size
	public static int getNodeSize(ListNode head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}

	public ListNode getIntersectionNodeBasic(ListNode headA, ListNode headB) {
		// Uses a set to store node of linked list, but it needs an additional
		// storage
		Set<ListNode> set = new HashSet<ListNode>();

		ListNode nodeA = headA;
		while (nodeA != null) {
			set.add(nodeA);
			nodeA = nodeA.next;
		}

		ListNode nodeB = headB;
		while (nodeB != null) {
			if (set.contains(nodeB) == true) {
				return nodeB;
			}
			nodeB = nodeB.next;
		}

		return null;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}