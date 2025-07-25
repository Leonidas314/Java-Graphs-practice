package com.graphs;

import java.util.LinkedList;
import java.util.List;

import com.graphs.IntGraph;

public class DeepFirstSearch<G extends IntGraph>{
    private boolean[] marked;
    private int[] edgeTo;
    private int source;
    public DeepFirstSearch(IntGraph G, int s){
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.source = s;
        dfs(G,s);
    }
    private void dfs(IntGraph G,int source){
        marked[source]=true;
        for (Integer currAdj : G.adj(source) ) {
            if(!marked[currAdj]){
                edgeTo[currAdj]=source;
                dfs(G, currAdj);
            }
        }
    }
     public List pathTo(int d){
        List path = new LinkedList<Integer>();
        for(int x=d; x!= this.source; x=edgeTo[x]){
            path.addFirst(x);
        }
        path.addFirst(this.source);
        return path;
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for(int i = 0; i<edgeTo.length;i++){
            if(i<edgeTo.length-1){
                res.append(edgeTo[i]+", ");
            }else{
                res.append(edgeTo[i]);
            }
        }
        res.append("]");
        return res.toString();
    }

}
