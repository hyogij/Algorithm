import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/discuss/questions/oj/meeting-rooms-ii
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1], [s2,e2],...] (si < ei), find the minimum number of
	 * conference rooms required. For example, Given [[0, 30],[5, 10],[15, 20]],
	 * return 2.
	 */
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(0, 1));
		list.add(new Interval(0, 3));
		list.add(new Interval(0, 2));
		list.add(new Interval(5, 10));
		list.add(new Interval(15, 20));

		System.out.println("list ");
		for (int i = 0; i < list.size(); i++) {
			list.get(i).print();
		}

		System.out.println("\nminMeetingRooms " + minMeetingRooms(list));
	}

	public static int minMeetingRooms(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return -1;

		int max = Integer.MIN_VALUE;
		// Sort interval list order by start time
		Collections.sort(intervals, new IntervalComparatorStart());

		// TreeSet to store intervals order by end time
		TreeSet<Interval> set = new TreeSet<Interval>(
				new IntervalComparatorEnd());
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			while (set.isEmpty() != true) {
				Interval head = set.first();
				if (head.end < interval.start) {
					set.remove(head);
				} else {
					break;
				}
			}
			set.add(interval);
			printTreeSet(set);

			if (max < set.size())
				max = set.size();
		}

		return max;
	}

	public int minMeetingRooms(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] < ends[endsItr])
				rooms++;
			else
				endsItr++;
		}
		return rooms;
	}

	public static void printTreeSet(TreeSet<Interval> set) {
		Iterator<Interval> iterator = set.iterator();
		System.out.print("Tree set data: ");

		// Displaying the Tree set data
		while (iterator.hasNext()) {
			Interval interval = iterator.next();
			interval.print();
		}
		System.out.println();
	}

	public static class IntervalComparatorStart implements Comparator<Interval> {
		public int compare(Interval l1, Interval l2) {
			return l1.start - l2.start;
		}
	}

	public static class IntervalComparatorEnd implements Comparator<Interval> {
		public int compare(Interval l1, Interval l2) {
			return l1.end - l2.end;
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
