package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.16
 Question Number : 46
 Link : https://leetcode.com/problems/min-stack/
 ==========================================================
 */
public class MinStack {
	/*
	 * Design a stack that supports push, pop, top, and retrieving the minimum
	 * element in constant time.
	 * 
	 * push(x) -- Push element x onto stack. pop() -- Removes the element on top
	 * of the stack. top() -- Get the top element. getMin() -- Retrieve the
	 * minimum element in the stack.
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(0);
		stack.push(1);
		stack.push(0);
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.getMin();
	}

	public static class Stack {
		List<Integer> list = null;
		List<Integer> minList = null;

		public Stack() {
			list = new ArrayList<Integer>();
			minList = new ArrayList<Integer>();
		}

		public void push(int x) {
			list.add(x);
			int length = minList.size();
			if (length == 0 || (length != 0 && minList.get(length - 1) >= x)) {
				minList.add(x);
			}
		}

		public void pop() {
			if (list.isEmpty() == false) {
				int value = list.get(list.size() - 1);
				list.remove(list.size() - 1);

				int length = minList.size();
				if (value == minList.get(length - 1)) {
					minList.remove(minList.size() - 1);
				}
			}
		}

		public int top() {
			return list.get(list.size() - 1);
		}

		public int getMin() {
			return minList.get(minList.size() - 1);
		}

		public void printStack() {
			System.out.println("List " + list.toString());
			System.out.println("Min List " + minList.toString());
		}
	}
}
