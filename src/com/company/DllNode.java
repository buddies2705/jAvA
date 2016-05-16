package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * Created by root on 19/4/16.
 */
class DllNode implements Iterable<DllNode>{

    int data;
    DllNode next;
    DllNode pre;


    public DllNode(int data) {
        this.data = data;
        this.next = null;
        this.pre = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    @Override
    public Iterator<DllNode> iterator() {
        return new Iterator<DllNode>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public DllNode next() {
                return null;
            }
        };
    }
}
