package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String myString = "c    ";
        String string1 = "AB";
        String string2 = "CD";
////        checkIfRotaionalOfString(string1,string2);
////        validParanthesis(string1);
////        System.out.print(removeAdjcentDuplicateCharacter(myString));
//        char [] string = {'key' , 'value' , 'c'};
//        char [] arr =  (string1 + string2 ).toCharArray();
//       for (String s : interleave(string1 , string2)){System.out.println(s);};
//
////            allPermutation("",myString);
////       allPermutaionWithRepetition(string , new char[3] , string2.length()-1 ,0);
////        printRecursively(myString,myString.length());
//        lexographicRanking("","abc","acb", 1  );
//
//        longestPalandromic(string1);
//        longestPalandromic("forgeeksskeegfor");
//        LnkLst list = new LnkLst();
//        list.insert(11);
//        list.insert(19);
//        list.insert(9);
//        list.insert(4);
//        list.start = list.deleteNodeRightSideOfGreaterValue();
////        System.out.print(list.isPalendrom(list.start));
////        list.start = list.reverseList();
////        list.start = list.groupWiseReverse(list.start, 3);
////        list.swap();
////        list.add1ToLinkedList(1);
//        list.print();

        BinaryTree binaryTree = new BinaryTree();
       binaryTree.root=  binaryTree.insert(100);
       binaryTree.root = binaryTree.insert(80);
        binaryTree.root =binaryTree.insert(120);
        binaryTree.root =binaryTree.insert(78);
        binaryTree.root =binaryTree.insert(90);
        binaryTree.root =binaryTree.insert(110);
        binaryTree.root =binaryTree.insert(130);
        TreeNode x= binaryTree.lca(binaryTree.root , 110 , 130);
//        ArrayList<Pairs> arr = new ArrayList<>();
//        arr.add(new Pairs(11,20));
//        arr.add(new Pairs(30,40));
//        arr.add(new Pairs(5,10));
//        arr.add(new Pairs(40,30));
//        arr.add(new Pairs(10,5));
////        ArrayList<Pairs> result = getSymetricPairs(arr);
//        System.out.println(binaryTree.sumOfUnnConeredNode());
//        if (binaryTree.checkifTreeCanBedivideInTwo(binaryTree.root))
//            System.out.print("Yes");
//        else
//            System.out.println("No");
//       binaryTree.print();


        System.out.println("No");
    }


    private static  ArrayList<Pairs> getSymetricPairs(ArrayList<Pairs> arr)
    {
        HashMap<Integer , Integer> hashMap = new HashMap<>();
        ArrayList<Pairs> result = new ArrayList<>();
        for (int i = 0 ; i < arr.size() ; i ++)
        {
            if (hashMap.containsKey(arr.get(i).value ))
            {
                int x= hashMap.get(arr.get(i).value);
                if (arr.get(i).getKey()==x){
                    result.add(arr.get(i));
                }
                else
                    hashMap.put(arr.get(i).key , arr.get(i).value);

            }
            else
                hashMap.put(arr.get(i).key ,arr.get(i).value);
        }
        return result;
    }


    private static void longestPalandromic(char [] chars) {
        int max_len = 0;
        String longestStr = null;
        boolean [][] table = new boolean[chars.length][chars.length];
        for (int i=0; i < chars.length ;i++ )
        {
            for(int j =0 ; j < chars.length ; j++)
            {
                table[i][j] = true;
            }
        }
        for(int i = 0 ; i < chars.length-1 ; i++)
        {
                if (chars[i] == chars[i+1])
                {
                    table[i][i+1] = true;
                    longestStr= String.valueOf(chars[i] + chars[i+1]);
                }

        }

        for (int k=3 ; k < chars.length ; k++)
        {
            for (int i = 0 ; i < chars.length -k ; i++)
            {
                int j = i + k -1;
                if (chars [i] == chars [j])
                {
                    table[i][j] = table[i+1][j-1];
//                    if (table[i][j] == true && k > max_len)
////                        longestStr = getArray(chars , i , j+1);
//                    else
//                    table[i][j]= false;

                }
            }
        }

    }

    /*
    "" "abc"
    "key" "ab"
        ABC

        A
     */
    public static  void lexographicRanking(String prefix , String string  , String result ,int count  )
    {
        if (string.length() ==0){
            System.out.println(prefix);
            count++;
            if (prefix.equals(result))
                System.out.println(count);
        }
        for (int i =0 ; i < string.length() ; i++)
        {
             lexographicRanking(prefix + string.charAt(i),string.substring(0,i)+string.substring(i+1,string.length()),result , count);
        }
    }



    //TODO come again here .
    public static int coinDenomination(int n , int m , int [] arr)
    {
        if (n==0)
            return 1;
        if (n< 0)
            return 0;
        if (n>0 && m<=0)
            return 0;
        return coinDenomination(n,m-1,arr) + coinDenomination(n-arr[m-1],m,arr);

    }

    private static void printRecursively(String string , int n)
    {
        if(n==0) {
            return;
        }
        printRecursively(string,n-1);
        System.out.print(string.charAt(n-1));
    }

