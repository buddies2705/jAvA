package com.company;

/**
 * Created by root on 23/4/16.
 */
public class GuessNumber extends Thread {

    public int actual;
    private String threadName = "guessNumber";
    public void run()
    {
        int guess =0;
        int counter=0;
        do {
            guess = (int) (Math.random()*100+1);
            System.out.println(this.getName() + " guess " + guess);
            counter++;
        }while (actual!=guess);
        System.out.println(this.getName() +" tooks " + counter +" times to guess the number");
    }



}
