package com.company;

/**
 * Created by root on 6/5/16.
 */
public class TheMaximumSubarrayHackerrank {

//
//    public static long sum (long [] arr , long i  , long sum)
//    {
//       if (i == arr.length-1)
//           return arr[i];
//        if(arr[i] > 0) {
//            sum += arr[i];
//            return sum(arr, i + 1, sum);
//        }
//        else {
//            sum+= Math.max(sum(arr, i + 1, sum), sum);
//            return sum;
//        }
//
//    }

    public static void sumDP(long [] a)
    {
        long max_so_far = a[0];
        long curr_max = a[0];
        long sum = a[0];

        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
            if (a[i] > 0)
                sum+=a[i];
        }

        System.out.println(max_so_far + " "+ sum);
    }
}
