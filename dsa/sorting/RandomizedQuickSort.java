// 
// Author: kulwadee.som@sit.kmutt.ac.th
//

package dsa.sorting;

import java.util.Arrays;

public class RandomizedQuickSort implements Sorter {
	private int partition(int[] A, int p, int r) {
		// swap A[r] with a randomly chosen element A[ridx]
		int idx = Utils.randInt(p, r-1);
		int x = A[r]; A[r] = A[idx]; A[idx] = x;
		
		// do the partition procedure
		int q = p;
		for (int u = p; u < r; u++) {
			if (A[u] <= A[r]) {
				// A[u] <-> A[q]
				int tmp = A[u]; A[u] = A[q]; A[q] = tmp;
				q = q + 1;
			}
		}
		// A[r] <-> A[q]
		int tmp = A[r]; A[r] = A[q]; A[q] = tmp;
		return q;
	}
	private void quicksort(int[] A, int p, int r) {
		if (p >= r) return;
		
		int q = partition(A, p, r);
		quicksort(A, p, q-1);
		quicksort(A, q+1, r);
	}
	public void sort(int[] A, int N) {
		quicksort(A, 0, N-1);
	}

	public static void main(String[] args) {
		final String SEP = " ";
		
		int[] A = Utils.randInts(99, 15);
		int[] B = Utils.copyA(A);
		Arrays.sort(B);
		Utils.printA(A, SEP);
		
		Sorter sorter = new RandomizedQuickSort();
		sorter.sort(A, A.length);
		
		if (! Arrays.equals(A, B)) 
			System.out.println("Incorrect sorting");
		Utils.printA(A, SEP);

	}

}
