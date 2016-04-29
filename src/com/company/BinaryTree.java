package com.company;


import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.reflect.generics.tree.Tree;

import java.util.*;

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
        return getTotalSumOfATreeNodesData(root) - sumOfUnConeredNode(root);
    }

    private int sumOfUnConeredNode(TreeNode root) {
        int sum = 0 - root.data;
        TreeNode anotherRoot = root;
        while (root != null) {
            sum += root.data;
            if (root.left == null)
                root = root.right;
            if (root != null)
                root = root.left;

        }

        while (anotherRoot != null) {
            sum += anotherRoot.data;
            if (anotherRoot.right == null) {
                anotherRoot = anotherRoot.left;
            }
            if (anotherRoot != null)
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

    TreeNode lca(TreeNode root, int a, int b) {

        if (root == null)
            return null;
        if (root.data == a || root.data == b) {
            return root;
        } else {
            TreeNode l = lca(root.left, a, b);
            TreeNode r = lca(root.right, a, b);
            if (l != null && r != null)
                return root;

            else if (l != null)
                return l;
            else return r;
        }
    }

    TreeNode constructTreeFromPostOrderTraversal(int[] arr, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            return new TreeNode(arr[end]);
        }
        TreeNode root = new TreeNode(arr[end]);
        int mid = end - 1;
        while (arr[mid] > arr[end]) {
            mid--;
            if (mid == start)
                break;
        }
        root.left = constructTreeFromPostOrderTraversal(arr, start, mid);
        root.right = constructTreeFromPostOrderTraversal(arr, mid + 1, end - 1);
        return root;
    }

    int biggestBinaryTree() {
        return biggestBinaryTree(root, -1);
    }

    int biggestBinaryTree(TreeNode root, int max) {

        if (root == null)
            return 0;
        int p = checkBST(root);
        if (max < p)
            max = p;
        return max;

    }

    private int checkBST(TreeNode root) {
        int l = 0;
        int r = 0;
        if (root == null)
            return 0;
        if (root.left != null && root.left.data < root.data)
            l = checkBST(root.left);
        if (root.right != null && root.right.data > root.data)
            r = checkBST(root.right);
        return l + r + 1;

    }

    private int maxDiff()
    {
        return maxDiff(root , 0);
    }

    private int maxDiff(TreeNode root , int max) {
        if (root ==null)
            return Integer.MAX_VALUE;
        if (root.right == null && root.left == null)
            return root.data;
        int val = Math.min(maxDiff(root.left , max), maxDiff(root.right , max) );
        max = Math.max(max,root.data - val);
        return Math.min(val,root.data);
    }

    public int maxPathSum()
    {
        return maxPathSum(root, -1000);

    }

    private int maxPathSum(TreeNode root , int max)
    {
        if (root ==null)
            return 0;
        int l =  maxPathSum(root.left ,max);
        int r =  maxPathSum(root.right ,max);
        int max_single = Math.max(Math.max(l,r)+root.data,root.data);
        int max_top = Math.max(max_single , l+r+root.data);
        max = Math.max(max, max_top);
        return max_single;
    }

    //Its is bottom view using vertical sum logic
    void verticalSumMine()
    {
        DoublyLinkedList list =  new DoublyLinkedList();
        list.head = new DllNode(root.data);
        verticalSum(list.head , root);
        while (list.head.pre!=null)
            list.head = list.head.pre;
        while (list.head != null) {
            System.out.println(list.head.data);
            list.head = list.head.next;
        }
    }

    void verticalSum( DllNode head, TreeNode root )
    {
        if (root== null)
            return;
       if (root.left!=null) {

           if (head.pre == null){
               head.pre = new DllNode(root.left.data);
           head.pre.next = head;
       }else
           {
               head.pre.data=root.left.data;
           }
           verticalSum(head.pre , root.left);
       }
        if (root.right != null)
        {
            if (head.next ==null)
            {
                head.next = new DllNode(root.right.data);
                head.next.pre =head;
            }
            else
            {
                head.next.data = root.right.data;
            }
            verticalSum(head.next , root.right);
        }

    }

    public void topView()
    {
        int [] arr = new int[10];
       topView(root,arr , 5);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }

    private int[] topView(TreeNode root , int[] arr , int h)
    {
        if (root==null)
            return arr;
        topView(root.left ,arr , h-1);
        topView(root.right , arr ,h+1);
        arr[h] = root.data;

        return arr;

    }

    public void lcaOfTree( int a, int b)
    {
        lcaOfTree(this.root,a,b );
    }

    private TreeNode lcaOfTree(TreeNode root, int a, int b) {
        TreeNode l = null;
        TreeNode r = null;
        if (root == null)
            return null;
        if (root.data == a || root.data == b) {
            return root;
        } else {
            l = lcaOfTree(root.left, a, b);
            r = lcaOfTree(root.right, a, b);
            if (l != null && r != null)
                return root;
            else if (l != null)
                return l;
            else return r;

        }

    }



}




/*
* lopappol
*thirocare
* ujjawal finance
*
*   l o p a p p o l
* l 1 1 1 1
* o
* p
* a
* p
* p
* o
* l
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */



