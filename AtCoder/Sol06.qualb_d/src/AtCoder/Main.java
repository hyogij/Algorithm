package AtCoder;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 	
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-25
 * @url http://code-festival-2015-qualb.contest.atcoder.jp/tasks/
 *      codefestival_2015_qualB_d
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long[] S = new long[N];
		long[] C = new long[N];
		for (int i = 0; i < N; i++) {
			S[i] = scanner.nextLong();
			C[i] = scanner.nextLong();
		}
		scanner.close();

		ArrayList<Long> ans = new ArrayList<Long>();
		TreeMap<Long, Long> map = new TreeMap<Long, Long>();
		map.put(0L, 0L);// floorKey
		
		for (int i = 0; i < N; i++) {
			long floorKey = map.floorKey(S[i]);
			if (map.get(floorKey) >= S[i]) {
				S[i] = floorKey;
			}

			long target = S[i] + C[i] - 1;
			
			System.out.println(S[i] + ", " + target);
			System.out.println(" map " + map.toString());
			
			ArrayList<Long> willRemove = new ArrayList<Long>();
			SortedMap<Long, Long> tail = map.tailMap(S[i]);
			System.out.println(" tail " + tail.toString());
			
			for (Map.Entry<Long, Long> entry : tail.entrySet()) {
				long start = entry.getKey();
				long end = entry.getValue();

				if (start <= target) {
					target += end - start + 1;
					willRemove.add(start);
				} else {
					break;
				}
			}

			System.out.println(" willRemove " + willRemove.toString());
			for (long key : willRemove) {
				map.remove(key);
			}
			map.put(S[i], target);
			ans.add(target);
		}
		System.out.println(" map " + map.toString());

		StringBuilder builder = new StringBuilder();
		for (long target : ans) {
			builder.append(target + "\n");
		}
		System.out.print(builder.toString());
	}
}