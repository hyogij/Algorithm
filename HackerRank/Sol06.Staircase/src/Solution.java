import java.util.Scanner;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.26
 Problem : Draw a staircase of height N
 Reference : http://problemsolvinginjava.blogspot.kr/2015/06/staircase.html
 ==========================================================
 */
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		printStaircase(num);
		scanner.close();
		return;
	}

	private static void printStaircase(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = 0; j < num - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}