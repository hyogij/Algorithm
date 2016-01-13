import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		// int[] A = {6, 10, 6, 9, 7, 8, 6, 1, 1, 1, 1, 1};
		int[] A = {6, 10, 6, 9, 7, 8, 6, 1, 1, 1, 1, 1, 2, 3, 4, 1, 2};
		// int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		// int[] A = { 1, 2, 3 };
		// int[] A = {6, 10, 6, 9, 7, 8};
		System.out.println("solution " + solution(A));
		System.out.println("solutionAdvanced " + solutionAdvanced(A));
	}

	public static int solution(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		List<List<Integer>> lists = combinations(A);
		int longest = 0;
		for (List<Integer> list : lists) {
			int amplitude = getAmplitude(list);
			if (amplitude <= 1 && list.size() > longest) {
				longest = list.size();
				System.out.println("list " + list.toString());
			}
		}

		return longest;
	}

	public static int solutionAdvanced(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		// Sort array, its time complexity is o(nlogn)
		Arrays.sort(A);

		int amplitude = 0;
		int length = 0, longest = 0;
		for (int right = 1, left = 0; right < A.length; right++) {
			amplitude = A[right] - A[left];
			length = right - left + 1;
			if (amplitude <= 1 && longest < length) {
				longest = length;
			} else {
				left = right - 1;
			}
		}
		return longest;
	}

	public static int getAmplitude(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (Integer num : list) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}

		return max - min;
	}

	public static List<List<Integer>> combinations(int[] arr) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list;
		for (int i = 0; i < arr.length; i++) {
			int k = lists.size();
			for (int j = 0; j < k; j++) {
				list = new ArrayList<Integer>(lists.get(j));
				list.add(new Integer(arr[i]));
				lists.add(list);
			}
			list = new ArrayList<Integer>();
			list.add(new Integer(arr[i]));
			lists.add(list);
		}

		// Add empty subsequences of array
		lists.add(new ArrayList<Integer>());
		return lists;
	}
}
