package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SoringTest {
    @Test
    public void bubbleSortTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.bubblesort(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.bubblesort(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.bubblesort(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void selectionSortTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.selectionsort(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.selectionsort(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.selectionsort(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void insertionSortTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.insertionsort(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.insertionsort(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.insertionsort(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void shellSortTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.shellsort(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.shellsort(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.shellsort(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void mergeSortTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.mergesort(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.mergesort(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.mergesort(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void mergeSortSequentialTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.mergesortsequenctial(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.mergesortsequenctial(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.mergesortsequenctial(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void quickSortTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.quicksort(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.quicksort(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.quicksort(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void quickSortStableTest(){
        Integer[] arr = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.quicksortstable(arr);
        Assert.assertTrue(Sorting.isSorted(arr));

        Integer[] arr1 = new Integer[]{20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        Sorting.quicksortstable(arr1);
        Assert.assertTrue(Sorting.isSorted(arr1));

        Integer[] arr2 = new Integer[]{40, 20};
        Sorting.quicksortstable(arr2);
        Assert.assertTrue(Sorting.isSorted(arr2));
    }

    @Test
    public void heapSortTest(){
        Integer[] arr = new Integer[]{null, 20, 40, 10, 70, 30, 50, 60, 80, 90};
        Sorting.heapsort(arr);
        Assert.assertTrue(Sorting.isSorted(Arrays.copyOfRange(arr, 1, arr.length)));

        Integer[] arr1 = new Integer[]{null, 20, 40, 10, 70, 30, 50, 60, 80, 90, 10};
        System.out.println("Initial Array : " + Arrays.toString(Arrays.copyOfRange(arr1, 1, arr1.length)));
        Sorting.heapsort(arr1);
        Assert.assertTrue(Sorting.isSorted(Arrays.copyOfRange(arr1, 1, arr1.length)));

        Integer[] arr2 = new Integer[]{null, 40, 20};
        Sorting.heapsort(arr2);
        Assert.assertTrue(Sorting.isSorted(Arrays.copyOfRange(arr2, 1, arr2.length)));
    }

}
