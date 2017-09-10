package dsa.sorting;

import java.util.Arrays;

public class MergeSort implements Sorter {
	private void merge(int[] A, int p, int q, int r) {
		int n1 = (q - p + 1);
		int n2 = (r - q);
		int[] L = new int[n1];
		for (int i = 0; i < n1; i++)
			L[i] = A[p+i];
		int[] R = new int[n2];
		for (int i = 0; i < n2; i++)
			R[i] = A[q+1+i];
		
		int i = p, j = 0, k = 0;
		
		while (j < n1 && k < n2) {
			if (L[j] < R[k]) A[i++] = L[j++];
			else             A[i++] = R[k++];
		}
		while (j < n1) A[i++] = L[j++];
		while (k < n2) A[i++] = R[k++];
	}
	private void mergesort(int[] A, int p, int r) {
		if (p >= r) return;
		
		int q = (int)(Math.floor(p + r)/2);
		mergesort(A, p, q);
		mergesort(A, q+1, r);
		merge(A, p, q, r);
	}
	public void sort(int[] A, int N) {
		mergesort(A, 0, N-1);
	}
	
	public static void main(String[] args) {
		final String SEP = " ";
		
		int[] A = Utils.randInts(99, 15);
		int[] B = Utils.copyA(A);
		Arrays.sort(B);
		Utils.printA(A, SEP);
		
		Sorter sorter = new MergeSort();
		sorter.sort(A, A.length);
		
		if (! Arrays.equals(A, B)) 
			System.out.println("Incorrect sorting");
		Utils.printA(A, SEP);
	}

}
