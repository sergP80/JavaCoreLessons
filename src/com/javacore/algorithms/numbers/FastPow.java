/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.algorithms.numbers;

/**
 *
 * @author Admin
 */
public class FastPow {
    public static void main(String[] args) {
        int n = 10;
        double x = 3.5;
        System.out.println(Math.pow(x, n));
        System.out.println(fastPow(x, n));
    }

    public static double fastPow(double x, int n) {
        double res = 1.0;
        while (n > 0){
            if (n % 2 == 0){
                x *= x;
                n /=2;
            }
            else{
                res *= x;
                --n;
            }
        }
        return res;
    }
    
}
