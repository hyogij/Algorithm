import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
	/*
	 * Returns a character which is nth most frequency in input string
	 */
	public static void main(String[] args) {
		String string = "Hello world";
		System.out.println("getIndex " + getIndex(string, 0));
		System.out.println("getIndex " + getIndex(string, 1));
		System.out.println("getIndex " + getIndex(string, 2));
	}

	public static char getIndex(String string, int nth) {
		string = string.toLowerCase();
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			int count = 1;
			if (hashMap.containsKey(c)) {
				count = hashMap.get(c) + 1;
			}
			hashMap.put(c, count);
		}

		// Sort hashMap order by value
		TreeMap<Character, Integer> sortedMap = SortByValue(hashMap);
		System.out.println(sortedMap);

		// Return nth character
		return (Character) sortedMap.keySet().toArray()[nth];
	}

	public static TreeMap<Character, Integer> SortByValue(
			HashMap<Character, Integer> map) {
		ValueComparator vc = new ValueComparator(map);
		TreeMap<Character, Integer> sortedMap = new TreeMap<Character, Integer>(
				vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
}

class ValueComparator implements Comparator<Character> {
	Map<Character, Integer> map;

	public ValueComparator(Map<Character, Integer> base) {
		this.map = base;
	}

	@Override
	public int compare(Character a, Character b) {
		if (map.get(a) >= map.get(b)) {
			return -1;
		} else {
			return 1;
		}
	}
}
