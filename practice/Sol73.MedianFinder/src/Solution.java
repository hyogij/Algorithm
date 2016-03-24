import java.util.Comparator;
import java.util.PriorityQueue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.24
 Problem : https://leetcode.com/problems/find-median-from-data-stream/
 ==========================================================
 */
public class Solution {
	/*
	 * Median is the middle value in an ordered integer list. If the size of the
	 * list is even, there is no middle value. So the median is the mean of the
	 * two middle value.
	 * 
	 * Examples: [2,3,4] , the median is 3
	 * 
	 * [2,3], the median is (2 + 3) / 2 = 2.5
	 * 
	 * Design a data structure that supports the following two operations:
	 * 
	 * void addNum(int num) - Add a integer number from the data stream to the
	 * data structure. double findMedian() - Return the median of all elements
	 * so far. For example:
	 * 
	 * add(1) add(2) findMedian() -> 1.5 add(3) findMedian() -> 2
	 */
	public static void main(String[] args) {
		// Your MedianFinder object will be instantiated and called as such:
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		System.out.println("findMedian " + mf.findMedian());
		mf.addNum(2);
		System.out.println("findMedian " + mf.findMedian());
		mf.addNum(3);
		System.out.println("findMedian " + mf.findMedian());
		mf.addNum(4);
		System.out.println("findMedian " + mf.findMedian());
		mf.addNum(5);
		System.out.println("findMedian " + mf.findMedian());
	}

	static class MedianFinder {
		PriorityQueue<Integer> maxHeap = null;
		PriorityQueue<Integer> minHeap = null;

		public MedianFinder() {
			minHeap = new PriorityQueue<Integer>();
			maxHeap = new PriorityQueue<Integer>(50, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}

		// Adds a number into the data structure.
		public void addNum(int num) {
			if (maxHeap.isEmpty() == true) {
				maxHeap.add(num);
				return;
			}

			int num1 = maxHeap.peek();
			if (num < num1) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}

			// Keep the size of max heap is always greater than the size of min
			// heap
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			}

			if (minHeap.size() - maxHeap.size() >= 1) {
				maxHeap.add(minHeap.poll());
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if (maxHeap.size() == 0)
				return 0;

			// Check the total number of elements in two heaps to calculate
			// median value
			int num1 = maxHeap.peek();
			double median = 0;
			if (maxHeap.size() == minHeap.size()) {
				int num2 = minHeap.peek();
				median = (num1 + num2) / 2.0;
			} else {
				median = num1;
			}

			return median;
		}
	};

}
