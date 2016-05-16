package com.company;

/**
 * Created by root on 6/5/16.
 */
public class EqualHackerRank {
    public static int equal(int [] arr  , int i , int x)
    {
            for (int j = 0 ; j < arr.length ; j++)
                System.out.print(" " + arr[j]);
            System.out.println();
            if (i< 0)
                return 0;
                arr[i]+=x;
            if (equalize(arr))
             return 0;
            return 1 + min(equal(arr , i-1 ,1) ,
                    equal(arr , i-1 , 3) ,equal(arr,i-1 , 5));

    }

    private static boolean equalize(int [] arr) {
        int x =arr[0];
        for (int i =1 ;i < arr.length ; i++)
        {
            if (x != arr[i])
                return false;
        }
        return true;
    }

    public static int min(int a , int b , int c)
    {
        return   a < b ? (a < c ? a : c) : (b < c ? b : c) ;
    }


}
