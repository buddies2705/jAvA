package com.company;

/**
 * Created by root on 19/4/16.
 */
public class DoublyLinkedList {

    DllNode head;

    DoublyLinkedList(){
        head = null;
    }

    void print()
    {
         print (head);
    }

    private void print(DllNode head) {
        while (head!=null) {
            System.out.println(head.data);
            head= head.next;
        }
    }


}
