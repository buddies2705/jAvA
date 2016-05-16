package com.company;

import java.util.ArrayList;

/**
 * Created by root on 11/5/16.
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
            ArrayList<Interval> arrayList =new ArrayList<Interval>();
            arrayList.add(newInterval);
            return arrayList;
        }
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (int i = 0 ;  i < intervals.size() ; i++)
        {
            if(newInterval.start > newInterval.end)
            {
                int temp = newInterval.end;
                newInterval.end =newInterval.start;
                newInterval.start = temp;
            }
            if(newInterval.start < intervals.get(i).start &&
                    newInterval.end < intervals.get(i).end && newInterval.end > intervals.get(i).start)
            {
                result.add(new Interval(newInterval.start ,intervals.get(i).end));
            }
            else
            if(newInterval.start > intervals.get(i).start &&
                    newInterval.end < intervals.get(i).end )
            {
                result.add(new Interval(intervals.get(i).start ,intervals.get(i).end ));
            }
            else
            if(newInterval.start > intervals.get(i).start &&
                    newInterval.end > intervals.get(i).end && newInterval.start < intervals.get(i).end)
            {
                result.add(new Interval(intervals.get(i).start ,newInterval.end ));

            }
            else
            if(newInterval.start < intervals.get(i).start &&
                    newInterval.end > intervals.get(i).end)
            {
                result.add(newInterval);
            }
            else
            if(newInterval.end < intervals.get(i).start)
            {
                result.add(newInterval);
                if(i == intervals.size() -1 )
                    result.add(intervals.get(i));
            }
            else
            if(intervals.get(i).end < newInterval.start)
            {
                result.add(intervals.get(i));
                if(i == intervals.size()-1)
                    result.add(newInterval);
            }
        }
        return result;
    }
}

