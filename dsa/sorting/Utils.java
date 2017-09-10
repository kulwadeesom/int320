package dsa.sorting;

public class Utils {
	public static int[] randInts(int max, int N) {
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = (int)(Math.random() * (max+1));
		return A;
	}
	public static void printA(int[] A, int p, int r, String sep) {
		for (int i = p; i <= r; i++) 
			System.out.print(A[i] + sep);
		System.out.println();
	}
	public static void printA(int[] A, String sep) {
		for (int i : A)
			System.out.print(i + sep);
		System.out.println();
	}
	public static int[] copyA(int[] src) {
		int[] dest = new int[src.length];
		for (int i = 0; i < src.length; i++)
			dest[i] = src[i];
		return dest;
	}
	public static int randInt(int min, int max) {
		// generate random int [min, max]
		return min + (int) (Math.random() * (max-min+1));
	}
}
