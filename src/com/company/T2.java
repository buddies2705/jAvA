package com.company;

/**
 * Created by root on 23/4/16.
 */
public class T2 extends Thread {

    Chat m;
    String [] s1 = {"Hi" ,"I am fine , how about you ?" , " Great !"};

    T2(Chat m1)
    {
        this.m= m1;
        new Thread(this,"Answer").start();
    }

    public void run()
    {
        for(int i =0 ; i< s1.length ;i++)
        {
            m.answer(s1[i]);
        }
    }
}
