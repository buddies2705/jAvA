package com.company;

/**
 * Created by root on 5/5/16.
 */
public class ReverseShuffleMerge {

    public static void RSM(String s)
    {
        int [] fre = new int[26];
        int [] a = new int [26];
        int aSize = s.length()/2;
        StringBuffer A =new StringBuffer("");
        for(int i = 0 ; i < s.length() ;i++)
            fre[s.charAt(i) - 97 ]++;
        for(int i = 0 ; i< 26 ; i++)
            a[i] = fre[i]/2;
        for(int i = s.length()-1 ; i >= 0 ; i--)
        {
            if(A.length() < aSize && fre[s.charAt(i) -97] == a[s.charAt(i) -97] ){
                A.append(s.charAt(i));
                fre[s.charAt(i)-97]--;
                a[s.charAt(i) -97] --;
                continue;
            }
            else if (a[s.charAt(i) -97] > 0 && A.length() < aSize && isSmallest(s.charAt(i) , fre , a))
            {
                A.append(s.charAt(i));
                fre[s.charAt(i)-97]--;
                a[s.charAt(i) -97] --;
            }
            else if(A.length() < aSize) fre[s.charAt(i)-97]--;
        }
        System.out.println(A);

    }

    private static boolean isSmallest(char c , int [] fre , int [] a) {
        int index = c - 97;
        for(int i = 0 ; i<index ; i++)
        {
            if(fre[i] !=0 &&  fre[i] != a[i] )
                return false;
        }
        return true;
    }
        //TODO
//    private static boolean ifMatch(String s ,int index , int [] fre  , int [] a , int aSize)
//    {
//        for(int i=s.length()-1; i >= aSize ; i++ )
//        {
//
//        }
//    }
}





