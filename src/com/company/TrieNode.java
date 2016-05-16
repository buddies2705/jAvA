package com.company;

import sun.text.normalizer.Trie;

import java.util.HashMap;

/**
 * Created by root on 8/5/16.
 */
public class TrieNode {

    private Boolean end ;
    private HashMap<Character , TrieNode> children = null;
    private Character ch = null;

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    TrieNode( )

    {
        end = false;
        children = new HashMap<>();
        ch = (char) 0;
    }

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }
}
