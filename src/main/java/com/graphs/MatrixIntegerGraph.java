package com.graphs;

import java.util.List;
import java.util.LinkedList;
public class MatrixIntegerGraph {
    private int V;
    private int E;
    private int[][] adj;
    public MatrixIntegerGraph(int V){
        this.V = V;
        adj = new int[V][V];
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w){
        adj[v][w]=1;
        adj[w][v]=1;
        E++;
    }
    public List adj(int v){
        List result = new LinkedList<Integer>();
        for (int j = 0; j < adj.length; j++) {
            if(adj[v][j]==1)
                result.add(j);
        }
        return result;
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < adj.length; i++) {
            res.append(i).append(" -> [ ");
            for (int j = 0; j < adj.length; j++) {
                if(adj[i][j]==1){
                    res.append(j+" ");
                }
            }
            res.append("]");
            res.append("\n");
        }
        return res.toString();
    }
}
