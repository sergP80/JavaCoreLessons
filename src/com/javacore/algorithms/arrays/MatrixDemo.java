package com.javacore.algorithms.arrays;

import java.util.Arrays;
import java.util.Random;

public class MatrixDemo {
    public static void main(String[] args) {
        int[][] uppMatrix = new int[5][];
        Random random = new Random();
        for (int i = 0; i < uppMatrix.length; ++i)
        {
            uppMatrix[i] = new int[random.nextInt(11) + 1];
            for (int j = 0; j< uppMatrix[i].length; ++j)
            {
                uppMatrix[i][j] = random.nextInt(1001)-500;
            }
        }

        System.out.println(Arrays.deepToString(uppMatrix));
//        for (int[] row: uppMatrix)
//        {
//            System.out.println(Arrays.toString(row));
//        }
    }
}
