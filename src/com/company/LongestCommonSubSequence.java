package com.company;

/**
 * Created by root on 5/5/16.
 */
public class LongestCommonSubSequence {

    public static int lcs(String s1 , String s2)
    {
        int [][] T = new int[s1.length()+1][s2.length()+1];

        for(int i = 1 ; i <=s1.length() ; i++)
        {
            for(int j = 1 ; j <=s2.length() ; j++)
            {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                {
                    T[i][j] = T[i-1][j-1]+1;
                }
                else
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
            }
        }
        return T[s1.length()][s2.length()];
    }

}
