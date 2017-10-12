/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pq;

import java.util.NoSuchElementException;

/**
 *
 * @author INT320
 */
public class PQ<Item> {
    // unordered array based PQ
    private Item[] pq;   // used to store items beginning rom index 1
    private int n;            // number of items in our PQ
    private static int initCapacity = 2;
    
    public PQ() {
       pq = (Item[]) new Object[initCapacity];
       n = 0;
    }
    
    public void insert(Item item) {
        if (n == pq.length - 1) { 
            resize(2*pq.length);
        }
        pq[++n] = item;
    }
    
    public Item delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow.");
        }
            
        // find maximum
        int maxidx = 1;
        for (int i = 2; i <= n; i++) {
            if (less(maxidx, i)) {
                maxidx = i;
            }
        }
        Item maxitem = pq[maxidx];
        if (maxidx < n) {
            exch(maxidx, n);
        }            
        n--;
        return maxitem;    
    }
    
    public boolean isEmpty() {
        return n == 0;
    }

    private boolean less(int i, int j) {
        return ((Comparable<Item>)pq[i]).compareTo(pq[j])  < 0;
    }
    
    private void exch(int i, int j) {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
    private void resize(int capacity) {
        assert capacity > n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;            
    }
    
    private void showContent() {
        for (int i = 1; i <= n; i++) 
            System.out.print(pq[i] + " ");
        System.out.println();
    }    // test client
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PQ<String> pq = new PQ<String>();
        pq.delMax();
        pq.showContent();
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
