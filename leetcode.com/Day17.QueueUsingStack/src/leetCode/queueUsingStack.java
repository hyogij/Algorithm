package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.08.13
Question Number : 69
Link : https://leetcode.com/problems/implement-queue-using-stacks/
==========================================================
*/

public class queueUsingStack {
	
	/*
	 * Implement the following operations of a queue using stacks.
	 * 
	 * push(x) -- Push element x to the back of queue. 
	 * pop() -- Removes the element from in front of queue. 
	 * peek() -- Get the front element. 
	 * empty() -- Return whether the queue is empty. 
	 * 
	 * Notes: You must use only standard operations of a stack 
	 * -- which means only push to top, peek/pop from top,
	 * size, and is empty operations are valid. 
	 * Depending on your language, stack may not be supported natively. 
	 * You may simulate a stack by using a list or deque (double-ended queue), 
	 * as long as you use only standard operations of a stack. 
	 * You may assume that all operations are valid (for
	 * example, no pop or peek operations will be called on an empty queue).
	 */
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(0);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.printQueue();

		System.out.println("peek " + queue.peek());
		queue.pop();
		queue.printQueue();
		queue.pop();
		queue.printQueue();
	}
	
	public static class MyQueue {
		List<Integer> stack1 = null; // Stack for push method
		List<Integer> stack2 = null; // Stack for pop, peek method
		
		public MyQueue() {
			stack1 = new ArrayList<Integer>();
			stack2 = new ArrayList<Integer>();
		}
		
	    // Push element x to the back of queue.
	    public void push(int x) {
	    		stack1.add(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
			// If the queue is empty, we cannot remove the element from queue
		    	if(empty() == true) {
	    			return;
	    		}

			// Removes the element from stack2 that is used for pop, peek method
			// of queue
	    		if (stack2.size() != 0) {
	    			stack2.remove(stack2.size() - 1);
	    			return;
	    		}
	    		
	    		// Move the elements from stack1 to stack2 to remove method
	    		for (int i = stack1.size() - 1; i >= 0; i--) {
				stack2.add(stack1.get(i));
			}
			stack1.clear();
	    		
	    		pop();
	    }

	    // Get the front element.
	    public int peek() {
	    		if(empty() == true) {
	    			return 0;
	    		}
	    		
	    		if (stack2.size() != 0) {
				// Return the most rear element in the stack2 that is used for
				// pop, peek method of queue
	    			return stack2.get(stack2.size() - 1);
			}
	    		
	        return stack1.get(0);
	    }

		// Return whether the queue is empty.
		public boolean empty() {
			return stack1.size() == 0 && stack2.size() == 0;
		}

		// Print the elements in the queue
		public void printQueue() {
			if (empty() == true) {
				System.out.println("Queue is empty!");
			}
			System.out.print("Print queue: ");
			
			// Print the stack2 in reverse order
			if (stack2.size() != 0) {
				for (int i = stack2.size() - 1; i >= 0; i--) {
					System.out.print(stack2.get(i) + " ");
				}
			}
			// Print the stack1 in order
			if (stack1.size() != 0) {
				for (int i = 0; i < stack1.size(); i++) {
					System.out.print(stack1.get(i) + " ");
				}
			}
			System.out.println();
		}
	}
}
