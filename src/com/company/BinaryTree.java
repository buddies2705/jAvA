package com.company;


import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by root on 19/4/16.
 */
public class BinaryTree {

    TreeNode root;

    BinaryTree() {
        root = null;
    }

    TreeNode insert(int data) {
        return insert(root, data);
    }

    TreeNode insert(TreeNode root, int data) {
        TreeNode temp = new TreeNode(data);
        if (root == null)
            return temp;
        if (root.data > data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    void print() {
        print(root);
    }

    void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }

    void verticalSum() {
        DoublyLinkedList dll = new DoublyLinkedList();
        DllNode node = new DllNode(0);
        dll.head = node;
        verticalSum(root, dll.head);
        while (dll.head.pre != null) {
            dll.head = dll.head.pre;
        }
        dll.print();
    }

    private void verticalSum(TreeNode root, DllNode head) {
        head.data += root.data;

        if (root.left != null) {
            if (head.pre == null) {
                head.pre = new DllNode(0);
                head.pre.next = head;
            }
            verticalSum(root.left, head.pre);
        }
        if (root.right != null) {
            if (head.next == null) {
                head.next = new DllNode(0);
                ;
                head.next.pre = head;
            }
            verticalSum(root.right, head.next);
        }

    }

    void printRightMostAndLeftMostNodes() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        printRightMostAndLeftMostNodes(root, queue);
    }

    //@TODO do it
    private void printRightMostAndLeftMostNodes(TreeNode root, Queue<TreeNode> que) {
        Boolean isFirst = false;
        TreeNode node = que.poll();

    }

    Boolean ifTreeCanBedivideInTwo(TreeNode root, int n) {
        if (root == null)
            return false;

        if (count(root) == n - count(root))
            return true;

        return ifTreeCanBedivideInTwo(root.left, n) || ifTreeCanBedivideInTwo(root.right, n);

    }

    boolean checkifTreeCanBedivideInTwo(TreeNode root) {
        int n = count(root);
        return ifTreeCanBedivideInTwo(root, n);
    }


    int count(TreeNode root) {
        if (root == null)
            return 0;
        return count(root.left) + count(root.right) + 1;
    }


    int sumOfUnnConeredNode() {
        return  getTotalSumOfATreeNodesData(root) - sumOfUnConeredNode(root);
    }

    private int sumOfUnConeredNode(TreeNode root) {
        int sum = 0 - root.data;
        TreeNode anotherRoot = root;
        while (root != null) {
            sum += root.data;
            if (root.left == null)
                root = root.right;
            if (root!=null)
            root = root.left;

        }

        while (anotherRoot != null) {
            sum += anotherRoot.data;
            if (anotherRoot.right == null) {
                anotherRoot = anotherRoot.left;
            }
            if (anotherRoot!=null)
                anotherRoot = anotherRoot.right;
        }
        return sum;
    }

    private int getTotalSumOfATreeNodesData(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;

        return getTotalSumOfATreeNodesData(root.left) + getTotalSumOfATreeNodesData(root.right) + root.data;
    }

     TreeNode lca(TreeNode root , int a , int b)
    {

        if (root == null)
            return null;
            if (root.data == a || root.data == b){
            return root;
            }
        else {
                TreeNode l = lca(root.left, a, b);
                TreeNode r = lca(root.right, a, b);
            if (l != null && r != null)
                return root;

            else if (l != null)
                return l;
            else return r;
        }
    }





}
