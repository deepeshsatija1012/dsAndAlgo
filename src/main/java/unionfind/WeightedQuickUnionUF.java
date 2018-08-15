package unionfind;

import java.util.Arrays;

public class WeightedQuickUnionUF {
    private int[] arr;
    private int[] sz;

    public WeightedQuickUnionUF(int size) {
        this.arr = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < size; i++) {
            this.sz[i] = 1;
            this.arr[i] = i;
        }
    }

    public int root(int index){
        int i = this.arr[index];
        while(i!=arr[i]) {
            i=arr[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p)==root(q);
    }

    public void union(int p, int q){
        int proot = root(p), qroot = root(q);
        if(sz[proot]>sz[qroot]){
            arr[qroot] = proot;
            sz[proot]+=sz[qroot];
        }else{
            arr[proot] = qroot;
            sz[qroot]+=sz[proot];
        }
        System.out.println("union("+p+", "+q+") "+ Arrays.toString(this.arr));
    }
}
