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
public class OrderedListImpl<T extends Comparable<T>> implements List<T> {

    private OrderedListNode<T> head_ = null;
    private int size_ = 0;

    public OrderedListImpl() {
    }

    @Override
    public boolean add(T data) {
        OrderedListNode<T> node = new OrderedListNode<>(data);
        if (head_ == null) {
            head_ = node;
        } else {
            node.setNext(head_);
            head_ = node;
        }
        ++size_;
        return true;
    }

    @Override
    public boolean insert(int pos, T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirst(T data) {
        if (isEmpty()) {
            return false;
        }

        OrderedListNode<T> node = findFirst(data);

        if (node == null) {
            return false;
        }

        if (node == head_) {
            head_ = head_.getNext();
        } else {
            OrderedListNode<T> prevNode = findPrevious(node);
            prevNode.setNext(node.getNext());
        }

        node.setNext(null);
        --size_;
        return true;

    }

    @Override
    public boolean removeLast(T data) {
        if (isEmpty()) {
            return false;
        }

        OrderedListNode<T> node = findLast(data);

        if (node == null) {
            return false;
        }

        if (node == head_) {
            head_ = head_.getNext();
        } else {
            OrderedListNode<T> prevNode = findPrevious(node);
            prevNode.setNext(node.getNext());
            
        }
        node.setNext(null);
        --size_;
        return true;
    }

    @Override
    public int indexOf(T data) {
        int index = -1;
        OrderedListNode<T> node = head_;
        for (; node != null; node = node.getNext()) {
            ++index;
            if (node.getData().compareTo(data) == 0) {
                break;
            }
        }
        return node == null ? -1 : index;
    }

    @Override
    public int lastIndexOf(T data) {
        int index1 = 0;
        OrderedListNode<T> node = head_;
        for (; node != null; node = node.getNext(), ++index1) {
            if (node.getData().compareTo(data) == 0) {
                break;
            }
        }
        if (node == null)
            return -1;
        int index2 = index1;
        for (; node != null; node = node.getNext(), ++index1) {
            if (node.getData().compareTo(data) == 0) {
                index2 = index1;
            }
        }
        return index2 < size_ ? index2 : -1;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size_) {
            throw new IndexOutOfBoundsException("" + i);
        }
        return find(i).getData();
    }
    
    private OrderedListNode<T> find(T data, OrderedListNode<T> startNode) {
        OrderedListNode<T> node = startNode;
        for (; node != null; node = node.getNext()) {
            if (node.getData().compareTo(data) == 0)
                break;
        }

        return node;
    }
    
    private OrderedListNode<T> find(int index) {
        int i = 0;
        OrderedListNode<T> node = head_;
        for (; node != null && i != index; node = node.getNext(), ++i) {}

        return node;
    }
    
    private OrderedListNode<T> findFirst(T data) {
        return find(data, head_);
    }
    
    private OrderedListNode<T> findLast(T data) {
        OrderedListNode<T> node = find(data, head_);
        while (node != null){
            OrderedListNode<T> nextNode = find(data, node.getNext());
            if (nextNode == null)
                break;
            else
                node = nextNode;
        }
        return node;
    }
    
    private OrderedListNode<T> findPrevious(OrderedListNode<T> node) {
        OrderedListNode<T> nextNode = head_;
        
        for (; nextNode != null && nextNode.getNext() != node; nextNode = nextNode.getNext()) {}
        
        return nextNode;
    }

    @Override
    public int size() {
        return size_;
    }

    @Override
    public boolean isEmpty() {
        return size_ == 0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("List: [");
        for (OrderedListNode<T> node = head_; node != null; node = node.getNext()) {
            if (node != head_) {
                buffer.append(", ");
            }
            buffer.append(node.getData());
        }
        buffer.append("]");
        return buffer.toString();
    }

}
