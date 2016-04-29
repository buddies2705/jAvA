package com.company;

import java.lang.reflect.Array;
import java.util.*;

public abstract class Main implements Cloneable {


    public static void main(String[] args) throws InterruptedException {


        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root=  binaryTree.insert(25);
        binaryTree.root = binaryTree.insert(8);
        binaryTree.root =binaryTree.insert(120);
        binaryTree.root =binaryTree.insert(80);
        binaryTree.root =binaryTree.insert(90);
        binaryTree.root =binaryTree.insert(110);
        int [] arr = {5 , 1 , 3 , 4 , 7};
        tripplets(arr,12);

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

}