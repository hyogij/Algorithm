package AtCoder;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-26
 * @url http://code-festival-2015-quala.contest.atcoder.jp/tasks/
 *      codefestival_2015_qualA_b
 */
public class Main {
	/*
	 * 6  92
		31  4
		15  9
		26  5
		35  8
		97  9
		32  3
	 */
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // Number of homework
		int T = scanner.nextInt(); // Remain times

		SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
		int sumOfB = 0;
		for (int i = 0; i < N; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			sumOfB += b;

			sortedMap.put(a, b);
		}
		scanner.close();

		if (sumOfB > T) {
			System.out.println("-1");
			return;
		}

		int remainTime = T, solution = 0;
		for (Entry<Integer, Integer> entry : sortedMap.entrySet()) {
			// Required time when he does himself homework
			int n = entry.getKey(); 
			// Required time when he copies his friend
			int t = entry.getValue(); 
			
			remainTime -= n;
			if(remainTime <0) {
				break;
			}
			solution++;
		}
		
		System.out.println(solution);
		solution--;
		for (int i = solution - 1; i > 0; i--) {
			remainTime = T;
			int j = 0;
			for (Entry<Integer, Integer> entry : sortedMap.entrySet()) {
				// Required time when he does himself homework
				int n = entry.getKey(); 
				// Required time when he copies his friend
				int t = entry.getValue(); 

				if (j < i) {
					remainTime -= n;
				} else {
					remainTime -= t;
				}
				j++;
			}

			if (remainTime >= 0 && i > solution) {
				solution = i;
			}
		}

		System.out.println(solution);
	}
}