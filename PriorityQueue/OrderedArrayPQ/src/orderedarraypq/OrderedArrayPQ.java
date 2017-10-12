/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderedarraypq;

import java.util.NoSuchElementException;

/**
 *
 * @author INT320
 */
public class OrderedArrayPQ<Item>  {
   // unordered array based PQ
    private Item[] pq;   // used to store items beginning rom index 1
    private int n;            // number of items in our PQ
    private static int initCapacity = 2;
    
    public OrderedArrayPQ() {
       pq = (Item[]) new Object[initCapacity];
       n = 0;
    }
    
    public void insert(Item item) {
        if (n == pq.length - 1) { 
            resize(2*pq.length);
        }
        // find index of the first item that is larger than item
        int idx = 1;
        while (n>0 && idx <= n && less(pq[idx], item)) {
            idx++;
        }
        for (int j = n; j >= idx; j--) {
            pq[j+1] = pq[j]; 
        }
        pq[idx] = item;
        n++;
    }
    
    public Item delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue Underflow.");
        }
        Item maxitem = pq[n];
        n--;
        if ((n>0) && (n == (pq.length-1)/4)) {
            resize(pq.length/2);
        }
        return maxitem;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }

    private boolean less(Item a, Item b) {
        return ((Comparable<Item>) a).compareTo(b) < 0;
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
        OrderedArrayPQ<String> pq = new OrderedArrayPQ<String>();
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
