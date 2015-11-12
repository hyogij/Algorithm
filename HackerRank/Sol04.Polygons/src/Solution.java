import java.util.Scanner;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.12
 Link : Determine the given rectangle is square or not
 ==========================================================
 */

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int square = 0, rectangle = 0, neither = 0;
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();

			if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
				neither++;
			} else if (a != c || b != d) {
				neither++;
			} else if (a == b && b == c && c == d && d == a) {
				square++;
			} else {
				rectangle++;
			}
		}
		scanner.close();
		System.out.println(square + " " + rectangle + " " + neither);
	}
}