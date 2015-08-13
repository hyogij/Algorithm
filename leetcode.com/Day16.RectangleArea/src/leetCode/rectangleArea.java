package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.11
 Question Number : 66
 Link : https://leetcode.com/problems/rectangle-area/
 ==========================================================
 */

public class rectangleArea {
	/*
	 * Find the total area covered by two rectilinear rectangles in a 2D plane.
	 * 
	 * Each rectangle is defined by its bottom left corner and top right corner
	 * as shown in the figure.
	 * 
	 * Rectangle Area Assume that the total area is never beyond the maximum
	 * possible value of int.
	 */
	public static void main(String[] args) {
		System.out.println("computeArea "
				+ computeArea(-2, -2, 2, 2, -3, -3, -1, -1));
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F,
			int G, int H) {

		return getRectArea(A, B, C, D) + getRectArea(E, F, G, H)
				- getCommonArea(A, B, C, D, E, F, G, H);
	}

	public static int getRectArea(int A, int B, int C, int D) {
		return (C - A) * (D - B);
	}

	public static int getCommonArea(int A, int B, int C, int D, int E, int F,
			int G, int H) {
		// Returns 0 area, if there is not common area
		if (C < E || G < A || D < F || H < B) {
			return 0;
		}

		// Gets length of width and height of common rectangle
		int width = Math.min(G, C) - Math.max(A, E);
		int height = Math.min(D, H) - Math.max(B, F);

		return width * height;
	}
}
