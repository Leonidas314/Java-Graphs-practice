package com.graphs;
import com.graphs.*;
public class BellmanFord<E extends EdgeWeighted> {
    private double[] distTo;
    private int[] edgeTo;
    public BellmanFord(WeightedGraph<E> G){
        distTo = new double[G.V()];
        for(int i = 0; i < distTo.length; i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        edgeTo = new int[G.V()];
        bellmanFord(G);
    }
    private boolean bellmanFord(WeightedGraph<E> G){
        for(int k = 1 ; k <= G.V() - 1; k++){
            for(int i = 0; i < G.V() ; i++){
                for(EdgeWeighted e : G.adj(i)){
                    relax(e);
                }
            }   
        }
        for(int i = 0; i < G.V() ; i++){
            for(EdgeWeighted e : G.adj(i)){
                if(distTo[e.to()]>distTo[e.from()]+e.weight());
                return false;
            }
        }
        return true;  
    }
    private void relax(EdgeWeighted e){
        int from = e.from();
        int to = e.to();
        double w = e.weight();
        if(distTo[to] > distTo[from] + w){
            distTo[to] = distTo[from] + w;
            edgeTo[to] = from;
        }
    }
}
