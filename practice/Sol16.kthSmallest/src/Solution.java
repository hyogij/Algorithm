

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.07
 Problem : http://articles.leetcode.com/find-k-th-smallest-element-in-union-of/
 http://algorithmsandme.in/2014/12/find-kth-smallest-element-in-two-sorted-arrays/
 ==========================================================
 */
public class Solution {
	/*
	 * Given two sorted arrays A, B of size m and n respectively. Find the k-th
	 * smallest element in the union of A and B. You can assume that there are
	 * no duplicate elements.
	 */
	public static void main(String[] args) {
		int[] array1 = {2, 4, 6, 8, 10, 11};
		int[] array2 = {1, 3, 5, 7, 9, 12, 13, 14};

		int k = 6;
		System.out.println(kthElement(array1, array2, k));
		System.out.println(kthElementAdvanced(array1, array2, array1.length,
				array2.length, k));
	}

	public static int kthElement(int[] array1, int[] array2, int k) {
		int num = -1;

		// Error checks
		if (array1 == null && array2 == null)
			return num;
		if (array1 == null && array2.length < k)
			return num;
		if (array1.length < k && array2 == null)
			return num;
		if (k > array1.length + array2.length)
			return num;

		// O(k) : Use Linear search
		int index = 0, index1 = 0, index2 = 0;
		for (; index1 < array1.length || index2 < array2.length;) {
			if (array1[index1] > array2[index2]) {
				num = array2[index2];
				index2++;
			} else {
				num = array1[index1];
				index1++;
			}
			index++;

			if (index == k) {
				return num;
			}
		}

		return num;
	}

	// O(log(m+n)) : Use binary search
	public static int kthElementAdvanced(int[] array1, int[] array2,
			int length1, int length2, int k) {
		// array2 is longer than array1
		if (length1 > length2) {
			return kthElementAdvanced(array2, array1, length2, length1, k);
		}

		if (length1 == 0 && length2 > 0) {
			return array2[k - 1];
		}

		if (k == 1) {
			return Math.min(array1[k - 1], array2[k - 1]);
		}

		int i = Math.min(length1, k / 2);
		int j = Math.min(length2, k / 2);

		int[] copied1 = null, copied2 = null;
		if (array1[i - 1] > array2[j - 1]) {
			copied1 = new int[i];
			System.arraycopy(array1, 0, copied1, 0, i);
			copied2 = new int[length2 - j];
			System.arraycopy(array2, j, copied2, 0, length2 - j);
			return kthElementAdvanced(copied1, copied2, i, length2 - j, k - j);
		} else {
			copied1 = new int[length1 - i];
			System.arraycopy(array1, i, copied1, 0, length1 - i);
			copied2 = new int[j];
			System.arraycopy(array2, 0, copied2, 0, j);
			return kthElementAdvanced(copied1, copied2, length1 - i, j, k - i);
		}
	}
}
