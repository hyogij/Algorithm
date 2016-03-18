import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.18
 Problem : http://cs.stackexchange.com/questions/53726/nth-number-in-a-infinite-sequence-of-numbers
 ==========================================================
 */
public class Solution {
	/*
	 * When the input is a infinite sequence of numbers starting from 1, what is
	 * the nth digit? e.g.) 123456789101112131415161718192021..... 
	 * Here 28th digit is 1.
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append(i);
		}

		System.out.println("nthNumber " + nthNumber(sb.toString(), 9));
		System.out.println("nthNumber " + nthNumber(sb.toString(), 10));
		System.out.println("nthNumber " + nthNumber(sb.toString(), 28));
		System.out.println("nthNumber " + nthNumber(sb.toString(), 29));
		System.out.println("nthNumber " + nthNumber(sb.toString(), 30));
		System.out.println("nthNumber " + nthNumber(sb.toString(), 31));
		System.out.println("nthNumber " + nthNumber(sb.toString(), 100));
	}

	private static final int DIGIT_SIZE = 9;
	// The idea here is as follows:
	// The first 9 digits are 123456789. The next 90 pairs of digits are
	// (10)(11)...(99). The following 900 triplets of digits are
	// (100)(101)...(999). And so on.
	public static String nthNumber(String input, int n) {
		// The first index is 0 so decrease number.
		n = n - 1;
		
		int index = 0, i = 0;
		while (true) {
			index = (int) (Math.pow(10, i) * DIGIT_SIZE);
			if (n > index) {
				n -= index;
				i++;
			} else {
				break;
			}
		}

		int position = n / (i + 1);
		int reminder = n % (i + 1);
		int num = (int) Math.pow(10, i) + position;
		
		return String.valueOf(String.valueOf(num).charAt(reminder));
	}
}
