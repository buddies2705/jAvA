package com.company;

/**
 * Created by root on 23/4/16.
 */
 class Chat {

    Boolean flag = false;
    public synchronized void question(String s1)
    {
        if (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(s1);
        flag = true;
        notify();
    }

    public synchronized void answer(String s1)
    {
        if (!flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(s1);
        flag =false;
        notify();
    }
}
