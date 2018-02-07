/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.algorithms.arrays;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class ArrayUtils {
    private static Random rnd = new Random();
    public static int MAX_ARRAY_CAP = 50;
    public static boolean SHOW_SORT_STEPS = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static <T extends Comparable<? super T>> boolean isArraySorted(T[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] createRandomArray(int min, int max) {
        int sz = rnd.nextInt(MAX_ARRAY_CAP + 1)
                + (MAX_ARRAY_CAP > 10 ? MAX_ARRAY_CAP / 2 : 0);
        Integer[] data = new Integer[sz];
        for (int i = 0; i < data.length; ++i) {
            data[i] = rnd.nextInt(max - min + 1) + min;
        }
        return data;
    }

    public static Double[] createRandomArray(double min, double max) {
        int sz = rnd.nextInt(MAX_ARRAY_CAP + 1)
                + (MAX_ARRAY_CAP > 10 ? MAX_ARRAY_CAP / 2 : 0);
        Double[] data = new Double[sz];
        for (int i = 0; i < data.length; ++i) {
            data[i] = rnd.nextDouble() * (max - min + 1) + min;
        }
        return data;
    }
    
    private static <T extends Comparable<? super T>> void printArray(T[] a, int l, int r, String colorAll, int mid, String colorMid) {
        for (int i = l; i <= r; ++i) {
            if (i > l) {
                System.out.print("\033[0m ");
            }
            System.out.print((i != mid ? colorAll : colorMid) + a[i]);
        }
        System.out.println();
    }
    
    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        for (int d = a.length / 2; d > 0; d /= 2) {
            for (int i = 0; i < a.length - d; ++i) {
                for (int j = i; j >= 0 && a[i].compareTo(a[i + d]) > 0; --j) {
                    T tmp = a[j];
                    a[j] = a[j + d];
                    a[j + d] = tmp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void combSort(T[] a) {
        double factor = 1.247330950103979;
        boolean swapped = true;
        for (int gap = a.length; gap > 1 || swapped;) {
            swapped = false;
            if (gap > 1) {
                gap = (int) (gap / factor);
            }
            for (int i = 0; i + gap < a.length; ++i) {
                if (a[i].compareTo(a[i + gap]) > 0) {
                    T tmp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = tmp;
                    if (!swapped) {
                        swapped = true;
                    }
                }
            }
        }
    }
    
    private static <T extends Comparable<? super T>> void quickSort(T[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        if (r - l == 1) {
            if (a[l].compareTo(a[r]) > 0) {
                T tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
            }
            return;
        }

        int i = l, j = r, mid = rnd.nextInt(r - l + 1) + l;

        if (SHOW_SORT_STEPS) {
            System.out.print("Before partition: ");
            printArray(a, l, r, ANSI_BLUE, mid, ANSI_GREEN);
        }
        for (; i <= mid && j > mid;) {
            while (a[i].compareTo(a[mid]) < 0) {
                ++i;
            }
            while (a[j].compareTo(a[mid]) > 0) {
                --j;
            }
            if (i <= j) {
                if (a[i].compareTo(a[j]) > 0) {
                    T tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                ++i;
                --j;
            }
        }

        if (SHOW_SORT_STEPS) {
            System.out.print("After partition: ");
            printArray(a, l, r, ANSI_BLUE, mid, ANSI_GREEN);
        }

        if (SHOW_SORT_STEPS) {
            System.out.print("(l=" + l + "; j=" + j + "): ");
            printArray(a, l, j, ANSI_RED, -1, "");
        }
        quickSort(a, l, j);

        if (SHOW_SORT_STEPS) {
            System.out.print("(i=" + i + "; r=" + r + "): ");
            printArray(a, i, r, ANSI_YELLOW, -1, "");
        }
        quickSort(a, i, r);

    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }
}
