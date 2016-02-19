package leetCode;

import java.util.HashSet;
import java.util.Iterator;

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
		// trie.insert("key");
		// System.out.println(trie.search("key"));
		// System.out.println(trie.search("kei"));
		// System.out.println(trie.startsWith("ke"));
		// System.out.println(trie.startsWith("k"));
		// System.out.println(trie.startsWith("y"));

		// trie.insert("a");
		// System.out.println(trie.search("a"));
		// System.out.println(trie.search("ab"));
		// System.out.println(trie.startsWith("a"));

		// insert("abc");
		// search("abc");
		// search("ab");
		// insert("ab");
		// search("ab");
		// insert("ab");
		// search("ab");
	}

	static class TrieNode {
		private char data = ' ';
		private HashSet<TrieNode> child = null;

		// Initialize your data structure here.
		public TrieNode(char data) {
			this.data = data;
			child = new HashSet<TrieNode>();
		}

		public HashSet<TrieNode> getChild() {
			return child;
		}

		public void addChild(TrieNode node) {
			child.add(node);
		}

		public char getData() {
			return data;
		}

		// TODO : hashCode?
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode(' ');
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode head = root;
			HashSet<TrieNode> child = null;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				child = head.getChild();
				TrieNode node = getNode(child, c);
				if (node == null) {
					// Make new node and insert it into child list
					node = new TrieNode(c);
					head.addChild(node);
				}
				// Set current node
				head = node;
			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			if (root.getChild().size() == 0) {
				return false;
			}

			TrieNode head = root;
			HashSet<TrieNode> child = null;

			int i = 0;
			TrieNode node = null;
			for (; i < word.length(); i++) {
				char c = word.charAt(i);
				child = head.getChild();
				node = getNode(child, c);

				if (node == null) {
					return false;
				}
				// Set current node
				head = node;
			}

			System.out.println(head.getData() + " / " + head.getChild().size());
			if (head.getChild().size() > 0) {
				return false;
			}
			return true;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if (root.getChild().size() == 0) {
				return false;
			}

			TrieNode head = root;
			HashSet<TrieNode> child = null;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				child = head.getChild();
				TrieNode node = getNode(child, c);
				if (node == null) {
					return false;
				}
				// Set current node
				head = node;
			}
			return true;
		}

		private TrieNode getNode(HashSet<TrieNode> set, char c) {
			Iterator<TrieNode> iterator = set.iterator();

			// check values
			while (iterator.hasNext()) {
				TrieNode node = (TrieNode) iterator.next();
				if (node.getData() == c) {
					return node;
				}
			}
			return null;
		}
	}
}
