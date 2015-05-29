package com.sample.algo.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * http://geeksquiz.com/merge-sort/ <br>
 * 1) Merge Sort is useful for sorting linked lists in O(nLogn) time. Other
 * nlogn algorithms like Heap Sort, Quick Sort (average case nLogn) cannot be
 * applied to linked lists. <br>
 * 2) Inversion Count Problem <br>
 * 3) Used in External Sorting
 *
 * @author nitin.singla
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 20, 30 };
		mergeSort(arr);

		arr = new int[] { 10, 20, 5, 30 };
		mergeSort(arr);

		arr = new int[] { 10, 20, 5, 30, 1011, 2, 0, -1 };
		mergeSort(arr);
	}

	public static int[] merge(int[] arr, int left, int middle, int right) {
		int i = left;
		int j = middle + 1;

		// create a temporary array to keep merged data
		final int[] temp = new int[arr.length];
		int k = left;
		while (i <= middle && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}

		/* Copy the remaining elements of L[], if there are any */
		while (i <= middle) {
			temp[k] = arr[i];
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there are any */
		while (j <= right) {
			temp[k] = arr[j];
			j++;
			k++;
		}

		// copy from temporary array to main data array
		copy(temp, arr, left, right);
		return arr;

	}

	public static void mergeSort(int[] arr) {
		System.out.print("Input Data ");

		print(arr);
		sort(arr, 0, arr.length - 1);
		System.out.print("  Sorted  Data ");
		print(arr);
		System.out.println(" ");
	}

	public static void print(int[] arr) {
		final List<Integer> temp = new ArrayList<>();
		for (final int i : arr) {
			temp.add(i);
		}
		System.out.print(temp);
	}

	public static void sort(int[] arr, int left, int right) {
		// System.out.println("Left index = " + left + " Right index = " +
		// right);
		if (arr != null && left < right) {
			final int middle = left + (right - left) / 2;
			sort(arr, left, middle);
			sort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		final int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void copy(int[] src, int[] target, int startIndex,
			int lastIndex) {
		for (int i = startIndex; i <= lastIndex; i++) {
			target[i] = src[i];
		}
	}
}
