import java.util.HashMap;
import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : https://leetcode.com/problems/longest-consecutive-sequence/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2, 11, 12, 13, 155, 334, 22, 33, 35,
				37, 35, 44, 45, 14, 15, 16};
		System.out.println("longestConsecutive " + longestConsecutive(nums));
		System.out.println("longestConsecutiveUnionFind "
				+ longestConsecutiveUnionFind(nums));
	}

	public static int longestConsecutive(int[] nums) {
		int max = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums)
			set.add(num);
		
		for (int num : nums) {
			int length = 1;
			while (set.contains(num + 1)) {
				length++;
				num++;
			}

			max = Math.max(max, length);
		}
		return max;
	}

	static HashMap<Integer, Node> map = null;
	public static int longestConsecutiveUnionFind(int[] nums) {
		map = new HashMap<Integer, Node>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			map.put(num, new Node(num));
			// Compare n with n-1 and n+1
			if (map.containsKey(num - 1) == true) {
				union(num - 1, num);
			}
			if (map.containsKey(num + 1) == true) {
				union(num + 1, num);
			}
		}

		// Traverse the map and find the longest consecutive elements which have
		// same parent.
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		int count = 0, max = 0;
		for (int num : map.keySet()) {
			int parent = find(num).val;
			if (countMap.containsKey(parent) == true) {
				count = countMap.get(parent) + 1;
			} else {
				count = 1;
			}
			countMap.put(parent, count);
			max = Math.max(max, count);
		}

		return max;
	}

	public static class Node {
		int val;
		Node parent;
		public Node(int val) {
			this.val = val;
			this.parent = this;
		}

		public void print() {
			System.out.println(val + " -> " + parent.val);
		}
	}

	public static Node find(int a) {
		Node node = map.get(a);
		if (node.parent == node)
			return node;
		return find(node.parent.val);
	}

	public static void union(int a, int b) {
		map.get(a).parent = map.get(b).parent;
	}
}