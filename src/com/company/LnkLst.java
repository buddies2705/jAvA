package com.company;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by root on 17/4/16.
 */
public class LnkLst
{
    Node start;

    LnkLst()
    {
        start = null;
    }

    public void insert(int n)
    {
        Node temp = new Node(n);
        if (start == null) {
            start = temp;
            return;
        }
        Node current = start;
        // starting at the head node, crawl to the end of the list
        while(current.getNext() != null)
        {
            current = current.getNext();
        }
        // the last node's "next" reference set to our new node
        current.setNext(temp);

    }



    public void print()
    {
        print(start);

    }

    private void print(Node start) {
        if (start == null)
        {
            return;
        }
        System.out.println(start.getData());
        print(start.getNext());
    }

    public void add1ToLinkedList(int number)
    {
         add1ToLinkedList(number , start);
    }

    public int add1ToLinkedList(int carry , Node start) {
        if (start == null)
            return 0;
        add1ToLinkedList(carry, start.getNext());
        int returnValue =0 ;
            start.data = start.data + carry;
            if (start.data == 10) {
                start.data = 0;
                returnValue=  1;
            } else
                returnValue = start.data % 10;

        return returnValue;
    }

    public void swap()
    {
        Node current = start;
        while (current  != null && current.next != null)
        {
            int k = current.data;
            current.data = current.next.data;
            current.next.data = k ;
            current = current.next.next;

        }
    }


    public Node groupWiseReverse(Node head , int k) {
        Node current = start;
        Node next = null;
        Node pre = null;
        int i = 0;
        while (i < k && current != null)
        {
            next = current.next;
            current.next = pre;
            pre = current;
            current =  next;
            i ++ ;
        }
        if (next != null)
        {
            start.next = groupWiseReverse(next , k);
        }
        return pre;
    }

    private Node reverse(Node current, Node temp) {
        if (current != temp && current.next == temp) {
            return current;
        }
        Node remaining = reverse(current.next ,temp);
        current.next.next = current;
        current.next = null;
        return remaining;

    }


    public int getLength(Node temp)
    {
        int count =0;
        while(temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public Node reverseList()
    {
        Node current  = start;
        Node pre = null;
        Node next = null ;
        while(current != null ) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;

    }

    public void middle()
    {
        Node slow = start ;
        Node fast = start;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow= slow.next;
        }
        System.out.println(slow.data);
    }

    public void detectLoop()
    {
        Node slow = start ;
        Node fast = start;
        int flag= 0;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow= slow.next;
            if (fast == slow){
                System.out.println("Yes");
                flag =1;
                break;
            }

        }
        if (flag == 0)
        {
            System.out.println("No");
        }

    }

    public Boolean isPalendrom(Node node)
    {
        if (node == null || node.next==null )
        {
            if (start.data ==node.data)
            {start=start.next;
            return true;
            }
            else
                return false;
        }
        return isPalendrom(node.next);
    }

        Node pairWiseSwap() {
            Node current = start;
            while (current != null && current.next != null)
            {
                int k = current.data;
                current.data = current.next.data;
                current.next.data = k;
                current = current.next.next;
            }
            return start;

        }

    public Node deleteNodeRightSideOfGreaterValue()
    {
        Node current = start;
        Node prv = start;
        if (current==null)
            return current;
        while (current != null && current.next != null)
        {
            if (current.data < current.next.data)
            {
                if (current==start) {
                    start = current.next;
                    prv = start;
                }
                else
                {
                    prv.next = current.next;
                }

            }
            else {
                prv = current;
            }
            current = current.next;
        }
        return start;
    }



}
