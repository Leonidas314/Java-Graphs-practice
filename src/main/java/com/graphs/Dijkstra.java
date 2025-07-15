package com.graphs;
import com.graphs.IndexMinPQ;
import com.graphs.WeightedGraph;

import java.security.spec.EdDSAParameterSpec;

import com.graphs.AdjacencyListWeightedGraph;
import com.graphs.EdgeWeighted;
public class Dijkstra<E extends EdgeWeighted> {
    private int[] distTo;
    private int[] edgeTo;
    private int s;
    private IndexMinPQ PQ;
    public Dijkstra(WeightedGraph<E> G, int s){
        distTo = new int[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] =Integer.MAX_VALUE; 
        }
        distTo[s]= 0;
        edgeTo = new int[G.V()];
        PQ = new IndexMinPQ(G.V());
        dijkstra(G,s);
    }
    private void dijkstra(WeightedGraph<E> G, int s){
        PQ.insert(s,0);
        while(!PQ.isEmpty()){
            int v = PQ.delMin();
            for (EdgeWeighted e : G.adj(v)) {
                relax(e);
            }
        }
    }
    private void relax(EdgeWeighted e){
        int from=e.from();
        int to = e.to();
        int w = e.weight();
        if(distTo[to]>distTo[from]+w){
            distTo[to] = distTo[from]+w;
            edgeTo[to] = from;
            if(!PQ.contains(to)){
                PQ.insert(to,distTo[from]+w);
            }else{
                PQ.change(to,distTo[from]+w);
            }
        }        
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < distTo.length; i++) {
            res.append(distTo[i] + "->" + edgeTo[i] +"\n");
        }
        return res.toString();
    }
}
