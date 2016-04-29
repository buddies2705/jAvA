package com.company;

/**
 * Created by root on 23/4/16.
 */
public class ThreadSycnExperimant extends Thread {

    public Thread thread;

    public PrintDemo printDemo ;

    ThreadSycnExperimant(PrintDemo printDemo)
    {
        this.printDemo = printDemo;
    }

    public void run()
    {
        synchronized (printDemo){
        printDemo.printCount();}
        System.out.println("Thread " +  this.getName() + " exiting.");

    }

    public void start()
    {
        if (thread ==null)
        {
            thread = new Thread(this);
            thread.start();
        }
    }

}
