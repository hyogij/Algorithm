package leetCode;

import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.05
 Question Number : 56
 Link : https://leetcode.com/problems/max-points-on-a-line/
 ==========================================================
 */

public class maxPoints {
	/*
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 */

	public static void main(String[] args) {
	}

	public static int maxPoints(Point[] points) {
		// Stores straight line' equation such as slope and y-intercept
		HashMap<Line, Integer> hash = new HashMap<Line, Integer>();

		if (points.length <= 1) {
			return points.length;
		}

		for (int i = 0; i < points.length - 1; i++) {
			Point p1 = points[i];
			for (int j = 0; j < points.length; j++) {
				Point p2 = points[j];

				// TODO(hyogij): 두 점이 동일한 경우, 두 점이 평행한 경우
				double slope = getSlope(p1, p2);
				double yIntercept = getyIntercept(p1, slope);
				Line line = new Line(slope, yIntercept);

				if (hash.containsKey(line) == true) {
					int count = hash.get(line);
					hash.put(line, count++);
				} else {
					hash.put(line, 0);
				}
			}
		}

		int max = 0;
		// Finds a max occurrence line in HashMap
		for (Integer value : hash.values()) {
			if (value < max) {
				max = value;
			}
		}

		return max;
	}

	public static double getSlope(Point a, Point b) {
		int divisor = a.y - b.y;
		if (divisor == 0) {
			return 0;
		} else {
			return (a.x - b.x) / divisor;
		}
	}

	public static double getyIntercept(Point a, double slope) {
		return a.y - a.x * slope;
	}

	public static class Line {
		double a;
		double b;
		Line() {
			a = 0;
			b = 0;
		}
		Line(double a, double b) {
			this.a = a;
			this.b = b;
		}
	};

	public static class Point {
		int x;
		int y;
		Point() {
			x = 0;
			y = 0;
		}
		Point(int a, int b) {
			x = a;
			y = b;
		}
	};
}
