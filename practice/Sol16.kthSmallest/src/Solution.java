import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

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
		int[] array1 = {1, 2, 3, 4, 5, 6, 7};
		int[] array2 = {8, 9, 10, 11, 12, 13};

		int k = 6;
		System.out.println(kthElement(array1, array2, k));
		System.out.println(kthElementAdvanced(array1, array2, array1.length,
				array2.length, k));
		System.out.println(kthsmallest(array1, array2, k));

		System.out.println(kthElement(array1, array2, 2));
		System.out.println(kthElementAdvanced(array1, array2, array1.length,
				array2.length, 2));
		System.out.println(kthsmallest(array1, array2, 2));

		System.out.println(kthElement(array1, array2, 8));
		System.out.println(kthElementAdvanced(array1, array2, array1.length,
				array2.length, 8));
		System.out.println(kthsmallest(array1, array2, 8));
		
		Stack<String> stack = new Stack<String>();
		stack.push("");
		stack.pop();
		
		PriorityQueue<Integer> q =
				new PriorityQueue<Integer>(10, Collections.reverseOrder());
		q.add(11);
		q.add(10);
		q.add(1);
		q.add(27);
		q.add(2);
		q.add(7);
		System.out.println(q.toString());
		
		PriorityQueue<String> q1 =
				new PriorityQueue<String>();
		q1.add("kk");
		q1.add("tt");
		q1.add("zz");
		q1.add("aa");		
		System.out.println(q1.toString());
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
		for (; index1 < array1.length && index2 < array2.length;) {
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

	public static int kthsmallest(int[] A, int[] B, int k) {
		int begin = Math.max(0, k - B.length); // Binary search begin index
		int end = Math.min(A.length, k); // Binary search end end index

		while (begin < end) {
			// Search until mid = k
			int mid = begin + (end - begin) / 2;

			if (mid < A.length && k - mid > 0 && A[mid] < B[k - mid - 1]) {
				begin = mid + 1;
			} else if (mid > 0 && k - mid < B.length && A[mid - 1] > B[k - mid]) {
				end = mid;
			} else {
				begin = mid;
				break;
			}
		}

		if (begin == 0) {
			return B[k - 1];
		} else if (begin == k) {
			return A[k - 1];
		} else {
			return Math.max(A[begin - 1], B[k - begin - 1]);
		}
	}
}