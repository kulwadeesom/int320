package dsa.sorting;

import java.util.Arrays;

public class InsertionSort implements Sorter {
	
	public void sort(int[] A, int N) {
		for (int i = 1; i < N; i++) {
			int key = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > key) {
				A[j+1] = A[j];
				j = j - 1;
			}
			A[j+1] = key;
		}
	}

	public static void main(String[] args) {
		final String SEP = " ";
		
		int[] A = Utils.randInts(99, 15);
		int[] B = Utils.copyA(A);
		Arrays.sort(B);
		Utils.printA(A, SEP);
		
		Sorter sorter = new InsertionSort();
		sorter.sort(A, A.length);
		
		if (! Arrays.equals(A, B)) 
			System.out.println("Incorrect sorting");
		Utils.printA(A, SEP);
	}

}
