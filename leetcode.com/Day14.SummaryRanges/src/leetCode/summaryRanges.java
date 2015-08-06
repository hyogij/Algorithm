package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.05
 Question Number : 61
 Link : https://leetcode.com/problems/summary-ranges/
 ==========================================================
 */

public class summaryRanges {
	/*
	 * Given a sorted integer array without duplicates, return the summary of
	 * its ranges.
	 * 
	 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	 */
	public static void main(String[] args) {
		int[] nums = {0};
		List<String> summary = summaryRanges(nums);
		System.out.println(" " + summary.toString());
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> summary = new ArrayList();

		if (nums.length < 1) {
			return summary;
		}

		int start, end, prev;
		end = prev = start = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (prev + 1 != nums[i]) {
				end = prev;
				if (start == end) {
					summary.add(String.valueOf(start));
				} else {
					summary.add(appendNumbers(start, end));
				}
				start = nums[i];
			}
			prev = nums[i];
		}

		// TODO(hyogij): Modify codes for readability
		if (start >= end) {
			if (start == prev || prev == end) {
				summary.add(String.valueOf(start));
			} else {
				summary.add(appendNumbers(start, prev));
			}
		} else {
			summary.add(String.valueOf(start));
		}

		return summary;
	}

	public static String appendNumbers(int start, int end) {
		final String RANGE_TAG = "->";

		StringBuffer buffer = new StringBuffer();
		buffer.append(start);
		buffer.append(RANGE_TAG);
		buffer.append(end);

		return buffer.toString();
	}
}
