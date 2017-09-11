// 
// Author: kulwadee.som@sit.kmutt.ac.th
// 

package dsa.sorting;

import java.util.Arrays;

public class SortingExperiment {

	public static void main(String[] args) {
		int maxInt = 1000000;
		int trials = 20;

		String[] algo = { "insertion sort", "mergesort", "quicksort", "randomized quicksort" };
		int NUM_ALGO = algo.length;

		int[] sizes = { 16, 64, 256, 1024, 4096, 16384, 32768 };
		System.out.printf("#Size: ");
		for (int s : sizes)
			System.out.printf("%d ", s);
		System.out.println();

		System.out.println("#Time unit: microseconds");

		Stopwatch w;
		Sorter sorter;

		for (int k = 0; k < NUM_ALGO; k++) {
			System.out.printf("%20s:   ", algo[k]);
			for (int j = 0; j < sizes.length; j++) {
				int N = sizes[j];
				long totTime = 0;
				for (int i = 0; i < trials; i++) {
					// generate a random array A of N integers
					int[] A = Utils.randInts(maxInt, N);
					// validate against Java's Arrays.sort
					int[] B = Utils.copyA(A);    // B is the correct answer!
					Arrays.sort(B);
					switch (k) {
					case 0:
						sorter = new InsertionSort();
						break;
					case 1:
						sorter = new MergeSort();
						break;
					case 2:
						sorter = new QuickSort();
						break;
					case 3:
						sorter = new RandomizedQuickSort();
						break;
					default:
						sorter = null;
					}
					if (sorter == null) {
						System.out.println("*** Error: incorrect algorithm number.");
						return;
					}
					/****** Measure Sorting Time ******/
					w = new Stopwatch();
					sorter.sort(A, N);
					totTime += w.elapsed();
					/**********************************/
					if (!Arrays.equals(A, B)) {
						System.out.println("*** Error: incorrect algorithm number.");
						return;
					}
				}
				System.out.printf("%8.2f   ", (totTime) / (trials * 1000.0));
			}
			System.out.println();
		}

	}

}
