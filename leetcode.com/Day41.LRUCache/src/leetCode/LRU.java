package leetCode;

import java.util.HashMap;
import java.util.LinkedList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.21
 Question Number : 151
 Link : https://leetcode.com/problems/lru-cache/
 ==========================================================
 */

public class LRU {
	/*
	 * Design and implement a data structure for Least Recently Used (LRU)
	 * cache. It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key
	 * exists in the cache, otherwise return -1. 
	 * set(key, value) - Set or insert the value if the key is not already present. 
	 * When the cache reached its capacity, it should invalidate the least recently 
	 * used item before inserting a new item.
	 */
	public static void main(String[] args) {
		// 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
		LRUCache lru = new LRUCache(10);
		lru.set(2, 1);
		lru.printLinkedList();
		System.out.println("get(1) " + lru.get(1));
		System.out.println("get(2) " + lru.get(2));
		lru.printLinkedList();
		lru.set(3, 2);
		lru.set(4, 2);
		lru.set(5, 2);
		lru.set(6, 2);
		lru.set(7, 2);
		lru.printLinkedList();
		System.out.println("get(2) " + lru.get(2));
		lru.printLinkedList();
		System.out.println("get(3) " + lru.get(3));
		lru.printLinkedList();
	}
	
	// Use a double linked list and hash map
	static class LRUCache {
		HashMap<Integer, Node> map = null;
		Node head = null;
		Node tail = null;
		int capacity = 0;

		public LRUCache(int capacity) {
			map = new HashMap<Integer, Node>();
			this.capacity = capacity;
		}

		public int get(int key) {
			int value = -1;
			if (map.containsKey(key) == true) {
				Node node = map.get(key);
				remove(node);
				setHead(node);
				value = node.getValue();
			}
			return value;
		}

		public void set(int key, int value) {
			Node node = new Node(key, value);
			// The node is already existed in the linked list
			if (map.containsKey(key) == true) {
				map.put(key, node);
				remove(node);
				setHead(node);
				return;
			} else {
				// If capacity is already full, then remove the least recently
				// used item, then add new node
				if (map.size() == capacity) {
					map.remove(tail.getKey());
					removeTail();
				}
				map.put(key, node);
				setHead(node);
			}
		}

		// Set the target to the head node from the double linked list
		private void setHead(Node node) {
			if (head != null) {
				head.prev = node;
				node.next = head;
			}
			head = node;
			
			if(tail == null) {
				tail = head;
			}
		}

		// Remove the target node from the double linked list
		private void remove(Node node) {
			if(node.prev!=null){
				node.prev.next = node.next;
	        }else{
	            head = node.next;
	        }
	 
	        if(node.next!=null){
	        	node.next.prev = node.prev;
	        }else{
	            tail = node.prev;
	        }
		}

		// Remove tail node from the double linked list
		private void removeTail() {
			if(tail == head) {
				head = tail = null;
			} else if(tail != null) {
				Node tmp = tail;
				tail.prev.next = null;
				tail = tail.prev;
				tmp = null;
			} 
		}
		
		private void printLinkedList() {
			System.out.print("LinkedList : ");
			for(Node tmp = head; tmp != null; tmp = tmp.next) {
				System.out.print(tmp.toString() + " ");
				
				if(head == tail) {
					break;
				}
			}
			System.out.println();
		}
	}

	// Use a single linked list, its time complexity is O(n)
	class LRUCacheLinkedList {
		LinkedList<Node> linkedList = null;
		int capacity = 0;

		public LRUCacheLinkedList(int capacity) {
			linkedList = new LinkedList<Node>();
			this.capacity = capacity;
		}

		public int get(int key) {
			int value = -1;
			for (int i = 0; i < linkedList.size(); i++) {
				Node node = linkedList.get(i);
				if (node.getKey() == key) {
					value = node.getValue();
					moveToFirstList(i);
					break;
				}
			}

			return value;
		}

		public void set(int key, int value) {
			Node node = new Node(key, value);
			// The node is already existed in the linked list
			if (linkedList.contains(node) == true) {
				moveToFirstList(linkedList.indexOf(node));
				return;
			} else {
				// If capacity is already full, then remove the least recently
				// used item, then add new node
				if (linkedList.size() == capacity) {
					linkedList.remove(linkedList.size() - 1);
				}
				linkedList.add(0, node);
			}
		}

		// Move the node to the first index of the linked list
		private void moveToFirstList(int index) {
			Node node = linkedList.remove(index);
			linkedList.add(0, node);
		}
	}

	static class Node {
		private int key = 0;
		private int value = 0;
		public Node prev = null;
		public Node next = null;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
		
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}
}