package com.company;

/**
 * Created by root on 4/5/16.
 */
public class TheGridSearch {


    public static String checkForGrid(int [][] realGrid , int [][] myGrid , int R , int C , int r , int c)
    {
        for(int i = 0 ; i < R ; i++)
        {
            for(int j = C-1 ; j >= c-1 ; j --)
            {
                if(realGrid[i][j] == myGrid[0][c-1])
                {
                    int matchStart = j-c+1;
                    int count =0;
                    for(int a = 0 ; a < r ; a ++)
                    {
                        for(int b = 0 ; b < c ; b++)
                        {
                            if(realGrid[i+a][matchStart+b] == myGrid[a][b])
                                count++;
                            else
                                break;
                        }
                    }
                    if(count >= r*c)
                        return "YES";
                }

            }
        }
        return "NO";
    }

}
