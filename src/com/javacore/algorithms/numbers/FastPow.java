/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.algorithms.numbers;

import java.util.Objects;
import java.util.Random;

/**
 * @author Admin
 */
public class FastPow {
    public interface IPow {
        double pow(double x, int n);
    }

    public static void test(double x, int n, IPow power) {
        if (Objects.isNull(power)) {
            return;
        }

        long dt = System.currentTimeMillis();
        double res = power.pow(x, n);
        dt = System.currentTimeMillis() - dt;
        System.out.println(String.format("%f^%d=%e; time: %d", x, n, res, dt));
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(216) + 105;
        double x = random.nextDouble() * 10;
        test(x, n, Math::pow);
        test(x, n, FastPow::fastPow1);
        test(x, n, FastPow::fastPow2);
        test(x, n, FastPow::fastPowRec);
        test(x, n, FastPow::fastPowTailRec);
    }

    public static double fastPow1(double x, int n) {
        System.out.println("Fast pow 1");
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 0) {
                x *= x;
                n /= 2;
            } else {
                res *= x;
                --n;
            }
        }
        return res;
    }

    public static double fastPow2(double x, int n) {
        System.out.println("Fast pow 2");
        double res = 1.0;
        while (n > 0) {
            if ((n & 1) != 0) {
                res *= x;
            }
            x *= x;
            n /= 2;

        }
        return res;
    }

    public static double fastPowRec(double x, int n) {
        if (n == 0) {
            System.out.println("Fast pow rec");
            return 1;
        } else if ((n & 1) != 0) {
            return x * fastPowRec(x, n - 1);
        } else {
            return fastPowRec(x * x, n / 2);
        }
    }

    private static double fastPowHelper(double x, int n, double res) {
        if (n == 0) {
            System.out.println("Fast pow tail rec");
            return res;
        } else if ((n & 1) != 0) {
            return fastPowHelper(x, n - 1, x * res);
        } else {
            return fastPowHelper(x * x, n / 2, res);
        }
    }

    private static double fastPowTailRec(double x, int n)
    {
        return fastPowHelper(x, n, 1.0);
    }

}
