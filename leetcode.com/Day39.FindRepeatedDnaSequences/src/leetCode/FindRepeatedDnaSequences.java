package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.15
 Question Number : 147
 Link : https://leetcode.com/problems/repeated-dna-sequences/
 ==========================================================
 */

public class FindRepeatedDnaSequences {
	/*
	 * All DNA is composed of a series of nucleotides abbreviated as A, C, G,
	 * and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes
	 * useful to identify repeated sequences within the DNA.
	 * 
	 * Write a function to find all the 10-letter-long sequences (substrings)
	 * that occur more than once in a DNA molecule.
	 * 
	 * For example,
	 * 
	 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
	 * 
	 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
	 */

	private static final int MAX_LENGTH_OF_SEQUENCES = 10;

	public static void main(String[] args) {
		// String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s = "GATGGATACTGCATTCGAACCAGAGCCGGCTTTTGCG";
		List<String> sequences = findRepeatedDnaSequences(s);
		System.out.println(sequences.toString());
	}

	public static List<String> findRepeatedDnaSequencesBasic(String s) {
		List<String> sequences = new ArrayList<String>();

		// 1) Set a candidate 10-letter-long sequences
		// 2) Find it in the remained DNA
		// 3) Repeat above procedure
		// Analysis : Time complexity is O(n^2)
		for (int i = 0; i < s.length() - MAX_LENGTH_OF_SEQUENCES; i++) {
			String candidate = s.substring(i, i + MAX_LENGTH_OF_SEQUENCES);
			for (int j = i + MAX_LENGTH_OF_SEQUENCES; j < s.length()
					- MAX_LENGTH_OF_SEQUENCES; j++) {
				if (candidate.equals(s
						.substring(j, j + MAX_LENGTH_OF_SEQUENCES))) {
					sequences.add(candidate);
					break;
				}
			}
		}
		return sequences;
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> sequences = new ArrayList<String>();

		// 1) Get a candidate 10-letter-long sequences in dna
		// 2) Generate the unique id of candidate
		// 3) Check the hashset whether this unique id is already existed
		// Analysis : Time complexity is O(n)
		Set<Integer> sets = new HashSet<Integer>();
		for (int i = 0; i <= s.length() - MAX_LENGTH_OF_SEQUENCES; i++) {
			String candidate = s.substring(i, i + MAX_LENGTH_OF_SEQUENCES);
			int hash = getUniqueId(candidate);
			if (sets.contains(hash) == true
					&& sequences.contains(candidate) == false) {
				sequences.add(candidate);
			} else {
				sets.add(hash);
			}
		}
		return sequences;
	}

	// Generate unique id using nucleotides abbreviated as A, C, G, and T
	public static int getUniqueId(String sequences) {
		int id = 0;
		// Each nucleotides represent 2 bits such as A(00), C(01), G(10) and
		// T(11)
		for (int i = 0; i < sequences.length(); i++) {
			id <<= 2; // Shift 2 byte to right
			char c = sequences.charAt(i);
			switch (c) {
				case 'A' :
					id |= 0;
					break;
				case 'C' :
					id |= 1;
					break;
				case 'G' :
					id |= 2;
					break;
				case 'T' :
					id |= 3;
					break;
			}
		}
		return id;
	}
}