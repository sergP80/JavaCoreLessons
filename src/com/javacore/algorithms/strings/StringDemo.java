/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author svpuzyrov
 */
public class StringDemo {
    public static void main(String[] args) {
        int countVolves = 0;
        boolean setArgs = args != null && args.length > 0;
        if (!setArgs){
            System.out.print("Type a string:");
        }
        String st = setArgs ? args[0] : new Scanner(System.in).nextLine();
        for (int i = 0; i < st.length(); ++i)
        {
            
        }
    }
}
