import java.util.HashSet;
import java.util.Scanner;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.12
 Problem : Identify whether there exists a pair of numbers in array such that their sum is equal to N
 ==========================================================
 */

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // Sum of two numbers
		int m = scanner.nextInt(); // Number of Integers

		HashSet<Integer> hashSet = new HashSet<Integer>();
		boolean isFound = false;

		for (int i = 0; i < m; i++) {
			int num = scanner.nextInt();
			hashSet.add(num);
			if (hashSet.contains(n - num)) {
				isFound = true;
			}
		}
		scanner.close();

		if (isFound == true) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}