package de.ovgu.icse.assignment03;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;

import java.util.Arrays;

import java.util.Comparator;

public class Main {

	public static <T extends Comparable<T>> void quickSort (T[] a) {

		qsort(a, 0, a.length - 1);

	}

	public static <T extends Comparable<T>> void mergeSort(T[] a, Comparator<T> c) {

		T[] copy = (T[])new Comparable[a.length];

		_mergeSort(a, copy , 0, a.length - 1);

	}


	// auxiliary function for recursive sorting by merging

	private static <T extends Comparable<T>> void _mergeSort(T[] a, T[] copy, int start, int end){

		if (start < end) {

			int mid = (start + end) / 2;

			_mergeSort(a, copy, start, mid);

			_mergeSort(a, copy, mid + 1, end);

			merge(a, copy, start, mid, end);

		}

	}


	private static <T extends Comparable<T>> void merge(T a[], T copy[], int start, int m, int end)

	{

		int i = 0, j = start, k;

		while (j <= m)

			copy[i++] = a[j++];

		i = 0;

		k = start;

		while (k < j && j <= end) {

			if (copy[i].compareTo(a[j]) <= 0)

				a[k++] = copy[i++];

			else

				a[k++] = a[j++];

		}

		while (k < j)

			a[k++] = copy[i++];

	}



	public static void main(String[] args) {
	}



	public static <T extends Comparable<T>> int partition (T[] arr, int first, int last) {

		T pivot = arr[first+(last-first)/2]; //pivot

		int i = first; //index going left to right

		int j = last; //index going right to left

		while (i <= j) {

			while (arr[i].compareTo(pivot) < 0) {

				i++;

			}

			while (arr[j].compareTo(pivot) > 0) {

				j--;

			}

			if (i <= j) {

				T temp = arr[i];

				arr[i] = arr[j];

				arr[j] = temp;

				//move index to next position on both sides

				i++;

				j--;

			}

		}



		return i; //new index of pivot

	}

	public static <T extends Comparable<T>> void qsort(T[] arr, int first, int last) {

		int split = partition(arr, first, last);

		if (first < split - 1)

			qsort(arr, first, split - 1); //left subarray

		if (split < last)

			qsort(arr, split, last); //right subarray

	}

}

