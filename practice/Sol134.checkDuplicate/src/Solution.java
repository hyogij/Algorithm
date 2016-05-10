import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.05.10
 ==========================================================
 */
public class Solution {
	/*
	 * Display 1 if reverse of a string exists in the input else 0.
	 */
	public static void main(String[] args) {
		String[] array = {"hello", "aaa", "hi", "ih", "banana", "good"};
		checkDuplication(array);
	}

	public static void checkDuplication(String[] array) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			StringBuffer sb = new StringBuffer(array[i]);
			if (set.contains(sb.reverse().toString())) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}
}
