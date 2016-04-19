package com.company;

/**
 * Created by root on 19/4/16.
 */
public class TreeNode {
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    int data;
    TreeNode left;
    TreeNode right;
}
