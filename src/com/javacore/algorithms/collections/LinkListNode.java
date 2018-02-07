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
public class LinkListNode<T extends Comparable<T>> {
    private T data;
    private LinkListNode<T> prevNode;
    private LinkListNode<T> nextNode;

    public LinkListNode(T data, LinkListNode<T> prev, LinkListNode<T> next) {
        this.data = data;
        this.prevNode = prev;
        this.nextNode = next;
    }

    public LinkListNode(T data) {
        this(data, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkListNode<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(LinkListNode<T> prevNode) {
        this.prevNode = prevNode;
    }

    public LinkListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "" + data;
    }
    
    
}
