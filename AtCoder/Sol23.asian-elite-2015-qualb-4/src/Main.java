import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
 
/**
 * This is the solution for problem #4 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-31
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}
 
	private static TreeSet treeSet = new TreeSet();
 
	private void solve() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
 
		permute(str);
		if (treeSet.size() != 0) {
			System.out.println(treeSet.first());
		} else {
			System.out.println("-1");
		}
	}
 
	public static void permute(String s) {
		char[] a = s.toCharArray();
		// sorting array
		Arrays.sort(a);
		int n = a.length;
		int[] p = new int[n];
		int i = 1;
		while (i < n) {
			if (p[i] < i) {
				int j = ((i % 2) == 0) ? 0 : p[i];
				swap(a, i, j);
				if (isPossibleWord(a)) {
					treeSet.add(toString(a));
					break;
				}
				p[i]++;
				i = 1;
			} else {
				p[i] = 0;
				i++;
			}
		}
	}
 
	private static String toString(char[] a) {
		StringBuilder builder = new StringBuilder();
		builder.append(a);
		return builder.toString();
	}
 
	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
 
	private static boolean isPossibleWord(char[] a) {
		if (a.length == 0) {
			return true;
		}
 
		char c = a[0];
		for (int i = 1; i < a.length; i++) {
			if (c == a[i]) {
				return false;
			}
			c = a[i];
		}
		return true;
	}
}