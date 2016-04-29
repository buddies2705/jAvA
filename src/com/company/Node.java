package com.company;

/**
 * Created by root on 17/4/16.
 */
public class Node {
    Node next;
    int data ;
    Node scr;
    Node dest;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }

    public  Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    public Node()
    {
        this.next = null;
        this.data =0;
    }
}

