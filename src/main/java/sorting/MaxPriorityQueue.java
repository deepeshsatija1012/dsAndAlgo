package sorting;

import java.util.Arrays;

public class MaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] arr;
    private int n;

    public MaxPriorityQueue(int n){
        this.arr = (Key[]) new Comparable[n+1];
        this.n = 0;
    }

    public Key[] getUnderlyingArray(){
        return Arrays.copyOf(arr, arr.length);
    }

    public boolean isEmpty(){
        return this.n==0;
    }

    public void insert(Key key){
        arr[++n] = key;
        swim(n);
    }

    public Key delMax(){
        Key key = arr[1];
        exch(1, n--);
        sink(1);
        arr[n+1] = null;
        return key;
    }

    private void swim(int i){
        int k = i;
        while(k>1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int i){
        int k = i;
        while(2*k<=n){
            int j = 2*k;
            if(j<n && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(j, k);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return arr[i].compareTo(arr[j])<0;
    }

    private void exch(int i, int j){
        Key t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}
