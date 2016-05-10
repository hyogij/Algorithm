
/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.05.10
 ==========================================================
 */
public class Solution {
	/*
	 * Find out the sum of all digit from M to N (both inclusive)
	 * 
	 * Input M=1 ,N=10 
	 * Output 46 (1+2+3+4+5+6+7+8+9+1+0) 
	 * Input M=10 N=15 
	 * Output 21 (1+0+1+1+1+2+1+3+1+4+1+5)
	 */
	public static void main(String[] args) {
		System.out.println(digitsSum(1, 10));
		System.out.println(digitsSum(10, 15));
	}

	public static int digitsSum(int a, int b) {
		int total = 0;
		for (int i = a; i <= b; i++) {
			int num = i;
			while (num != 0) {
				total += num % 10;
				num /= 10;
			}
		}
		return total;
	}
}
