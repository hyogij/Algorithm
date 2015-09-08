package codility;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.07
 Lesson Number : 2
 Link : https://codility.com/demo/take-sample-test/perm_missing_elem/
 ==========================================================
 */

public class PermMissingElem {
	/*
	 * A zero-indexed array A consisting of N different integers is given. The
	 * array contains integers in the range [1..(N + 1)], which means that
	 * exactly one element is missing.
	 * 
	 * Your goal is to find that missing element.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given a zero-indexed array A, returns the value of the missing
	 * element.
	 * 
	 * For example, given array A such that:
	 * 
	 * A[0] = 2 
	 * A[1] = 3 
	 * A[2] = 1 
	 * A[3] = 5 
	 * the function should return 4, as it is the missing element.
	 * 
	 * Assume that:
	 * 
	 * N is an integer within the range [0..100,000]; the elements of A are all
	 * distinct; each element of array A is an integer within the range [1..(N +
	 * 1)]. Complexity:
	 * 
	 * expected worst-case time complexity is O(N); expected worst-case space
	 * complexity is O(1), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 */

	public static void main(String[] args) {
		int[] A = {2, 3, 1, 5};
		System.out.println("solution " + solution(A));
		System.out.println("solutionXor " + solutionXor(A));
	}
	
	// There are many solutions to solve this problem.
	// i) Use HashSet
	// ii) Use bit operators
	// iii) Use summation
	// iv) Use -1 index
	// v) Use XOR
	
	public static int solution(int[] A) {
		int n = A.length + 1;
		long sum = (n * (n + 1)) / 2;

		// Use a summation of integers in the range [1..(N + 1)], after then
		// minus each interger values.
		// Finally missing number is remained.
		for (int i = 0; i < A.length; i++) {
			sum -= A[i];
		}

		return (int) sum;
	}

	public static int solutionXor(int[] A) {
		int missing = 0;

		for (int i = 0; i <= A.length + 1; i++) {
			missing ^= i;
		}
		for (int i = 0; i < A.length; i++) {
			missing ^= A[i];
		}

		return missing;
	}
}
