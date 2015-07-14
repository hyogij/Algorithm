package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.13
 Question Number : 33
 Link : https://leetcode.com/problems/climbing-stairs/
 ==========================================================
 */
public class ClimbStairs {
	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
	 */
	public static void main(String[] args) {
		System.out.println("climbStairs " + climbStairsRecursive(4));
	}

	public static int climbStairs(int n) {
		return 0;
	}

	// Recursive method takes a lot of times to solve this problem
	public static int climbStairsRecursive(int n) {
		return climbStairsRecursiveHelper(n + 1);
	}

	public static int climbStairsRecursiveHelper(int n) {
		if (n <= 1) {
			return n;
		} else {
			return climbStairsRecursiveHelper(n - 1) + climbStairsRecursiveHelper(n - 2);
		}
	}
}
