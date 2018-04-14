package com.javacore.algorithms.numbers;

import java.util.Random;

public class NumberAlgorithms {
    public interface LNumberProcess {
        long action(long n);
    }

    private static Random random = new Random();

    /**
     * Find sum of digits for the given number
     *
     * @param n - given number
     * @return sum of its digits
     */
    public static long sumOfDigits(long n) {
        long sum = 0;
        for (; n > 0; n /= 10) {
            sum += n % 10;
        }
        return sum;
    }

    private static long sumOfDigitsHelper(long n, long sum) {
        if (n == 0) {
            return sum;
        } else {
            return sumOfDigitsHelper(n / 10, sum + n % 10);
        }
    }

    /**
     * Find sum of digits for the given number using tail recursion
     *
     * @param n - given number
     * @return sum of its digits
     */
    public static long sumOfDigitsRec(long n) {
        return sumOfDigitsHelper(n, 0);
    }

    static void testDigits(LNumberProcess... processes) {
        long n = random.nextInt(99999) + 1;
        for (LNumberProcess process : processes) {
            System.out.println("Number: " + n + "; with act res: " + process.action(n));
        }
    }

    /**
     * Checks that given number is the power of 2
     *
     * @param n - 2 ^ k
     * @return true or false
     */
    public static boolean is2Pow(long n) {
        return (n & (n - 1)) == 0;
    }

    /**
     * If given number is power of 2 retrieves degree of power
     *
     * @param n - 2 ^ k
     * @return k
     */
    public static long degreeOf2(long n) {
        if (!is2Pow(n)) {
            return -1;
        }

        long count = 0;
        for (; (n & 1) == 0; ++count, n >>= 1) {
        }

        return count;
    }

    private static long degreeOf2Helper(long n, long count) {
        if (!is2Pow(n)) {
            return -1;
        } else {
            if ((n & 1) != 0) {
                return count;
            } else {
                return degreeOf2Helper(n >> 1, ++count);
            }
        }
    }

    public static long degreeOf2Rec(long n) {
        return degreeOf2Helper(n, 0);
    }

    static void test2Power(LNumberProcess... processes) {
        long n = random.nextInt(41) + 10;
        n = 1L << n;
        for (LNumberProcess process: processes)
        {
            System.out.println("Number: " + n + "; degree of 2: " + process.action(n));
        }
    }

    public static void main(String[] args) {

        testDigits(NumberAlgorithms::sumOfDigits, NumberAlgorithms::sumOfDigitsRec);

        test2Power(NumberAlgorithms::degreeOf2, NumberAlgorithms::degreeOf2Rec);
    }
}
