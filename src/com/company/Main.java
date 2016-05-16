package com.company;

import com.sun.javafx.geom.Point2D;
import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public abstract class Main implements Cloneable {


    public static void main(String[] args) throws InterruptedException {
        int [][] arr = {{1, 2, 3} ,{4, 8, 2},{1, 5, 3}};
ArrayList<Integer> a = new ArrayList<>();
ArrayList<Integer> b = new ArrayList<>();
  

        //4, 8, -7, -5, -13, 9, -7, 8
        //4, -15, -10, -3, -13, 12, 8, -8
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

//        a.add(4);
//        a.add(5);
//        a.add(6);
        System.out.println(firstMissingPositive(a));
//        a.add(8);b.add(-15);
//        a.add(-7);b.add(-10);
//        a.add(-5);b.add(-3);
//        a.add(-13);b.add(-13);
//        a.add(9);b.add(12);
//        a.add(-7);b.add(8);
//        a.add(8);b.add(-8);
       Scanner sc = new Scanner(System.in);

//        Trie trie = new Trie();
//        trie.insert("gaurav");
//        trie.insert("gaut");
//        System.out.println(trie.search(null));
//        System.out.println(trie.search("gaut"));
//        System.out.println(trie.search("gaur"));
//        System.out.println(trie.search("q"));
//        System.out.println(trie.search(null));

//        System.out.println(trie.root);

//        System.out.println(EqualHackerRank.equal(arr , arr.length-1 ,0));

//        redJohn(7);
//        TheMaximumSubarrayHackerrank.sumDP(arr);
//        AbstractImplementor ab = new AbstractImplementor(2);
//        ab.test();
//        HashMap.SimpleEntry c = new HashMap.SimpleEntry<String , String >("x" , "y");



//        testt("aab" , "aac");

//        System.out.println(LongestCommonSubSequence.lcs("HARRY","SALLY"));
//        countFrequency("aaaaabccigicgjihidfiejfijgidgbhhehgfhjgiibggjddjjd");
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.root = binaryTree.insert(binaryTree.root , 12);
//        binaryTree.root = binaryTree.insert(binaryTree.root , 3);
//        binaryTree.root = binaryTree.insert(binaryTree.root , 11);
//        binaryTree.root = binaryTree.insert(binaryTree.root , 2);
//        binaryTree.root = binaryTree.insert(binaryTree.root , 7);
//        binaryTree.root = binaryTree.insert(binaryTree.root , 13);
//        binaryTree.everyNodeIsSumOfItsGreaterNodeInBST();
//        func(new StringBuffer("ABCD"),1, 4);

//        int [][] realGrid = {{1,2,3},{4,5,6},{7,8,9}};
//        int [][] myGrid ={{4,5},{7,8}};
//        ReverseShuffleMerge.RSM("djjcddjggbiigjhfghehhbgdigjicafgjcehhfgifadihiajgciagicdahcbajjbhifjiaajigdgdfhdiijjgaiejgegbbiigida");
//                               //aaaaaabaaceededecbdb
//        convertToIntArray("123");
//        System.out.println(TheGridSearch.checkForGrid(realGrid , myGrid , 3,3,2,2));
//        String [][] strings ={{"you", "we"},
//                {"have", "are"},
//                {"sleep", "eat", "drink"}};
//        ArrayFunctions.printAllTheSentences(strings , "" , 0 , 3 ,3);

//       binaryTree.root = binaryTree.binaryTreeFromPostorderTraversal(arr );
//        System.out.println(binaryTree.root);

    }


    public static int firstMissingPositive(ArrayList<Integer> a) {

        int max = 20000;
        int largest = Integer.MIN_VALUE;
        for(int i =0 ; i < a.size() ; i++)
        {
            if(a.get(i) > largest)
                largest = a.get(i);
            if(a.get(i) > max)
                a.set(i,a.get(i)-max);
            if( a.get(i) > 0 && a.get(i) <= a.size() &&  a.get(i)-1>=0 && a.get(i)-1 < a.size())
                a.set(a.get(i)-1 ,max+a.get(a.get(i)-1));

        }
        for(int i = 0 ; i< a.size() ; i++)
        {
            if(  a.get(i) < max) {
                if (a.get(i)==i+1)
                    return i+1;
                return i + 1;
            }
        }
        return largest+1;
    }
    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {

        long max_now = 0 ;
        int start =0 ;
        int end =0;
        int resultStart =0;
        long current_max = 0;
        for (int i =0; i<a.size() ; i++)
        {
            if (a.get(i) < 0)
                continue;
            start =i;
            current_max =0 ;
            while(i < a.size() && a.get(i)>=0  )
            {
                current_max +=a.get(i);
                i++;
            }
            if( current_max == max_now)
            {
                if((end - resultStart ) <=  (i-1 - start))
                {
                    resultStart = start ;
                    end =i-1;
                }
            }
            if (current_max > max_now){
                resultStart =start;
                end =i-1;
                max_now =current_max;

            }

        }
        ArrayList<Integer> b = new ArrayList<>();
        for(int x= resultStart ; x <=end ; x++)
            b.add(a.get(x));
        int i =0;
        while (i < b.size() && b.get(i)  < 0){
            b.remove(i); i++;}
        return b;
    }




    public  void testt(String s1 , String s2)
    {
        TreeSet<StringBuffer> union = new TreeSet<>(new SbufferComparator());
        union.addAll(FindStringsIncludePowerSet.powerSet(s1));
        union.addAll(FindStringsIncludePowerSet.powerSet(s2));
        StringBuffer ss =new ArrayList<>(union).get(1);
        System.out.println();

    }



    public static void test()
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            int [][] realGrid = new int [R][C];
            for(int i = 0; i < R ; i ++)
                realGrid[i] = convertToIntArray(G[i]);
            int [][] myGrid = new int [r][c];
            for(int i = 0 ; i < r ; i++)
                myGrid[i] = convertToIntArray(P[i]);

            System.out.println(TheGridSearch.checkForGrid(realGrid ,myGrid , R ,C , r, c));
        }
    }
    public static int[] convertToIntArray(String numbers)
    {
        String[] parts = numbers.split("");
        int[] n1 = new int[parts.length];
        for(int n = 0; n < parts.length; n++) {
            n1[n] = Integer.parseInt(parts[n]);
        }
        return n1;
    }

    public static int longestPalandrom(String string) {
        int max = 1;
        int count=0;
        for (int i = 1; i < string.length() - 1; i++) {
            int prefix = i ;
            int suffix = i ;
            count = 1;
            while (suffix < string.length()-1 && string.charAt(suffix) == string.charAt(suffix + 1)) {
                suffix++;
                count++;
            }
            while (prefix >0 && string.charAt(prefix) == string.charAt(prefix - 1)) {
                prefix--;
                count++;
            }
            prefix--;
            suffix++;
            while (prefix >= 0 && suffix < string.length()
                    && string.charAt(prefix) == string.charAt(suffix)) {
                count += 2;
                prefix--;
                suffix++;
            }
            if (count> max)
                max = count;
        }
        return max;
    }

    public static int countComponents(int[][] matrix)
    {if (matrix == null || matrix.length == 0) return 0;
        int result = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    result++;
                    helper(matrix, i, j);
                }
            }
        }
        return result;
    }
    public static void helper(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >=matrix[0].length || matrix[row][col] == 0) {
            return;
        }
        matrix[row][col] = 0;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        for (int i=0; i<dr.length; i++) {
            helper(matrix, row + dr[i], col + dc[i]);
        }
    }

    private static void permutaion (String prefix  ,String str)
    {
        int n = str.length();
        if (n==0)
        {
            System.out.println(prefix);
        }
        else
        {
            for (int i =0 ; i < str.length() ; i++) {
                permutaion(prefix+str.charAt(i) ,str.substring(0,i) +str.substring(i+1,n));
            }
        }
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
                System.out.println( " i == " + i);
                System.out.println("prefix  == " + prefix + "  str == "+str );
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


    private static String removeConsecutiveDublicate(String str) {

        Stack<Character> stack = new Stack();
        stack.push(str.charAt(0));
        for(int i =1 ; i < str.length(); i++)
        {
            int k =i;
            if(!stack.isEmpty() && stack.peek()== str.charAt(i))
            {
                while (k < str.length()-1 && str.charAt(k)==str.charAt(k+1))
                    k++;
                stack.pop();
                i=k;
            }
            else
                stack.push(str.charAt(i));

        }
        return stack.toString();

    }

    //merge Sort

    private static int[] mergeSort(int [] list)
    {
        if (list.length <= 1) {
            return list;
        }

        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);


        }

    private static void test (int arr[])
    {
        arr[0]=11212;
    }

    private static int [] quicksort(int [] arr){
        int i , j =0;
        int last ;
        int pivot = arr.length-1;
        while (pivot > 0)
        {
            i=0;
            last=pivot-1;
            while (i < last)
            {
                if (arr[i] > arr[last])
                {
                    int temp = arr[i];
                    arr[i] = arr[last];
                    arr[last] = temp;
                    last--;
                }
                i++;
                            }
            if (arr[i] > arr[pivot])
            {
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
            }


            pivot--;
        }
        return arr;

    }

