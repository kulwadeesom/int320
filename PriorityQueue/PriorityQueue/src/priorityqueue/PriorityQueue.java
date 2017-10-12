/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author INT320
 */
public class PriorityQueue {
    // unordered array
    private String[] pq;    // priority queue beginning from index 1
    private int n;               // size of priority queue 
    private static int initCapacity = 1;    

    public PriorityQueue() {
        pq = new String[initCapacity];
        n = 0;
    }
    /**
     * Append item to the end of pq array
     * @param item 
     */
    public void insert(String item) {
        if (n == pq.length-1) resize(2*pq.length);
        pq[++n] = item;     
    }
    
    public String delMax() {
        // find max
        int maxidx = 1;
        for (int i = 2; i <= n; i++) {
            if (less(maxidx, i)) {
                maxidx = i;
            }
        }
        // pq[maxidx] is the maximum item in our Q
        
        String maxitem = pq[maxidx];
        if (maxidx < n) {
            exch(maxidx, n);
        }
        n--;
        if ((n > 0) && (n == (pq.length - 1)/4)) {
            resize(pq.length/2);
        }
        return maxitem;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    private void resize(int capacity) {
        assert capacity > n;
        String[] temp = new String[capacity];
        for (int i = 1; i <= n;  i++) {
            temp[i] = pq[i];
        }
        pq = temp;            
    }
    private boolean less(int i, int j) {
        // true if pq[i] < pq[j]
       return ((Comparable<String>) pq[i]).compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j) {
        String temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    private void showContent() {
        for (int i = 1; i <= n; i++) 
            System.out.print(pq[i] + " ");
        System.out.println();
    }

    // test client
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue pq = new PriorityQueue();
        pq.insert("P");
        pq.showContent();
        pq.insert("Q");
        pq.showContent();
        pq.insert("E");
        pq.showContent();
        System.out.println("\n................" + pq.delMax());
        pq.showContent();
        pq.insert("X");
        pq.showContent();
        pq.insert("A");
        pq.showContent();
        pq.insert("M");
        pq.showContent();
        System.out.println("\n................" + pq.delMax());
        pq.showContent();
        System.out.println("\n................" + pq.delMax());
        pq.showContent();
        System.out.println("\n................" + pq.delMax());
        pq.showContent();
        pq.insert("P");
        pq.showContent();
        pq.insert("L");
        pq.showContent();
        pq.insert("E");
        pq.showContent();
        System.out.println("\n................" + pq.delMax());
        pq.showContent();
    }

}
