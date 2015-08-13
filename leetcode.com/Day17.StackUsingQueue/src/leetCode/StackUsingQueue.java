package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.13
 Question Number : 68
 Link : https://leetcode.com/problems/implement-stack-using-queues/
 ==========================================================
 */

public class StackUsingQueue {
	/*
	 * Implement the following operations of a stack using queues.
	 * 
	 * push(x) -- Push element x onto stack. 
	 * pop() -- Removes the element on top of the stack. 
	 * top() -- Get the top element. 
	 * empty() -- Return whether the stack is empty. 
	 * Notes: 
	 * You must use only standard operations of a queue 
	 * -- which means only push to back, peek/pop from front, size, and is empty
	 * operations are valid. 
	 * Depending on your language, queue may not be
	 * supported natively. You may simulate a queue by using a list or deque
	 * (double-ended queue), as long as you use only standard operations of a
	 * queue. 
	 * You may assume that all operations are valid (for example, no pop
	 * or top operations will be called on an empty stack).
	 * Update (2015-06-11):
	 * The class name of the Java function had been updated to MyStack instead
	 * of Stack.
	 */
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.printStack();

		System.out.println("top " + stack.top());
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.printStack();
	}

	public static class MyStack {
		Queue<Integer>[] queue = null;

		public MyStack() {
			queue = new LinkedList[2];;
			queue[0] = new LinkedList<Integer>();
			queue[1] = new LinkedList<Integer>();
		}

		// Push element x onto stack.
		public void push(int x) {
			if(empty() == true) {
				queue[0].add(x);
				return;
			}
			
			if(queue[0].isEmpty() == true) {
				queue[1].add(x);
			} else {
				queue[0].add(x);
			}
		}

		// Removes the element on top of the stack.
		public void pop() {
			// Stack is empty
			if(empty() == true) {
				return;
			}
			if(queue[0].isEmpty() == true) {
				while(true) {
					int x = (Integer) queue[1].remove();
					
					if(queue[1].isEmpty() == true) {
						return;
					}
					
					queue[0].add(x);
				}
			} else {
				while(true) {
					int x = (Integer) queue[0].remove();
					
					if(queue[0].isEmpty() == true) {
						return;
					}
					
					queue[1].add(x);
				}
			}
		}

		// Get the top element
		public int top() {
			// Stack is empty
			if (empty() == true) {
				return 0;
			}
			
			if (queue[0].isEmpty() == true) {
				while (true) {
					int x = (Integer) queue[1].remove();
					queue[0].add(x);
					if (queue[1].isEmpty() == true) {
						return x;
					}
				}
			} else {
				while (true) {
					int x = (Integer) queue[0].remove();
					queue[1].add(x);
					if (queue[0].isEmpty() == true) {
						return x;
					}
				}
			}
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue[0].isEmpty() == true && queue[1].isEmpty() == true;
		}
		
		public void printStack() {
			System.out.print("printStack ");
			if (empty() == true) {
				System.out.println("Stack is empty.");
			}
			if (queue[0].isEmpty() == true) {
				System.out.print(" " + queue[1].toString());
			} else {
				System.out.print(" " + queue[0].toString());
			}
			System.out.println();
		}
	}
}
