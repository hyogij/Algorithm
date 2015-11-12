import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.12
 Problem : Find the anagrams in given string and print strings order by lexicographical
 ==========================================================
 */
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		HashMap<String, ArrayList<String>> anagrams = new HashMap<String, ArrayList<String>>();
		TreeMap<String, ArrayList<String>> orderAnagrams = new TreeMap<String, ArrayList<String>>();
		ArrayList<String> list = null;

		// Run until user type ctrl + d
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			// Replace spaces to empty string and make characters array
			char[] word = str.replaceAll("[\\s]", "").toCharArray();
			Arrays.sort(word);

			String anagram = String.valueOf(word);
			if (anagrams.containsKey(anagram)) {
				list = anagrams.get(anagram);
				boolean isAdded = false;

				// Insert new string to the list order by lexicographical
				for (int i = 0; i < list.size(); i++) {
					String current = list.get(i);
					if (str.compareTo(current) <= 0) {
						list.add(i, str);
						isAdded = true;
						break;
					}
				}

				if (isAdded == false) {
					list.add(str);
				}
			} else {
				list = new ArrayList<String>();
				list.add(str);
				anagrams.put(anagram, list);
			}
		}
		scanner.close();

		// Copy to the TreeMap to sort lexicographically
		for (Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
			String key = entry.getKey();
			list = anagrams.get(key);
			orderAnagrams.put(list.get(0), list);
		}

		// Print the TreeMap contents
		for (String key : orderAnagrams.keySet()) {
			list = orderAnagrams.get(key);
			for (int j = 0; j < list.size(); j++) {
				if (j != 0) {
					System.out.print(",");
				}
				System.out.print(list.get(j));
			}
			System.out.println();
		}
	}
}
