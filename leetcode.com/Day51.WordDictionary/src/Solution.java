import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.19
 Question Number : 166
 Link : https://leetcode.com/problems/add-and-search-word-data-structure-design/
 ==========================================================
 */
public class Solution {
	/*
	 * Design a data structure that supports the following two operations:
	 * 
	 * void addWord(word) bool search(word) search(word) can search a literal
	 * word or a regular expression string containing only letters a-z or .. A .
	 * means it can represent any one letter.
	 * 
	 * For example:
	 * 
	 * addWord("bad") 
	 * addWord("dad") 
	 * addWord("mad") 
	 * search("pad") -> false
	 * search("bad") -> true 
	 * search(".ad") -> true 
	 * search("b..") -> true
	 * 
	 * Note: You may assume that all words are consist of lowercase letters a-z.
	 * This problem is related with abbreviation question.
	 */
	public static void main(String[] args) {
		// Your WordDictionary object will be instantiated and called as such:
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));
		System.out.println(wordDictionary.search("bb."));
		System.out.println(wordDictionary.search("ba."));
	}
	
	public static class WordDictionary {
		public static class TrieNode {
			public char data;
			public boolean isLeaf = false;
			public HashMap<Character, TrieNode> children = null;
			// Initialize your data structure here.
			public TrieNode() {
				children = new HashMap<Character, TrieNode>();
			}

			public TrieNode(char data) {
				this.data = data;
				children = new HashMap<Character, TrieNode>();
			}
		}
		
		private TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void addWord(String word) {
			HashMap<Character, TrieNode> children = null;
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				children = node.children;
				if (children.containsKey(c)) {
					node = children.get(c);
				} else {
					node = new TrieNode(c);
					children.put(c, node);
				}

				if (i == word.length() - 1) {
					node.isLeaf = true;
				}
			}
		}

		// Returns if the word is in the data structure. A word could contain
		// the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return searchHelper(word, 0, root);
		}

		public boolean searchHelper(String word, int index, TrieNode node) {
			if(index == word.length())  {
				if(node.isLeaf == true) {
					return true;
				} else {
					return false;
				}
			}
			
			char c = word.charAt(index);
			HashMap<Character, TrieNode> children = node.children;
			if(c != '.') {
				if(children.containsKey(c) == false) {
					return false;
				} else {
					node = children.get(c);
					return searchHelper(word, index + 1, node);
				}
			} else {
				boolean isFound = false;
				for( Character key : children.keySet() ){
					isFound |= searchHelper(word, index + 1, children.get(key));
		        }
				return isFound;
			}
		}
	}
}