package sorting;

import java.util.Arrays;

public class Sorting {

    public static boolean less(Comparable left, Comparable right){
        return left.compareTo(right)<0;
    }

    public static void exch(Comparable[] arr, int i, int j){
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean isSorted(Comparable[] arr){
        for(int i=1;i<arr.length;i++){
            if(less(arr[i], arr[i-1])) return false;
        }
        return true;
    }

    public static void bubblesort(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j< arr.length-i-1;j++){
                if(!less(arr[j],arr[j+1])){
                    exch(arr, j, j+1);
                }
            }
        }
        System.out.println("bubblesort.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void selectionsort(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i+1;j< arr.length;j++){
                if(less(arr[j],arr[minIndex])){
                    minIndex = j;
                }
            }
            exch(arr, i, minIndex);
        }
        System.out.println("selectionsort.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void insertionsort(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(less(arr[j], arr[j-1])){
                    exch(arr, j, j-1);
                }else
                    break;
            }
        }
        System.out.println("insertionsort.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void shellsort(Comparable[] arr){
        int h=1;
        while(h<arr.length/3) h = (3*h)+1; //3x + 1 sequence

        while(h>=1){
            //h-sort the array
            for(int i=h;i<arr.length;i++){
                for(int j=i; j>=h ;j-=h){
                    if(less(arr[j], arr[j-h])){
                        exch(arr, j, j-h);
                    }else
                        break;
                }
            }
            //move to lesser value of 3x+1
            h=h/3;
        }
        System.out.println("shellsort.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void mergesort(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        mergeSort(arr, aux, 0, arr.length-1);
        System.out.println("mergesort.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void mergesortsequenctial(Comparable[] arr){
        Comparable[] aux = new Comparable[arr.length];
        for(int i=1;i<arr.length;i=i+i){
            for(int j=0;j<arr.length-i; j+=i+i){
                merge(arr, aux, j, j+i-1, Math.min(j+i+i-1, arr.length-1));
            }
        }
        System.out.println("mergesortsequenctial.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void mergeSort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if(lo>=hi) return;
        int mid = lo + ((hi-lo)/2);
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid+1, hi);
        if(!less(arr[mid+1], arr[mid])) return; //Array is alread sorted don't need merge
        merge(arr, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
        for(int i=lo;i<=hi;i++){
            aux[i] = arr[i];
        }
        int l = lo, r = mid+1;
        for(int i=lo;i<=hi;i++){
            if(l>mid) arr[i] = aux[r++];
            else if (r>hi) arr[i] = aux[l++];
            else if(less(aux[l], aux[r])) arr[i] = aux[l++];
            else arr[i] = aux[r++];
        }
    }


    public static void quicksort(Comparable[] arr){
        quickSort(arr, 0, arr.length-1);
        System.out.println("quicksort.isSorted("+ Arrays.toString(arr)+") : "+isSorted(arr));
    }

    public static void quickSort(Comparable[] arr, int lo, int hi){
        if(lo>=hi) return;;

        int pivot = partition(arr, lo, hi);

        quickSort(arr, lo, pivot-1);
        quickSort(arr, pivot+1, hi);
    }

    public static int partition(Comparable[] arr, int lo, int hi){
        int i=lo+1; int j=hi;
        while(true){
            while(i<=hi && less(arr[i], arr[lo])) i++;

            while(j>=lo && less(arr[lo], arr[j])) j--;

            if(i>=j) break;
            exch(arr, i, j);
        }

        exch(arr, lo, j);
        return j;
    }

    public static Comparable findkthSmallest(Comparable[] arr, int k){
        int lo = 0, hi = arr.length-1;
        while(lo<hi){
            int pivot = partition(arr, lo, hi);
            if(k<pivot) hi = pivot-1;
            else if(k>pivot) lo = pivot + 1;
            else return arr[k];
        }
        return arr[k];
    }
}
