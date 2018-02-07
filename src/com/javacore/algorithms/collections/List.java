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
public interface List<T extends Comparable<T>>{
    boolean add(T data);
    boolean insert(int pos, T data);
    boolean removeFirst(T data);
    boolean removeLast(T data);
    int indexOf(T data);
    int lastIndexOf(T data);
    T get(int i);
    int size();
    boolean isEmpty();
}
