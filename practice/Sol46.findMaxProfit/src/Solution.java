import java.util.Arrays;
import java.util.Comparator;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.18
 Problem : http://www.geeksforgeeks.org/weighted-job-scheduling/
 ==========================================================
 */
public class Solution {
	/*
	 * Given N jobs where every job is represented by following three elements
	 * of it.
	 * 
	 * Start Time Finish Time Profit or Value Associated Find the maximum profit
	 * subset of jobs such that no two jobs in the subset overlap.
	 * 
	 * Example: Input: Number of Jobs n = 4 Job Details {Start Time, Finish
	 * Time, Profit} Job 1: {1, 2, 50} Job 2: {3, 5, 20} Job 3: {6, 19, 100} Job
	 * 4: {2, 100, 200}
	 * 
	 * Output: The maximum profit is 250. We can get the maximum profit by
	 * scheduling jobs 1 and 4. Note that there is longer schedules possible
	 * Jobs 1, 2 and 3 but the profit with this schedule is 20+50+100 which is
	 * less than 250.
	 */
	public static void main(String[] args) {
		Job arr[] = new Job[5];
		arr[3] = new Job(1, 2, 50);
		arr[4] = new Job(3, 4, 50);
		arr[2] = new Job(3, 5, 20);
		arr[1] = new Job(6, 19, 100);
		arr[0] = new Job(4, 100, 200);

		System.out.println("findMaxProfit " + findMaxProfit(arr));
	}

	// The main function that returns the maximum possible
	// profit from given array of jobs
	private static int findMaxProfit(Job arr[]) {
		if (arr == null || arr.length == 0)
			return -1;

		int[] profit = new int[arr.length];

		// Sort the Job array order by finish time
		Arrays.sort(arr, new JobComparator());

		// Initialize profit value
		for (int i = 0; i < arr.length; i++) {
			profit[i] = arr[i].profit;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				// Check whether two jobs could be overlapped
				if (arr[i].start >= arr[j].finish) {
					if (profit[i] < profit[i] + arr[j].profit)
						profit[i] += arr[j].profit;
				}
			}
		}

		System.out.println(Arrays.toString(profit));

		// Find the maximum value in profit array
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < profit.length; i++) {
			if (max < profit[i])
				max = profit[i];
		}

		return max;
	}

	public static class JobComparator implements Comparator<Job> {
		public int compare(Job job1, Job job2) {
			int diff = job1.finish - job2.finish;
			return diff;
		}
	}

	// A job has start time, finish time and profit.
	static class Job {
		int start, finish, profit;
		public Job(int start, int finish, int profit) {
			this.start = start;
			this.finish = finish;
			this.profit = profit;
		}
		public void print() {
			System.out.println("{" + start + "," + finish + "," + profit + "}");
		}
	};
}