//0,2
    private static void allPermutation(String prefix , String str)
    {
        int n = str.length();
        if (n==0)
        {
            System.out.println(prefix);
            return;
        }
        for (int i =0 ; i < n ; i++){
            {
                allPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));

            }
        }

    }

    private static void allPermutaionWithRepetition(char [] str , char [] chars  , int last , int index)
    {

        for (int i = 0 ; i< str.length ; i++)
        {
            chars[index] = str [i];
            if (index==last)
                System.out.println(chars);
            else
                allPermutaionWithRepetition(str , chars , last , index+1);
        }
    }

    public static List<String> interleave(String s, String t) {
        List<String> result = new ArrayList<String>();
        if (t.isEmpty()) {
            result.add(s);
        } else if (s.isEmpty()) {
            result.add(t);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                char c = t.charAt(0);
                String left = s.substring(0, i);
                String right = s.substring(i);
                for (String u : interleave(right, t.substring(1))) {
                    result.add(left + c + u);
                }
            }
        }
        return result;
    }








    private static void swap(char [] string ,int n ,int m )
    {
        char temp = string[n];
        string[n] = string[m];
        string[m] = temp ;

    }




    private static void validParanthesis(String string1) {
        Stack<Character> stack = new Stack<>();
        int i =0 ;
        while (i < string1.length())
        {
            stack.push(string1.charAt(i));
            i++;
        }

        char last =stack.pop();
        char current ;
        int op =1;
        int count=0;
        while (!stack.isEmpty())
        {
            current =stack.pop();
            if(getOpposite(current)==last) {
                while (op > 0) {
                    count++;
                    op--;
                }
            }
            else
                op++;

        }
        System.out.print(count);
    }


    private static char getOpposite(char current) {
        if (current == '(')
            return ')';
        else
            return '(';
    }


    private static String removeAdjcentDuplicateCharacter(String string )
    {
        if ( 0 == string.length() )return "-1";

        char lastchar = string.charAt(0);
        int position = 0;
        int i =1;
        for ( i = 1; i < string.length();i++){
            if ( lastchar == string.charAt(i)){
                position++;
                continue;
            }else{
                lastchar = string.charAt(i);
            }
            if ( position > 0){
                break;
            }
        }
        if ( position == 0){
            return string;
        }else{
            return removeAdjcentDuplicateCharacter(
                    string.substring(0,i-(position+1))  + string.substring(i,string.length()));
        }
    }

    // ABAD CDAB -true
    public static void checkIfRotaionalOfString(String string1 ,String string2)
    {
        if (string1.length() != string2.length())
            System.out.print("No");
        int len = string1.length();
        int flag=0;
        for (int i =0 ; i< len;i++) {
            int j = 0;
            while (string1.charAt(i) == string2.charAt(j)) {
                i++;
                j++;
                if (j == len) {
                    flag = 1;
                    break;
                }
                if (j< len && i >= len) {
                    i = 0;
                }
            }
            if (flag==1)
                break;
        }
            if (flag ==1)
            {
                System.out.print("Yes");
            }
            else
            {
                System.out.print("No");


        }
    }


//    public static int sum(Node list1 , Node list2 , int carry)
//    {
//        if (list1 == null)
//            return 0;
//        if (list2 == null)
//            return 0;
//        int sum=0;
//        sum
//    }


    public static void generateAllSubarray(int [] x)
    {
        int n = x.length;
        int pow = (int) (Math.pow(2,x.length) -1);
        for (int i = 0 ; i < x.length ; i ++)
        {
            for (int j = 0 ; j < x.length ; j++ )
            {
                Boolean p = false;
                int o = i & (1<<j);
                if (o>=1)
                    p = true;
                else
                    p = false;
                if (p) {
                    System.out.println(x[j]);
                }
                System.out.println();
            }

        }
    }


//    private static String move(String string, int first) {
//
//
//
//    }
}
