import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.25
 Problem : http://cboard.cprogramming.com/c-programming/46897-check-repeated-digits.html
 ==========================================================
 */
public class Solution {
	public static void main(String[] args) {
		checkDigits(112);
		checkDigits(314);
		checkDigits(3114);
	}

	public static void checkDigits(int num) {
		int original = num;
		HashSet<Integer> set = new HashSet<Integer>();
		while (num != 0) {
			int digit = num % 10;
			if (set.contains(digit)) {
				System.out.println("Duplicated Number : " + original);
				return;
			}
			set.add(digit);
			num /= 10;
		}
		System.out.println("Not Duplicated Number : " + original);
	}
}
