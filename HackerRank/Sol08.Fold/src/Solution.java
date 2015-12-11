import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		List<Integer> data1 = Arrays.asList(1, 4, 7);
		List<Integer> data2 = Arrays.asList(123, -2, 477, 3, 14, 6551);

		Solution obj = new Solution();

		int result = obj.fold(data1);
		System.out.println(result);

		int yourAnswer = obj.fold(data2);
		System.out.println(yourAnswer);
	}

	private int fold(List<Integer> input) {
		// Error cases : Return 0, if the list is null or empty.
		if (input == null || input.size() == 0) {
			return 0;
		}

		// Base case : Return first value in list, if the list size is 1.
		if (input.size() == 1) {
			return input.get(0);
		}

		// Create a new list to store new integers
		List<Integer> newList = new ArrayList<Integer>();
		int first = input.get(0);
		for (int i = 1; i < input.size(); i++) {
			newList.add(first + input.get(i));
		}

		return fold(newList);
	}

}
