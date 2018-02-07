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
public class OrderedListNode<T extends Comparable<T>> {

    private T data;
    private OrderedListNode<T> next;

    public OrderedListNode(T data, OrderedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public OrderedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public OrderedListNode<T> getNext() {
        return next;
    }

    public void setNext(OrderedListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + data;
    }
    
    
}
