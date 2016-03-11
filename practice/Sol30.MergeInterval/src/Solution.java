import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/problems/merge-intervals/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 */
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		// list.add(new Interval(1, 3));
		// list.add(new Interval(2, 6));
		// list.add(new Interval(8, 10));
		// list.add(new Interval(15, 18));

		// [[1,4],[0,1]]
		// [[1,4],[0,0]]
		// [[2,3],[4,5],[6,7],[8,9],[1,10]] --> [[2,3],[4,5],[6,7],[1,10]]
		list.add(new Interval(2, 3));
		list.add(new Interval(4, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(8, 9));
		list.add(new Interval(1, 10));

		List<Interval> merged = merge(list);
		System.out.println(merged.size());
		for (int i = 0; i < merged.size(); i++) {
			merged.get(i).print();
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> list = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0)
			return list;

		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());

		Interval prevInterval = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (prevInterval.end < interval.start) {
				list.add(prevInterval);
				prevInterval = interval;
			} else {
				prevInterval.start = Math.min(prevInterval.start,
						interval.start);
				prevInterval.end = Math.max(prevInterval.end, interval.end);
			}
		}
		list.add(prevInterval);

		return list;
	}

	static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	public static class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public void print() {
			System.out.print(" [" + start + "," + end + "] ");
		}
	}

}
