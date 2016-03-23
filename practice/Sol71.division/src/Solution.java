import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.23
 Problem : http://blueocean-penn.blogspot.kr/2014/05/divide-number-and-return-result-in.html
 http://allenlipeng47.com/PersonalPage/index/view/83/nkey
 ==========================================================
 */
public class Solution {
	/*
	 * Divide number and return result in form of a string. e.g 100/3 result
	 * should be 33.(3) Here 3 is in brackets because it gets repeated
	 * continuously and 5/10 should be 0.5.
	 */
	public static void main(String[] args) {
		System.out.println("division " + division(100, 3));
		System.out.println("division " + division(5, 10));
		System.out.println("division " + division(10, 2));
		System.out.println("division " + division(10, 3));
		System.out.println("division " + division(77, 6)); // 12.8(3)
		System.out.println("division " + division(97, 6)); // 16.1(6)
	}

	public static String division(int dividend, int divisor) {
		StringBuffer sb = new StringBuffer();

		int quotient = dividend / divisor;
		int remainder = dividend % divisor;

		// Integer part
		if (remainder == 0) {
			// If there is no remainder
			sb.append(quotient);
			return sb.toString();
		} else {
			// If there is remainder
			sb.append(quotient);
			sb.append(".");
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// Decimal part
		while (remainder != 0) {
			dividend = (dividend - (quotient * divisor)) * 10;
			quotient = dividend / divisor;
			remainder = dividend % divisor;

			if (map.containsKey(dividend) == true) {
				sb.insert(map.get(dividend) - 1, "(");
				sb.append(")");
				break;
			}
			sb.append(quotient);
			map.put(dividend, sb.toString().length());
		}
		return sb.toString();
	}
}
