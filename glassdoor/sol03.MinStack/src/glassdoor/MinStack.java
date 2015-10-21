package glassdoor;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.21
 Question Number : 3
 Link : http://stackoverflow.com/questions/685060/design-a-stack-such-that-getminimum-should-be-o1
 ==========================================================
 */

public class MinStack {
	/*
	 * This is one of an interview question. You need to design a stack which
	 * holds an integer value such that getMinimum() function should return the
	 * minimum element in the stack.
	 * 
	 * For example: consider the below example
	 * 
	 * case #1
	 * 
	 * 5 --> TOP 
	 * 1 
	 * 4 
	 * 6 
	 * 2
	 * 
	 * When getMinimum() is called it should return 1, which is the minimum
	 * element in the stack.
	 * 
	 * case #2
	 * 
	 * stack.pop() stack.pop()
	 * 
	 * Note: Both 5 and 1 are poped out of the stack. So after this, the stack
	 * looks like,
	 * 
	 * 4 --> TOP 
	 * 6 
	 * 2
	 * 
	 * When getMinimum() is called is should return 2 which is the minimum in
	 * the stack.
	 * 
	 * Constriants:	 
	 * getMinimum should return the minimum value in O(1) 
	 * Space constraint also
	 * has to be considered while designing it and if you use extra space, it
	 * should be of constant space.
	 */
	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(15);
		stack.printStack();
		stack.push(13);
		stack.printStack();
		stack.push(21);
		stack.printStack();
		System.out.println("getMinimum " + stack.getMinimum());
		stack.push(9);
		stack.push(17);
		stack.printStack();
		System.out.println("getMinimum " + stack.getMinimum());
		stack.push(7);
		stack.push(9);
		stack.push(16);
		stack.printStack();
		System.out.println("getMinimum " + stack.getMinimum());
		stack.push(6);
		stack.push(8);
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.printStack();
		System.out.println("getMinimum " + stack.getMinimum());
		stack.pop();
		stack.printStack();
		System.out.println("getMinimum " + stack.getMinimum());
		stack.pop();
		stack.printStack();
		System.out.println("getMinimum " + stack.getMinimum());
	}

	// Definition for a stack with getMinimum function.
	public static class Stack {
		int top = 0;
		int capacity = 0;
		int[] array = null;
		
		// This stack is used for the getMinimum function
		int min = 0;
		int[] minStack = null;

		Stack(int x) {
			capacity = x;
			array = new int[capacity];
			minStack = new int[capacity];
		}
		
		public int push(int num) {
			if (isFull() != true) {
				array[top++] = num;
				
				// Compare the number with min stack and push it if number is
				// less and equal with top of min stack value
				if(min == 0 || minStack[min - 1] >= num) {
					minStack[min++] = num;
				}
				
				return num;
			}
			return Integer.MIN_VALUE;
		}

		public int pop() {
			if (isEmpty()) {
				return Integer.MIN_VALUE;
			}
			int num = array[--top];
			System.out.println("Pop : " + num);
			
			// Pop the min stack value if it equals to the number of top of the
			// stack
			if (num == minStack[min]) {
				System.out.println("Pop MinStack : " + minStack[min--]);
			}
			
			return num;
		}

		public int getMinimum() {
			if(isMinStackEmpty() == true) {
				return Integer.MIN_VALUE;
			}
			return minStack[min - 1];
		}

		private boolean isEmpty() {
			if (top == 0) {
				System.out.println("Stack is empty!");
				return true;
			}
			return false;
		}
		
		private boolean isMinStackEmpty() {
			if (min == 0) {
				System.out.println("Min Stack is empty!");
				return true;
			}
			return false;
		}

		private boolean isFull() {
			if (top == capacity) {
				System.out.println("Stack is full!");
				return true;
			}
			return false;
		}

		private void printStack() {
			if (isEmpty() == false) {
				System.out.print("Stack : ");
				for (int i = 0; i < top; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();
			}
			
			if (isMinStackEmpty() == false) {
				System.out.print("Min Stack : ");
				for (int i = 0; i < min; i++) {
					System.out.print(minStack[i] + " ");
				}
				System.out.println();
			}
		}
	}
}
