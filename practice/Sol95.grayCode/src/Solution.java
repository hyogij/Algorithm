import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.02
 Link : https://leetcode.com/problems/gray-code/
 ==========================================================
 */
public class Solution {
	/*
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0 01 - 1 11 - 3 10 - 2
	 */
	public static void main(String[] args) {
		System.out.println(grayCode(0).toString());
		System.out.println(grayCode(1).toString());
		System.out.println(grayCode(2).toString());
		System.out.println(grayCode(3).toString());
		System.out.println(grayCode(4).toString());
	}

	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();

		// Initailize with zero value
		list.add(0);

		for (int i = 1; i <= n; i++) {
			int power = (int) Math.pow(2, i - 1);
			for (int j = 1; j <= power; j++) {
				list.add(list.get(power - j) + power);
			}
		}

		return list;
	}

}
