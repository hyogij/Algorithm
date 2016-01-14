import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		// int[] A = {6, 10, 6, 9, 7, 8, 6, 1, 1, 1, 1, 1};
		// int[] A = {6, 10, 6, 9, 7, 8, 6, 1, 1, 1, 1, 1, 2, 3, 4, 1, 2};
		// int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		// int[] A = { 1, 2, 3 };
		// int[] A = {6, 10, 6, 9, 7, 8};
		int[] A = {1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3};
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
			}
		}

		return longest;
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

	public static int solutionAdvanced(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		// Sort an array using quick sort algorithm, its worst-case time
		// complexity is O(nlogn)
		quickSort(A, 0, A.length - 1);

		int amplitude = 0;
		int length = 0, longest = 0;
		int candidateOfLeft1 = 0, candidateOfLeft2 = 0;
		// Use sliding window [left,right] to calculate of its amplitude
		for (int right = 1, left = 0; right < A.length; right++) {
			amplitude = A[right] - A[left];
			length = right - left + 1;

			// Quasi-constant : Amplitude does not exceed 1
			if (amplitude <= 1 && longest < length) {
				longest = length;
			} else {
				// Move the left position to the next candidate
				left = candidateOfLeft1;
			}

			if (A[right - 1] != A[right]) {
				candidateOfLeft1 = candidateOfLeft2;
				candidateOfLeft2 = right;
			}
		}
		return longest;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// Pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// Recursively sort two sub parts
		if (low < j) {
			quickSort(arr, low, j);
		}

		if (high > i) {
			quickSort(arr, i, high);
		}
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
}
