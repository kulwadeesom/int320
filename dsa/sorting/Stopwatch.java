// 
// Author: kulwadee.som@sit.kmutt.ac.th
//

package dsa.sorting;

public class Stopwatch {
	private long start;
	public static final double unit = 10E-9;
	public Stopwatch() {
		start = System.nanoTime();
	}
	public long elapsed() {
		return (System.nanoTime() - start);
	}

	public static void main(String[] args) {
		Stopwatch w1 = new Stopwatch();
		for (int i = 0; i < 100000000; i++)
			;
		System.out.println(w1.elapsed()/(1.0*10E9));

	}

}
