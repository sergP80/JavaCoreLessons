package com.javacore.algorithms.arrays;

import java.util.Arrays;
import junit.framework.Assert;


public class SortArrayDemo {

    public static void main(String[] args) {
        testQuickSort();
    }

    public static void testQuickSort() {
        System.out.println("Quick-sort demo");
        for (int i = 0; i < 99; ++i) {
            Integer[] data = ArrayUtils.createRandomArray(-100, 100);
            System.out.println(Arrays.toString(data));
            ArrayUtils.quickSort(data);
            System.out.println(Arrays.toString(data));
            Assert.assertTrue("Array is not sorted", ArrayUtils.isArraySorted(data));
            System.out.println("Array is sorted");
        }

        {
            System.out.println("Shuffling...");
            Integer[] data = ArrayUtils.createRandomArray(-100, 100);
            System.out.println(Arrays.toString(data));
            ArrayUtils.quickSort(data);
            System.out.println(Arrays.toString(data));
            ArrayUtils.shuffle(data);
            System.out.println(Arrays.toString(data));

        }

    }

}
