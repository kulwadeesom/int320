package dsa.sorting;

import java.util.Arrays;

public class QuickSort implements Sorter {
	private int partition(int[] A, int p, int r) {
		int q = p;
		for (int u = p; u < r; u++) {
			if (A[u] <= A[r]) {
				int tmp = A[q]; A[q] = A[u]; A[u] = tmp;
				q = q + 1;
			}
		}
		int tmp = A[q]; A[q] = A[r]; A[r] = tmp;
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
		
		Sorter sorter = new QuickSort();
		sorter.sort(A, A.length);
		
		if (! Arrays.equals(A, B)) 
			System.out.println("Incorrect sorting");
		Utils.printA(A, SEP);
	} 
}
