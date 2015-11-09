package HackerRank;

import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.09
 Question Number : 1
 Link : https://www.hackerrank.com/challenges/tree-top-view
 ==========================================================
 */
public class TopView {
	/*
	 * Problem Statement
	 * 
	 * You are given a pointer to the root of a binary tree. Print the top view
	 * of the binary tree. You only have to complete the function. For example :
	 * 
	 * 		 3 
	 * 		/ \ 
	 *    5   2
	 *   / \ / \ 
	 *  1 4 6 7 
	 *  	\	/ 
	 *  	9  8 
	 * Top View : 1 -> 5 -> 3 -> 2 -> 7
	 */
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.right = new Node(9);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		
//		print_tree(root);
		top_view(root);
	}

	private static void print_tree(Node root) {
		if(root != null) {
			System.out.println(root.data);
			
			print_tree(root.left);
			print_tree(root.right);
		}
	}
	
	private static void top_view(Node root) {
		ArrayList<Integer> topViewList = new ArrayList<Integer>();
		if (root != null) {
			// print left children
			printLeftChildren(root.left, topViewList);

			// print root node
			topViewList.add(root.data);

			// print right children
			printRightChildren(root.right, topViewList);
		}

		// print top view list
		for (int i = 0; i < topViewList.size(); i++) {
			int data = topViewList.get(i);
			System.out.print(data);
			if (i != topViewList.size() - 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
	}

	private static void printLeftChildren(Node root,
			ArrayList<Integer> topViewList) {
		if (root.left != null) {
			printLeftChildren(root.left, topViewList);
			topViewList.add(root.data);
		} else {
			topViewList.add(root.data);
		}
	}

	private static void printRightChildren(Node root,
			ArrayList<Integer> topViewList) {
		if (root.right != null) {
			topViewList.add(root.data);
			printRightChildren(root.right, topViewList);
		} else {
			topViewList.add(root.data);
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}