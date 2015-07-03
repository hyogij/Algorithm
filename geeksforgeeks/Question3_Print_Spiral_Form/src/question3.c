/*
 ============================================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.02.05 (Question3)
 Description : http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#define ROW 3
#define COLUMN 6

/*
Given a 2D array, print it in spiral form. See the following examples.

Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output:
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
*/

void spiralPrint(int row, int column, int array[][COLUMN]);
void sprialPrintHelper(int rowStart, int rowEnd, int columnStart, int columnEnd,
		int array[][COLUMN]);

/* Driver program to test above functions */
int main()
{
    int a[ROW][COLUMN] = { {1,  2,  3,  4,  5,  6},
        {7,  8,  9,  10, 11, 12},
        {13, 14, 15, 16, 17, 18}
    };

	spiralPrint(ROW, COLUMN, a);
	return 0;
}

// Prints a given matrix in spiral form
void spiralPrint(int row, int column, int array[][COLUMN]) {
	int rowStart, rowEnd, columnStart, columnEnd;

	rowStart = columnStart = 0;
	rowEnd = row - 1;
	columnEnd = column - 1;

	// Calls sprialPrintHelper function until array elements is visited
	for (int i = 0, j = 0; i <= rowEnd / 2 && j <= columnEnd / 2; i++, j++) {
		sprialPrintHelper(i, rowEnd - i, j, columnEnd - j, array);
	}
}

// Prints edge elements of given array
void sprialPrintHelper(int rowStart, int rowEnd, int columnStart, int columnEnd,
		int array[][COLUMN]) {
	// Prints array elements from left upper to right upper
	for (int i = columnStart; i <= columnEnd; i++) {
		printf("%d ", array[rowStart][i]);
	}
	// Prints array elements from right upper to right lower
	for (int i = rowStart + 1; i <= rowEnd; i++) {
		printf("%d ", array[i][columnEnd]);
	}
	// Prints array elements from right lower to left lower
	for (int i = columnEnd - 1; i >= columnStart && i != columnStart; i--) {
		printf("%d ", array[rowEnd][i]);
	}
	// Prints array elements from left lower to left upper
	for (int i = rowEnd - 1; i >= rowStart + 1 && i != rowStart; i--) {
		printf("%d ", array[i][columnStart]);
	}
}
