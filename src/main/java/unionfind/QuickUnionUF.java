package unionfind;

import java.util.Arrays;

public class QuickUnionUF {

    private  int[] arr;

    public  QuickUnionUF(int size){
        this.arr = new int[size];
        for (int i=0;i<size;i++){
            this.arr[i] = i;
        }
    }

    private int root(int index){
        int i = index;
        while(this.arr[i]!=i){
            i = this.arr[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p)==root(q);
    }

    public void union(int p, int q){
        int proot = root(p); int qroot = root(q);
        this.arr[proot] = qroot;
        System.out.println("union("+p+", "+q+") "+Arrays.toString(this.arr));
    }
}
