package com.company;

/**
 * Created by root on 4/5/16.
 */
public class ArrayFunctions {


    public static void printAllTheSentences(String [][] str , String prefix , int len , int r , int c)
    {
        if (len == r){
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < str[len].length ;i++)
        {
            if (!str[len][i].equals(""))
            {
                printAllTheSentences(str , prefix+" "+str[len][i] , len+1 , r, c );
            }

        }

    }
}
