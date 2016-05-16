package com.company;

/**
 * Created by root on 4/5/16.
 */
public class ClosestLeaf {


    public static int closestLeafUtil(TreeNode root , int data)
    {
        TreeNode[] ancestors = new TreeNode[100];
        return closetLeafImpl(root,ancestors , data , 0);
    }

    private static int closetLeafImpl(TreeNode root , TreeNode [] ancestors , int data , int index)
    {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.data == data)
        {
            int res = closestBelow(root);

            for (int i =index-1 ; i >=0 ; i--)
            {
                res = Math.min(res , index-i + closestBelow(ancestors[i]));
            }
            return res;
        }
        ancestors[index] = root;
        return Math.min(closetLeafImpl(root.left , ancestors , data,index+1) ,
                closetLeafImpl(root.right , ancestors , data ,  index+1));
    }

    private static int closestBelow(TreeNode root) {

        if (root == null)
            return Integer.MAX_VALUE;
        if (root.left == null && root.right ==null)
            return 0;
        return 1+Math.min(closestBelow(root.left) ,closestBelow(root.right));
    }
}
