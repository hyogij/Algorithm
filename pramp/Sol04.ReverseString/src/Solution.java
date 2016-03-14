import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.14
 Question Number : 04
 Description : https://leetcode.com/problems/reverse-words-in-a-string/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an input string, reverse the string word by word.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 */
	public static void main(String[] args) {
		char[] sentence = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's',
				' ', 'b', 'l', 'u', 'e'};
		solution(sentence);
		System.out.println("sentence " + Arrays.toString(sentence));
	}

	public static void solution(char[] sentence) {
		if (sentence == null || sentence.length == 0)
			return;

		// 1. reverse whole sentence
		reverse(sentence, 0, sentence.length - 1);

		// 2. reverse words that separated by space characters
		int left = 0, i = 0;
		for (; i < sentence.length; i++) {
			char c = sentence[i];
			if (c == ' ') {
				reverse(sentence, left, i - 1);
				left = i + 1;
			}
		}
		reverse(sentence, left, i - 1);
	}

	public static void reverse(char[] sentence, int left, int right) {
		// int left = 0, right = sentence.length - 1;
		int mid = (right - left) / 2 + left;
		while (left <= mid) {
			char c = sentence[left];
			sentence[left] = sentence[right];
			sentence[right] = c;
			left++;
			right--;
		}
	}

}
