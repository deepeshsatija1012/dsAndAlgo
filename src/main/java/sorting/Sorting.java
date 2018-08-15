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
}
