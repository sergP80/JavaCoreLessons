package com.javacore.algorithms.collections;

public class LinkListImpl<T extends Comparable<T>> implements List<T> {

    private LinkListNode<T> head_ = null;
    private LinkListNode<T> tail_ = null;
    private int size_ = 0;
    
    public LinkListImpl() {
    }
    
    @Override
    public boolean add(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insert(int pos, T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeFirst(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeLast(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(T data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T get(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