//    //TODO
//    private static void printAlternativeFromArray(int [] a , int [] b ,int m , int n , Boolean flag )
//    {
//
//    }

//    private static int [] [] rotateMatrix(int [][] matrix , int row , int col ,  int rotation)
//    {
//        int loop = row / 2;
//        int upperLeft=0;
//        int upperRight=col-1;
//        int lowerLeft=0;
//        int lowerRight=row-1;
//        for (int i =0 ;i < 2 ; i++)
//        {
//            int x=0;
//            int y=1;
//            int temp = 0;
//            while (y < col-2 )
//            {
//                temp =matrix[x][y];
//                matrix[x][y+1] = matrix[x][y];
//                y++;
//            }
//            y=0;
//            int firstTemp = temp;
//            while (x < row-2)
//            {
//                temp = matrix[0][col-1];
//                matrix[x+1][y] = matrix[x][y];
//                x++;
//            }
//            matrix[1][y] = firstTemp;
//            firstTemp = temp;
//
//        }
//    }

    private static int [][] swapMatrixVariable(int [][] matrix , int oRow , int oCol , int sRow , int sCol)
    {
        int temp = matrix[oRow][oCol];
        matrix[oRow][oCol] = matrix[sRow][sCol];
        matrix[sRow][sCol] = temp ;
        return matrix;
    }
    public static boolean brace(String s) {
        HashMap<Character, Character> myMap = new HashMap<Character, Character>();
        myMap.put('(', ')');
        myMap.put('[', ']');
        myMap.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (myMap.keySet().contains(curr)) {
                stack.push(curr);
            } else if (myMap.values().contains(curr)) {
                if (!stack.empty() && myMap.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static boolean braces(String s)
    {
        HashMap<Character, Character> myMap = new HashMap();
        myMap.put('(', ')');
        myMap.put('[', ']');
        myMap.put('{', '}');
        Stack<Character> stack = new Stack();
        for(int i =0 ;  i < s.length() ; i++)
        {
            char c=  s.charAt(i);
            if(myMap.keySet().contains(c))
            {
                stack.push(c);
            }
            else if(myMap.values().contains(c))
            {
                if(!stack.empty()  && myMap.get(stack.peek()) == c)
                {
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    static int [] reverse(int [] array)
    {
        if (array.length == 0 || array.length ==1)
        {return array;}
        int mid = array.length/2;
        for(int i =0 ; i< mid ; i++)
        {
            array = swapArray(array , i , array.length-i-1);
        }
        return array;
    }

    static int [] swapArray(int [] array ,int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    static String reverseString(String x)
    {
        StringBuilder reversedString = new StringBuilder();
        for (int i =x.length()-1 ; i >=0 ; i--)
            reversedString.append(x.charAt(i));
        return reversedString.toString();
    }

    static int findSecondLargest(int [] arr)
    {
        int max1=-1;
        int max2 =-1;
        for(int i =0 ; i< arr.length ;i++)
        {
            if (arr[i] > max1){
                max2= max1;
                max1=arr[i];
            }
            else
                if (arr[i]> max2)
                    max2 = arr[i];
        }
        return max2;
    }

    static int  removeDuplicates(int [] arr)
    {
        int x= 0;
        for (int i =0 ; i<=5; i++)
        {
            x=arr[i] ^ arr[i+1];
        }
        return x;
    }


    static int rodCuttingProblem(int [] price)
    {
        int [] max = new int [price.length+1];
        for(int i =1 ; i <=price.length ; i++)
        {
            for(int j =1 ; j <=price.length ; j++)
            {
                max[j] = Math.max(max[j] , max[j-1] + price[i-1]);
                System.out.println(max[j]);
            }
        }
        return max[price.length];
    }


    static int countNegativeInMatrix(int [][] matrix)
    {
        int count = 0;
        for (int i=0 ; i< matrix.length ; i++)
        {
            for (int j = matrix[0].length-1; j >=0 ; j--)
            {
                if (matrix[i][j] > 0)
                    continue;
                else
                {
                    count += (j+1);
                    break;
                }
            }
        }
        return count;
    }


    static int countBinarySearchTree(int [] arr)
    {
        int [] T = new int[arr.length+1];
        T[0] = 1;
        T[1] = 1;
        for (int i  =2 ; i<=arr.length ;i++)
        {
            for (int j =0 ; j<i ;j++)
            {
                T[i]+= T[j] * T[i-j-1];
            }
        }
        return T[arr.length];
    }


    static void towerOfHanoi(int n , char source , char destination , char help)
    {
        if (n>0)
        {
            towerOfHanoi(n-1 , source , help , destination);
            System.out.println("Move " + source + " to " + destination);
            towerOfHanoi(n-1 , destination, help,source);
        }

    }

    static void longestCommonSubsequence(String string1 , String string2)
    {
        int r= string1.length()+1;
        int c =string2.length()+1;
        int [][] T = new int[string1.length()+1][string2.length()+1];
        for (int i =1 ; i <r ;i++ )
        {
            for (int j =1 ; j< c;j++ )
            {
                if (string1.charAt(i-1) == string2.charAt(j-1))
                {
                    T[i][j] = T[i-1][j-1]+1;
                }
                else
                {
                    T[i][j] = Math.max(T[i-1][j] , T[i][j-1]);
                }
            }
        }
        System.out.println("Complete");
    }

    public static void longestIncreasingSubSequence(int []arr)
    {
        int []  T =new int[arr.length];
        for (int i =0 ; i < arr.length ;i++)
            T[i] =1;
       for(int i =1 ; i < arr.length ;i++)
       {
           for (int j = 0 ;j<i ; j++)
           {
               if (arr[i] > arr[j])
               {
                   T[i] = Math.max(T[j]+1 , T[i]);
               }
           }
       }
        System.out.print("Complete");
    }

    public static int editDistance(String s1 , String s2 , int m ,int n)
    {
        if (m==0)
            return m;
        if (n==0)
            return n;
        if (s1.charAt(m-1)==s1.charAt(n-1))
            return editDistance(s1 , s2 , m-1 , n-1);
        return 1+Math.min
                (Math.min(editDistance(s1 , s2 ,m,n-1),
                editDistance(s1 , s2 , m-1,n-1)) ,
                editDistance(s1 , s2 , m-1 ,n));
    }

    public static int editDisDP(String s1 , String s2 , int m , int n)
    {
        int [][] T = new int[s1.length()+1][s2.length()+1];
        int i =0 ;
        int j=0;
        for ( i = 0 ; i <=s1.length() ; i++ )
        {
            for ( j = 0 ; j <= s2.length() ; j++ )
            {
                if (i==0)
                    T[i][j] =j;
                else if (j==0)
                    T[i][j] =i;
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    T[i][j] = T[i-1][j-1];
                else
                    T[i][j] = 1+Math.min(Math.min(T[i][j-1] , T[i-1][j-1]),T[i][j-1]);
            }
        }
        return T[i][j];

    }


    static int max(int a , int b , int c ,int d)
    {
        int temp1 = Math.max(a,b);
        int temp2 = Math.max(c ,d);
        return Math.max(temp1 , temp2);

    }

    static int longestPath(int [][] matrix , int k ,int i , int j , int r ,int c)
    {
        int temp1=0,temp2=0 ,temp3=0,temp4 =0 ;
        if (i < 0 || j < 0 ||i == r || j == c)
            return 0;

            if (i < r-1 && matrix [i][j] == matrix[i+1] [j] -1 )
                    return longestPath(matrix,k+1 ,i+1 , j , r ,c);
            if (i > 0 && matrix [i][j] == matrix[i-1] [j] +1 )
                 return longestPath(matrix,k+1 ,i-1 , j , r ,c);
            if (j < c-1 && matrix [i][j] == matrix[i] [j+1] -1 )
                 return longestPath(matrix,k+1 ,i , j+1 , r ,c);
            if (j > 0 && matrix [i][j] == matrix[i] [j-1] +1 )
                 return longestPath(matrix,k+1 ,i , j-1 , r ,c);
            return k;
    }


    static int findLongestPathInMatrixDP(int [][] mat , int i , int j , int [][] dp , int n)
    {
        if (i < 0 || j < 0 ||i >= n || j >= n)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (j<n-1 && ((mat[i][j] +1) == mat[i][j+1]))
            return dp[i][j] = 1 + findLongestPathInMatrixDP(mat ,i,j+1,dp ,n);

        if (j>0 && (mat[i][j] +1 == mat[i][j-1]))
            return dp[i][j] = 1 + findLongestPathInMatrixDP(mat ,i,j-1,dp , n);

        if (i>0 && (mat[i][j] +1 == mat[i-1][j]))
            return dp[i][j] = 1 + findLongestPathInMatrixDP(mat,i-1,j,dp , n );

        if (i<n-1 && (mat[i][j] +1 == mat[i+1][j]))
            return dp[i][j] = 1 + findLongestPathInMatrixDP(mat,i+1,j,dp , n) ;
        return dp[i][j] = 1;
    }

    static int findLongestPath(int [][] arr  , int n)
    {
        int [][] dp = new int[n][n];
        int result =1;
        for (int i =0 ; i<n ;i++)
        {
            for (int j=0 ; j<n ;j++)
            {
                dp[i][j] =- 1;
            }
        }
        for (int i = 0 ; i< n ;i++)
        {
            for (int j = 0 ; j < n ;j++)
            {
                if (dp[i][j]==-1)
                    findLongestPathInMatrixDP(arr,i , j ,dp , 3);
                result = Math.max(dp[i][j] , result);
            }
        }
        return result;
    }

    static void allPalandromicPArtition(String s , int len , int i , String ans)
    {
        if (i ==len) {
            System.out.println(ans);
            return;
        }
        for (int j =i ; j < len ; j++)
        {
            if (isPalandrom(s , i , j));
            {
                StringBuilder temp = new StringBuilder(ans);
                if (temp.length() > 0)
                    temp.append(" ");
                temp.append(s,i,j-i+1);
                allPalandromicPArtition(s , j+1 , len , temp.toString());
            }
        }

    }

    private static Boolean isPalandrom(String str, int low, int high) {
        while (low < high)
        {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    private static void tripplets(int [] arr , int target)
    {
        int count = 0 ;
        if (arr.length <=2 )
            return;
        for (int i = 0 ; i < arr.length-2 ; i++)
        {
            int sum = arr[i] + arr[i+1];
            for (int j = i+2 ; j < arr.length ; j++)
            {
                if (sum + arr[j] < target)
                {
                    System.out.println(arr[i]  +" "+ arr[i+1] + " " + arr[j]);
                    count ++ ;
                }
            }
        }
    }


    public static String decode(String string){
        String result="";
        char[] s = string.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i=0,n=1;
        while(i<s.length){
            switch(s[i]){
                case 'I':
                    result=result+n;
                    while(!stack.isEmpty()){
                        result=result+stack.pop();
                    }
                    n++;i++;
                    break;
                case 'D':
                    stack.push(n);
                    n++;
                    i++;
                    break;
            }
        }
        result=result+n;
        while(!stack.isEmpty()){
            result= result+stack.pop();
        }
        System.out.println(result);
        return result;
    }
/*
*
* Input: arr1[] = {0, 1, 0, 0, 0, 0};
       arr2[] =   {1, 0, 1, 0, 0, 1};
Output: 4
The longest span with same sum is from index 1 to 4.
* */

//            int [] arr ={3, 34, 4, 12, 5, 2};

    public static void subsetSumProblem(int [] arr1 ,int size , int sum)
    {
        int res = 0 ;
        int i = 0;
        while (i < size)
        {
            res = arr1[i];
            System.out.println("adding " + arr1[i]);
            for (int j = 0 ; j < size ; j ++){
                if (res > sum)
                    break;
                if (i == j)
                    continue;
                if (res + arr1[j] > sum)
                    continue;
                if (res + arr1[j] < sum) {
                    res += arr1[j];
                    System.out.println("adding " + arr1[j]);
                }
                if (res == sum){
                    System.out.println("succues and res == " +sum);
                    break;
                }

            }
            System.out.println();
            System.out.println();
            System.out.println();
            i++;
        }

    }

    public static void palandrom(String prefix , String str)
    {
        int n = str.length();
        if (n == 0)
        {
            if(isPalandrom(prefix , 0 , n))
                System.out.println(prefix);
        }
        for(int i =0 ; i<str.length() ;i++)
        {
            palandrom(prefix+str.charAt(i)+str.substring(0,i) , str.substring(i+1,n) );
        }
    }


//    nitin
//    n i t i n
//    n iti n
//    nitin


    static void func(StringBuffer s,int b,int e){
        for(int i=b;i<e;i++){
            s.insert(i," ");
            System.out.println(s);
            func(s,i+2,s.length());
            s.delete(i,i+1);
        }
    }


    static void printSentencesRecusively(ArrayList<String> s1
            , ArrayList<String> s2 , ArrayList<String> s3
    ,int i , int j , int k)
    {
        if (i >= s1.size() || j >= s2.size() || k >= s3.size())
            return;

         printSentencesRecusively(s1, s2, s3, i+1, j, k ) ;
                 printSentencesRecusively(s1, s2, s3, i, j+1 , k );
                 printSentencesRecusively(s1, s2, s3, i, j , k+1 );
        System.out.println(s1.get(i) + " " + s2.get(j) + " " + s3.get(k));


    }

    public static void countFrequency(String s)
    {
        int [] arr = new int [26];
        for (int i = 0 ; i< s.length() ;i ++)
        {
            arr[s.charAt(i)-97]++;
        }
        for(int i = 0; i< 26 ; i++)
        {
            System.out.println((char)(i+97) + " -- " + arr[i]);
        }
    }


    int numberOfprimes(int n)
    {
        boolean [] prime= new boolean[n + 1];
        int count =0;
        for (int p=2; p*p<=n; p++)
        {
            if (prime[p])
            {
                for (int i=p*2; i<=n; i += p)
                    prime[i] = false;
            }
        }

        for (int p=2; p<=n; p++)
            if (prime[p])
                count++;
        return count;
    }

    public static int redJohn(int n)
    {
        if(n<4)
            return numberOfprimess(1);
        int [] arr = new int[n+1];
        arr[0]=arr[1]=arr[2]=arr[3]=1;
        for(int i = 4 ; i <=n ; i++)
            arr[i]=arr[i-1]+arr[i-4];
        return numberOfprimess(arr[n]);

    }

     private static int numberOfprimess(int n)
    {
        boolean [] prime= new boolean[n + 1];
        for (int i = 0;i<prime.length ;i++)
            prime[i]=true;
        int count =0;
        for (int p=2; p*p<=n; p++)
        {
            if (prime[p])
            {
                for (int i=p*2; i<=n; i += p)
                    prime[i] = false;
            }
        }

        for (int p=2; p<=n; p++)
            if (prime[p])
                count++;
        return count;
    }

    public static int minStepInMatrix(int [][] matrix , int i , int j )
    {
        if (i < 0 || j < 0   )
        {
            return Integer.MAX_VALUE;
        }
        else
        if (i ==0 && j == 0)
            return matrix[i][j];
        else
        return matrix[i][j] +Math.min(minStepInMatrix(matrix , i -1 , j ) , minStepInMatrix(matrix , i ,j-1));

    }
}