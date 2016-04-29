package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by root on 27/4/16.
 */
public class Graph {

    private int v;
    LinkedList<Integer> adj[];

    Graph(int v){
        adj = new LinkedList[v];
        for (int i =0 ; i < v ;i++)
        {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v , int w )
    {
        adj[v].add(w);
    }

    public void BFS(int startPoint)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        int [] visited = new int[v];
        int count = 0;
        while (queue.isEmpty())
        {
            int current = queue.poll();
            visited[current] = 1;
            System.out.println( " -- " + current +" --");
            for (int i = 0 ; i < adj[current].size() ; i++)
            {
                queue.add(adj[current].get(i));
            }
        }
    }


    public void DFS(int startingPoint)
    {

    }
}
