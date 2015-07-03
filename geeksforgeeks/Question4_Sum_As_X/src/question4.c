/*
 ============================================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.02.09 (Question4)
 Description : http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#define FOUND 1
#define NOT_FOUND 0
#define TRUE 1
#define FALSE 0
#define MAX 10000

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x.
 * Write a C program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly x.
 */

/**
 * i) Compares all elements : O(n^2)
 * ii) Sorts and uses 2 pointer : O(nlogn)
 * iii) Uses hash : O(n)
 */

int hasArrayTwoCandidates(int *array, int arr_size, int sum);
int hasArrayTwoCandidatesModified(int *array, int arr_size, int sum);

/* Driver program to test above function */
int main() {
	int A[] = { 1, -13, 45, 6, 11, -8, 24 };
	int sum = 16;
	int arr_size = 7;

	if (hasArrayTwoCandidatesModified(A, arr_size, sum))
		printf("Array has two elements with sum 16");
	else
		printf("Array doesn't have two elements with sum 16 ");

	return 0;
}

/**
 * Following function has defect when array has a negative element. 45 and -13 will be stored array[29].
 * This conflict is edge case of this function.
 */
int hasArrayTwoCandidates(int *array, int arr_size, int sum) {
	int binMap[MAX] = { 0, };
	int index = 0;

	for (int i = 0; i < arr_size; i++) {
		index = sum - array[i];
		if (index < 0) {
			binMap[(index * -1)] = -1;
		} else {
			binMap[index] = 1;
		}
	}

	for (int i = 0; i < arr_size; i++) {
		if (array[i] < 0 && binMap[(array[i] * -1)] == -1) {
			printf("Pair with given sum %d is (%d, %d) \n", sum, array[i],
					(sum - array[i]) * -1);
			return FOUND;
		} else if (binMap[array[i]] == 1) {
			printf("Pair with given sum %d is (%d, %d) \n", sum, array[i],
					sum - array[i]);
			return FOUND;
		}
	}
	return NOT_FOUND;
}

int hasArrayTwoCandidatesModified(int *A, int arr_size, int sum) {
	int binMap[MAX] = { 0, };
	int index = 0;
	int minimum = MAX;
	int hasNegativeElements = FALSE;

	/**
	 * If range of numbers include negative numbers then we have to do
	 * for negative numbers is to make everything positive by adding
	 * the absolute value of smallest negative integer to all numbers.
	 */
	for (int i = 0; i < arr_size; i++) {
		if (A[i] < 0) {
			hasNegativeElements = TRUE;
			if (A[i] < minimum) {
				minimum = A[i];
			}
		}
	}

	if (hasNegativeElements) {
		for (int i = 0; i < arr_size; i++) {
			A[i] += (minimum * -1);
		}
		sum += (minimum * -1);
	}

	for (int i = 0; i < arr_size; i++) {
		index = sum - A[i];
		if (index >= 0 && binMap[index]) {
			printf("Pair with given sum %d is (%d, %d) \n", sum, A[i] + minimum,
					index);
			return FOUND;
		}
		binMap[A[i]] = 1;
	}
	return NOT_FOUND;
}
