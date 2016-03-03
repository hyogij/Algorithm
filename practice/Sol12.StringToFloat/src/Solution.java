import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.03
 Link : https://leetcode.com/discuss/50519/convert-string-to-float
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string that only contains digit 0-9, dot(.), 'e' and negative
	 * sign '-', your task is converting the given string to a float number.
	 * 
	 * for example: 
	 * "0.0006" => 0.0006 
	 * "6e-4" => 0.0006
	 */
	public static void main(String[] args) {
		System.out.printf("%.10f\n", stringToFloat("11.123"));
		System.out.printf("%.10f\n", stringToFloat("13123"));
		System.out.printf("%.10f\n", stringToFloat("1312.124"));
		System.out.printf("%.10f\n", stringToFloat("0.00006"));
		System.out.printf("%.10f\n", stringToFloat("6e-5"));
	}

	public static float stringToFloat(String str) {
		if (str.contains("e")) {
			return convertFloatWithE(str);
		} else {
			return convertFloat(str);
		}
	}

	private static float convertFloat(String str) {
		float num = 0.0f;
		String[] values = str.split("\\.");
		System.out.println(Arrays.toString(values));
		if (values.length == 1) {
			num = convertIntegerPart(values[0]);
		} else if (values.length == 2) {
			num = convertIntegerPart(values[0]);
			num += convertFixedPointPart(values[1]);
		} else {
			return -1;
		}

		return num;
	}

	private static float convertFloatWithE(String str) {
		float num = 0.0f;
		String[] values = str.split("e-");
		System.out.println(Arrays.toString(values));

		num = convertIntegerPart(values[0]);
		num /= Math.pow(10, convertIntegerPart(values[1]));

		return num;
	}

	// Integer part
	public static int convertIntegerPart(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num *= 10;
			int digit = str.charAt(i) - '0';
			num += digit;
		}
		return num;
	}

	// Fixed point part
	public static float convertFixedPointPart(String str) {
		float num = 0;
		str = reverse(str);
		for (int i = 0; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
			num += digit;
			num /= 10;
		}
		return num;
	}

	public static String reverse(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}
}
