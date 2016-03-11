import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/problems/insert-interval/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to
	 * their start times.
	 * 
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	 * in as [1,2],[3,10],[12,16].
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 */
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 2));
		list.add(new Interval(3, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(8, 10));
		list.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);

		List<Interval> merged = insert(list, newInterval);
		System.out.println(merged.size());
		for (int i = 0; i < merged.size(); i++) {
			merged.get(i).print();
		}
	}

	public static List<Interval> insert(List<Interval> intervals,
			Interval newInterval) {
		List<Interval> list = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				list.add(interval);
			} else if (interval.start > newInterval.end) {
				list.add(newInterval);
				newInterval = interval;
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		list.add(newInterval);

		return list;
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
