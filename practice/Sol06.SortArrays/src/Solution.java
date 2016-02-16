import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.16
 Link : http://www.geeksforgeeks.org/merge-k-sorted-arrays/
 http://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/
 ==========================================================
 */
public class Solution {
	/*
	 * Given k sorted arrays of size n each, merge them and print the sorted
	 * output.
	 */
	public static void main(String[] args) {
		int[][] arr = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
		ArrayList<Integer> sorted = mergeKArrays(arr);
		System.out.println(sorted.toString());
	}

	public static ArrayList<Integer> mergeKArrays(int[][] arr) {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		PriorityQueue<DataContainer> heap = new PriorityQueue<DataContainer>();

		// Indexes for each rows
		int[] index = new int[arr.length];

		// Insert each rows' first value to Min-Heap
		for (int i = 0; i < arr.length; i++) {
			heap.add(new DataContainer(arr[i][index[i]++], i));
		}

		while (heap.isEmpty() != true) {
			// printPriorityQueue(heap);

			DataContainer minData = heap.poll();
			sorted.add(minData.value);

			// If index reaches the last value of row, then stops adding value
			// into the Min-Heap.
			if (index[minData.index] + 1 < arr[minData.index].length) {
				heap.add(new DataContainer(
						arr[minData.index][index[minData.index]++],
						minData.index));
			}
		}

		return sorted;
	}

	private static void printPriorityQueue(
			PriorityQueue<DataContainer> priorityQueue) {
		// create iterator from the queue
		Iterator<DataContainer> it = priorityQueue.iterator();

		while (it.hasNext()) {
			System.out.print(((DataContainer) it.next()).toString());
		}
		System.out.println();
	}

	static class DataContainer implements Comparable<DataContainer> {
		public int value;
		public int index;

		public DataContainer(int value, int index) {
			this.value = value;
			this.index = index;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(value);
			sb.append("/");
			sb.append(index);
			sb.append("] ");
			return sb.toString();
		}

		@Override
		public int compareTo(DataContainer o) {
			if (this.value > o.value) {
				return 1;
			} else if (this.value < o.value) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
