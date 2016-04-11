package leetcode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.02
 Question Number : 4
 Link : https://leetcode.com/problems/swap-nodes-in-pairs/
 ==========================================================
 */
public class SwapNodes {

	/*
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */
	public static void main(String[] args) {

	}
	
	public ListNode newSwapPairs(ListNode head) {
		if(head == null || head.next == null)   
	        return head;
	 
	    ListNode h = new ListNode(0);
	    h.next = head;
	    ListNode p = h;
	 
	    while(p.next != null && p.next.next != null){
	        //use t1 to track first node
	        ListNode t1 = p;
	        p = p.next;
	        t1.next = p.next;
	 
	        //use t2 to track next node of the pair
	        ListNode t2 = p.next.next;
	        p.next.next = p;
	        p.next = t2;
	    }
	 
	    return h.next;
	}

	// Below solution modifies the values, so this solution isn't accepted.
	public ListNode swapPairs(ListNode head) {
		ListNode node = head;
		while(node != null && node.next != null) {
			swapValue(node, node.next);
			node = node.next.next;
		}
		return head;
	}
	
	public void swapValue(ListNode node, ListNode nextNode) {
		int value = node.val;
		node.val = nextNode.val;
		nextNode.val = value;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}