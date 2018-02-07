/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacore.algorithms.collections;

/**
 *
 * @author svpuzyrov
 */
public class OrderedListTest {
    public static void main(String[] args) {
        List<Integer> intOrdList = new OrderedListImpl<>();
        System.out.println(intOrdList);
        
        intOrdList.add(-1);
        intOrdList.add(4);
        intOrdList.add(-5);
        intOrdList.add(7);
        intOrdList.add(4);
        intOrdList.add(-1);
        intOrdList.add(-1);
        intOrdList.add(4);
        intOrdList.add(7);
        
        System.out.println(intOrdList);
        if (intOrdList.removeFirst(7)){
            System.out.println(intOrdList);
        }
        if (intOrdList.removeLast(4)){
            System.out.println(intOrdList);
        }
        
        if (intOrdList.removeFirst(-1)){
            System.out.println(intOrdList);
        }
        
//        if (intOrdList.removeLast(-1)){
//            System.out.println(intOrdList);
//        }
        System.out.println(intOrdList.size());
        
        for (int i = 0; i < intOrdList.size(); ++i){
            if (i > 0)
                System.out.print(" ");
            System.out.print("[" + i + "]: " + intOrdList.get(i));
        }
        System.out.println();
        System.out.println(intOrdList.lastIndexOf(4));
        System.out.println(intOrdList.lastIndexOf(-1));
    }
}
