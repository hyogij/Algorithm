package leetCode;

import java.util.HashMap;
import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.19
 Question Number : 166
 Link : https://leetcode.com/problems/implement-trie-prefix-tree/
 http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 ==========================================================
 */
public class Solution {
	/*
	 * Implement a trie with insert, search, and startsWith methods.
	 * 
	 * Note: You may assume that all inputs are consist of lowercase letters
	 * a-z.
	 * 
	 * Subscribe to see which companies asked this question
	 */
	public static void main(String[] args) {
		// Your Trie object will be instantiated and called as such:
		Trie trie = new Trie();
		trie.insert("key");
		trie.insert("ke");
		System.out.println(trie.search("key"));
		System.out.println(trie.search("ke"));
		System.out.println(trie.search("kei"));
		System.out.println(trie.startsWith("ke"));
		System.out.println(trie.startsWith("k"));
		System.out.println(trie.startsWith("y"));
	}

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

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
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

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode node = searchNode(word);
			if (node != null && node.isLeaf == true) {
				return true;
			} else {
				return false;
			}
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode node = searchNode(prefix);
			if (node != null) {
				return true;
			} else {
				return false;
			}
		}

		public TrieNode searchNode(String word) {
			HashMap<Character, TrieNode> children = null;
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				children = node.children;
				if (children.containsKey(c)) {
					node = children.get(c);
				} else {
					return null;
				}
			}
			return node;
		}
	}
}
