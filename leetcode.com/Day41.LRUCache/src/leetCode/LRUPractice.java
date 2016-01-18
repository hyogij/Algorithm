package leetCode;

import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.21
 Question Number : 151
 Link : https://leetcode.com/problems/lru-cache/
 ==========================================================
 */

public class LRUPractice {
	/*
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. 
	 * set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */
	public static void main(String[] args) {
		// 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
		LRUCache lru = new LRUCache(10);
		lru.set(1, 1);
		lru.set(2, 1);
		System.out.println("get(1) " + lru.get(1));
		System.out.println("get(2) " + lru.get(2));
		lru.set(3, 2);
		lru.set(4, 2);
		lru.set(5, 2);
		lru.set(6, 2);
		lru.set(7, 2);
		lru.set(8, 2);
		lru.set(9, 2);
		lru.set(10, 2);

		lru.printLRU();
		System.out.println("get(2) " + lru.get(1));
		System.out.println("get(3) " + lru.get(2));

		lru.set(11, 2);
		lru.set(12, 2);
		lru.set(7, 2);

		lru.printLRU();
		System.out.println("get(2) " + lru.get(1));
		System.out.println("get(3) " + lru.get(2));
	}

	// i) Implement the LRU using single linked list : O(n)
	// Last one is recently used element and first one is least recently used
	// element.

	public static class LRUCache {
		private int capacity = 0;
		ArrayList<Node> list = null;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			list = new ArrayList<Node>(capacity);
		}

		public void printLRU() {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).printNode();
			}
		}

		// If element is hitted in the LRU cache, then moves it to the end
		public int get(int key) {
			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);
				if (node.key == key) {
					list.remove(i);
					list.add(node);
					return node.value;
				}
			}

			// The key doesn't exist in the cache
			return -1;
		}

		/*
		 * Set or insert the value if the key is not already present. When the
		 * cache reached its capacity, it should invalidate the least recently
		 * used item before inserting a new item.
		 */
		public void set(int key, int value) {
			// Find the key in the cache
			int index = 0;
			for (; index < list.size(); index++) {
				if (list.get(index).key == key) {
					break;
				}
			}
			
			Node node = new Node(key, value);

			if (index < list.size()) {
				list.remove(index);
			} else {
				// When the cache reached its capacity, invalidate the least
				// recently used item
				if (index == capacity) {
					list.remove(0);
				}
			}

			// Add the new node to the end of cache
			list.add(node);
		}
	}

	public static class Node {
		public int key = 0;
		public int value = 0;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public void printNode() {
			System.out.println("(" + key + ", " + value + ")");
		}
	}
}
