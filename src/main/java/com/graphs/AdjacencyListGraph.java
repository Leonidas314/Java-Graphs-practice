package com.graphs;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
public class AdjacencyListGraph{
    private int E;
    private int V;
    private List<Integer>[] adj;
    public AdjacencyListGraph(int V){
        this.V = V;
        this.adj = new LinkedList[V];   
        for (int i = 0; i < adj.length; i++) {
            adj[i]= new LinkedList<Integer>();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public String toString() {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < adj.length; i++) {
        res.append(i).append(" -> [ ");
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            Integer currentAdj = it.next();
            res.append(currentAdj);
            if (it.hasNext()) {
                res.append(", ");
            }
        }
        res.append(" ]\n");
    }
    return res.toString();
}

}