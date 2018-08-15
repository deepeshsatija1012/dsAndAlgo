package unionfind;

import java.util.Arrays;

/**
 * Eager approach to algo design
 *
 */
public class QuickFindUF {

    private int[] arr;

    public QuickFindUF(int size) {
        this.arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
    }

    /**
     * Union operation is too slow
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int temp = arr[q];
        int temp1 = arr[p];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==temp1)
                arr[i] = temp;
        }
        System.out.println("union("+p+", "+q+") "+Arrays.toString(this.arr));
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }
}
