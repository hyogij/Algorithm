package leetCode;

import java.util.ArrayList;
import java.util.Collections;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2016.03.02
Question Number : 169
Link : https://leetcode.com/problems/find-median-from-data-stream/
==========================================================
*/
public class Solution {
	/*
	 * Median is the middle value in an ordered integer list. If the size of the
	 * list is even, there is no middle value. So the median is the mean of the
	 * two middle value. 
	 * 
	 * Examples: 
	 * [2,3,4] , the median is 3 
	 * [2,3], the median is (2 + 3) / 2 = 2.5
	 * [2,3,5] , the median is 3 	
	 *  
	 * Design a data structure that supports the following two operations: 
	 * void addNum(int num) - Add a integer number from the data stream to the
	 * data structure. 
	 * double findMedian() - Return the median of all elements so far. 
	 * 
	 * For example:	  
	 * add(1) 
	 * add(2) 
	 * findMedian() -> 1.5 
	 * add(4) 
	 * findMedian() -> 2
	 */
	public static void main(String[] args) {
		// Your MedianFinder object will be instantiated and called as such:
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(4);
		System.out.println(mf.findMedian());
	}
	
	// Max Heap, Min Heap을 이용한다 
	// 작은 값들 중에 가장 큰 값
	// 큰 값들 중에 가장 작은 값 
	// 1, 10, 90, 200 
	// 1,  10, 
	// 
	// 매번 정렬한다, O(nlogn)
	// 특정 위치를 찾는다, O(logn)
	
	static class MedianFinder {
		private ArrayList<Integer> list = null;

		public MedianFinder() {
			list = new ArrayList<Integer>();
		}

		// Adds a number into the data structure.
		public void addNum(int num) {
			list.add(num);
			Collections.sort(list);
		}

		// Returns the median of current data stream
		public double findMedian() {
			if (list.size() == 0) {
				return -1;
			}

			double median = 0;
			int mid = list.size() / 2;
			if (list.size() % 2 == 0) {
				// even
				median = (list.get(mid) + list.get(mid - 1)) / 2.0;
			} else {
				// odd
				median = list.get(mid);
			}
			return median;
		}
	};
}
