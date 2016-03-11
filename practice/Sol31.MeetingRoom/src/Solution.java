import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/discuss/questions/oj/meeting-rooms
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
	 * all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return
	 * false.
	 */
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(0, 30));
		list.add(new Interval(5, 10));
		list.add(new Interval(15, 20));

		System.out.println("list ");
		for (int i = 0; i < list.size(); i++) {
			list.get(i).print();
		}

		System.out.println("\ncanAttendMeetings " + canAttendMeetings(list));
	}

	public static boolean canAttendMeetings(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return false;

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end > curr.start) {
				return false;
			}
			prev = curr;
		}

		return true;
	}

	public static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval l1, Interval l2) {
			return l1.start - l2.start;
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
