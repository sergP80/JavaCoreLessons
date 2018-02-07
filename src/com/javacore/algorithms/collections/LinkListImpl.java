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
public class LinkListImpl<T extends Comparable<T>> implements List<T> {

    private LinkListNode<T> head_ = null;
    private LinkListNode<T> tail_ = null;
    private int size_ = 0;
    
    public LinkListImpl() {
    }
    
    @Override
    public boolean add(T data) {
        LinkListNode<T> node = new LinkListNode<>(data);
        if (head_ == null){
            head_ = tail_ = node;
            if (tail_ == null)
                tail_ = head_;
        }
        else{
            
        }
    }

    @Override
    public boolean insert(int pos, T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirst(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLast(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
