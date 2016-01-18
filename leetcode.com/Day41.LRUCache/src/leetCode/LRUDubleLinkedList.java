package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.21
 Question Number : 151
 Link : https://leetcode.com/problems/lru-cache/
 ==========================================================
 */

public class LRUDubleLinkedList {
	/*
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. set(key, value) - Set or insert
	 * the value if the key is not already present. When the cache reached its
	 * capacity, it should invalidate the least recently used item before
	 * inserting a new item.
	 */
	public static void main(String[] args) {
		// 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
		LRUCacheMap lru = new LRUCacheMap(10);
		lru.set(1, 1);
		lru.printLRU();
		lru.set(1, 2);
		lru.printLRU();
		lru.set(1, 3);
		lru.printLRU();

	}

	/*
	 * The LRU cache is a hash table of keys and double linked nodes. The hash
	 * table makes the time of get() to be O(1). The list of double linked nodes
	 * make the nodes adding/removal operations O(1).
	 */
	public static class LRUCacheMap {
		int capacity;
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		Node head = null;
		Node end = null;

		public LRUCacheMap(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Node n = map.get(key);
				remove(n);
				setHead(n);
				return n.value;
			}

			return -1;
		}

		public void remove(Node n) {
			if (n.pre != null) {
				n.pre.next = n.next;
			} else {
				head = n.next;
			}

			if (n.next != null) {
				n.next.pre = n.pre;
			} else {
				end = n.pre;
			}
		}

		public void setHead(Node n) {
			n.next = head;
			n.pre = null;

			if (head != null)
				head.pre = n;

			head = n;

			if (end == null)
				end = head;
		}

		public void set(int key, int value) {
			if (map.containsKey(key)) {
				Node old = map.get(key);
				old.value = value;
				// remove(old);
				// setHead(old);
			} else {
				Node created = new Node(key, value);
				if (map.size() >= capacity) {
					map.remove(end.key);
					remove(end);
				}
				setHead(created);
				map.put(key, created);
			}
		}
		
		public void printLRU() {
			System.out.print("printLRU : ");
			Node node = head;
			while (node != null) {
				node.printNode();
				node = node.next;
			}
			System.out.println();
		}
	}

	static class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public void printNode() {
			System.out.print(" (" + key + " , " + value + ") ");
		}
	}
}
