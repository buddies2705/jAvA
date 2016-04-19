package com.company;

/**
 * Created by root on 19/4/16.
 */
public class DllNode {

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
}
