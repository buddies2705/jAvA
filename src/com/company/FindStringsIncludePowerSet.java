package com.company;

import java.util.*;

/**
 * Created by root on 5/5/16.
 */
public class FindStringsIncludePowerSet {

    public static SortedSet powerSet(String s) {

        HashSet<StringBuffer> set = new HashSet<>();
        set.add(new StringBuffer(""));
        for (int i = 0; i < s.length(); i++) {
            List<StringBuffer> currentList = new ArrayList<>();
            for (StringBuffer e : set)
                currentList.add(new StringBuffer(e));
            for (StringBuffer e : currentList) {
                e.append(s.charAt(i));
            }
            set.addAll(currentList);
        }
        TreeSet sortedSet = new TreeSet(new SbufferComparator());
        sortedSet.addAll(set);
        return sortedSet;
    }
}

       class SbufferComparator implements Comparator<StringBuffer> {

            @Override
            public int compare(StringBuffer s1, StringBuffer s2) {
                return s1.toString().compareTo(s2.toString());

            }

        }

