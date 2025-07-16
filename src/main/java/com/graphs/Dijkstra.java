package com.graphs;
import com.graphs.IndexMinPQ;
import com.graphs.WeightedGraph;

import java.security.spec.EdDSAParameterSpec;
import java.util.LinkedList;
import java.util.List;

import com.graphs.AdjacencyListWeightedGraph;
import com.graphs.EdgeWeighted;
public class Dijkstra<E extends EdgeWeighted> {
    private double[] distTo;
    private int[] edgeTo;
    private int s;
    private IndexMinPQ PQ;
    public Dijkstra(WeightedGraph<E> G, int s){
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY; 
        }
        distTo[s]= 0.0;
        edgeTo = new int[G.V()];
        PQ = new IndexMinPQ(G.V());
        dijkstra(G,s);
    }
    private void dijkstra(WeightedGraph<E> G,int s){
        PQ.insert(s,0.0);
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
        double w = e.weight();
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
    public List<Integer> pathTo(int w){
        List<Integer> path = new LinkedList<>();
        for(int x = w; x != s ;x=edgeTo[x]){
            path.add(x);
        }
        path.addLast(s);
        return path;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("distTo -> edgeTo\n");
        for (int i = 0; i < distTo.length; i++) {
            res.append(distTo[i] + "->" + edgeTo[i] +"\n");
        }
        return res.toString();
    }
}
