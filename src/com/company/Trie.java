package com.company;

/**
 * Created by root on 8/5/16.
 */
public class Trie {

    TrieNode root = null;

    Trie()
    {
        root = new TrieNode();
    }

    public void insert(String input)
    {
        TrieNode start = root;
        for(int i  =0 ; i < input.length() ; i++)
        {
            if (start.getChildren().containsKey(input.charAt(i)))
            {
                start = start.getChildren().get(input.charAt(i));
            }
            else
            {
                TrieNode temp = new TrieNode();
                temp.setCh(input.charAt(i));
                start.getChildren().put(input.charAt(i) , temp);
                start = temp;
            }
        }
        start.setEnd(true);

    }


    public Boolean search(String input)
    {
        if (input==null)
            return false;
        return search(input ,root ,0);
    }

    private Boolean search(String input, TrieNode root , int i) {
        if (i >= input.length()) {
            return root.getEnd();
        }
        if (root == null  || (!root.getChildren().containsKey(input.charAt(i))) )
            return false;
        if (root.getChildren().containsKey(input.charAt(i)) )
        {
            return search(input , root.getChildren().get(input.charAt(i) ), i+1);
        }
        return false;
    }
}
