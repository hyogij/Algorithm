import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://www.glassdoor.com/Interview/Interview-1-Given-a-group-of-tasks-and-a-group-of-people-determine-if-the-tasks-can-be-completed-Interview-2-Given-a-s-QTN_1350473.htm
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string, return a string such that the vowels from the start are
	 * swapped with the vowels from the end. 
	 * E.g. 
	 * Input: united states. 
	 * Output: enated stitus.
	 */
	public static void main(String[] args) {
		System.out.println("swapVowels " + swapVowels("united states"));
	}

	public static String swapVowels(String input) {
		if (input == null || input.length() == 0)
			return null;

		HashSet<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('e');

		char[] text = input.toCharArray();
		int left = 0, right = input.length() - 1;

		while (left < right) {
			while (!set.contains(text[left])) {
				left++;
			}

			while (!set.contains(text[right])) {
				right--;
			}
			
			if (left < right) {
				char tmp = text[left];
				text[left] = text[right];
				text[right] = tmp;
			}
			
			left++;			
			right--;
		}

		return String.valueOf(text);
	}
}
