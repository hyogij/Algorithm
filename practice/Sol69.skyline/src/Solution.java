import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : https://leetcode.com/problems/the-skyline-problem/
 ==========================================================
 */
public class Solution {
	/*
	 * A city's skyline is the outer contour of the silhouette formed by all the
	 * buildings in that city when viewed from a distance. Now suppose you are
	 * given the locations and height of all the buildings as shown on a
	 * cityscape photo (Figure A), write a program to output the skyline formed
	 * by these buildings collectively (Figure B).
	 * 
	 * Buildings Skyline Contour The geometric information of each building is
	 * represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
	 * the x coordinates of the left and right edge of the ith building,
	 * respectively, and Hi is its height. It is guaranteed that 0 ¡Â Li, Ri ¡Â
	 * INT_MAX, 0 < Hi ¡Â INT_MAX, and Ri - Li > 0. You may assume all buildings
	 * are perfect rectangles grounded on an absolutely flat surface at height
	 * 0.
	 * 
	 * For instance, the dimensions of all buildings in Figure A are recorded
	 * as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
	 * 
	 * The output is a list of "key points" (red dots in Figure B) in the format
	 * of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
	 * A key point is the left endpoint of a horizontal line segment. Note that
	 * the last key point, where the rightmost building ends, is merely used to
	 * mark the termination of the skyline, and always has zero height. Also,
	 * the ground in between any two adjacent buildings should be considered
	 * part of the skyline contour.
	 * 
	 * For instance, the skyline in Figure B should be represented as:[ [2 10],
	 * [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
	 * 
	 * Notes:
	 * The number of buildings in any input list is guaranteed to be in the
	 * range [0, 10000]. The input list is already sorted in ascending order by
	 * the left x position Li. The output list must be sorted by the x position.
	 * There must be no consecutive horizontal lines of equal height in the
	 * output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...]
	 * is not acceptable; the three lines of height 5 should be merged into one
	 * in the final output as such: [...[2 3], [4 5], [12 7], ...]
	 */
	public static void main(String[] args) {
		int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10},
				{19, 24, 8}};

		List<int[]> list = getSkyline(buildings);
		for (int i = 0; i < list.size(); i++)
			System.out.println(Arrays.toString(list.get(i)));
	}

	public static class Edge implements Comparable<Edge> {
		boolean isStart;
		int x;
		int height;

		public Edge(int x, int height, boolean isStart) {
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(Edge o) {
			// first compare by x.
			// If they are same then use this logic
			// if two starts are compared then higher height building should be
			// picked first
			// if two ends are compared then lower height building should be
			// picked first
			// if one start and end is compared then start should appear before
			// end
			if (this.x != o.x) {
				return this.x - o.x;
			} else {
				return (this.isStart ? -this.height : this.height)
						- (o.isStart ? -o.height : o.height);
			}
		}
	}
	public static List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<int[]>();
		if (buildings.length == 0 || buildings[0].length == 0)
			return list;

		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < buildings.length; i++) {
			int x = buildings[i][0];
			int y = buildings[i][1];
			int height = buildings[i][2];
			edges.add(new Edge(x, height, true));
			edges.add(new Edge(y, height, false));
		}
		Collections.sort(edges);

		// Store (Max Height, Count) pair
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(0, 1);

		int prevMaxHeight = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if (edge.isStart) {
				// Starting edge
				if (map.containsKey(edge.height)) {
					map.put(edge.height, map.get(edge.height) + 1);
				} else {
					map.put(edge.height, 1);
				}
			} else {
				// Ending edge
				int count = map.get(edge.height) - 1;
				if (count == 0) {
					map.remove(edge.height);
				} else {
					map.put(edge.height, count);
				}
			}

			// Find the highest height from the map
			int currentMaxHeight = map.lastKey();
			
			// If the highest height is changed, then print result
			if (prevMaxHeight != currentMaxHeight) {
				list.add(new int[]{edge.x, currentMaxHeight});
				prevMaxHeight = currentMaxHeight;
			}
		}

		return list;
	}

}
