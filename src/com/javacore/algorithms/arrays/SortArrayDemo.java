/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.algorithms.arrays;

import java.util.Arrays;
import junit.framework.Assert;

/**
 *
 * @author Admin
 */
public class SortArrayDemo {

    public static void main(String[] args) {
//        System.out.println("Shell sort for int array");
//        Integer[] aInt = {-4, 10, -5, 3, 11, 5};
//        System.out.println(Arrays.toString(aInt));
//        shellSort(aInt);
//        System.out.println(Arrays.toString(aInt));
//        System.out.println("Combo sort for double array");
//        Double[] aDouble = {-4.1, -4.8, -10.2, 1.1, 0.5, 5.7, 3.01};
//        System.out.println(Arrays.toString(aDouble));
//        combSort(aDouble);
//        System.out.println(Arrays.toString(aDouble));

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

    }

}
