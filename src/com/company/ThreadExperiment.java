package com.company;

/**
 * Created by root on 23/4/16.
 */
public class ThreadExperiment implements Runnable {

    public Thread thread = null;
    @Override
    public void run() {
        System.out.println("Starting ");
        for (int i = 0; i < 2; i++) {
            System.out.println("state is " + thread.getState());
            try {
                System.out.println("Thread is going to Sleep");
                Thread.sleep(100L);
                System.out.println("state is " + thread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("state is " + thread.getState());

    }

    public void start()
    {
        if (thread == null)
        {
            thread = new Thread(this,"myThread");
            System.out.println("state is " + thread.getState());
            thread.start();
        }
        System.out.println("state is " + thread.getState());

    }

}
