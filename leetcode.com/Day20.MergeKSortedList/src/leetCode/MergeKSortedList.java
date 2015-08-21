package leetCode;

import java.util.PriorityQueue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.20
 Question Number : 82
 Link : https://leetcode.com/problems/merge-k-sorted-lists/
 ==========================================================
 */

public class MergeKSortedList {
	/*
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l0 = new ListNode(0);
		ListNode[] lists = new ListNode[2];
		lists[0] = l1;
		lists[1] = l0;
		mergeKLists(lists);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<NodeInfo> queue = new PriorityQueue<NodeInfo>();
		ListNode head = null, current = null;

		// Insert first elements in given lists to the priority queue
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				queue.add(new NodeInfo(i, lists[i]));
			}
		}

		while (queue.isEmpty() == false) {
			// Remove the minimum value in priority queue
			NodeInfo nodeInfo = queue.remove();
			ListNode sorted = new ListNode(nodeInfo.node.val);
			if (head == null) {
				head = sorted;
			} else {
				current.next = sorted;
			}
			current = sorted;

			if (nodeInfo.node.next != null) {
				queue.add(new NodeInfo(nodeInfo.index, nodeInfo.node.next));
			}
		}

		return head;
	}

	public static class NodeInfo implements Comparable<NodeInfo> {
		int index;
		ListNode node;
		NodeInfo(int index, ListNode node) {
			this.index = index;
			this.node = node;
		}

		@Override
		public int compareTo(NodeInfo arg0) {
			if (node.val < arg0.node.val) {
				return -1;
			} else if (node.val > arg0.node.val) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
