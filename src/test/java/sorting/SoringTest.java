package sorting;

import org.junit.Assert;
import org.junit.Test;

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
}
