package com.company;

/**
 * Created by root on 23/4/16.
 */
public class T1 extends Thread {

    Chat m;
    String [] s1= {"Hi" , "How are you ?" , "I am Also Doing Fine"};
    public T1(Chat m1)
    {
        this.m=m1;
        new Thread(this,"Question").start();
    }

    public void run()
    {
        for (int i=0;i< s1.length; i++)
        {
            m.question(s1[i]);
        }
    }
}
