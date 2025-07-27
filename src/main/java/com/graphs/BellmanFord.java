package com.graphs;
import com.graphs.*;
import java.util.List;
import java.util.LinkedList;
public class BellmanFord<E extends EdgeWeighted> {
    private double[] distTo;
    private int[] edgeTo;
    private int s;
    private boolean hasNegativeCicles;
    public BellmanFord(WeightedGraph<E> G, int s){
        this.s = s;
        this.hasNegativeCicles=false;
        this.edgeTo = new int[G.V()];
        this.distTo = new double[G.V()];
        for(int i = 0 ; i < G.V(); i ++){
            if(i != s){
                distTo[i]= Double.MAX_VALUE;
            }
        }
        distTo[s] = 0;
        bellmanford(G,s);
        this.hasNegativeCicles=hasNegativeCicles(G);
    }
    private void bellmanford(WeightedGraph<E> G, int s){
        List<E> edges = G.edges();
        for(int i = 0 ; i < G.V() - 1 ; i++){
            for(EdgeWeighted e : edges){
                relax(e);
            }
        }
    }
    private boolean hasNegativeCicles(WeightedGraph<E> G){
        
        for(EdgeWeighted e : G.edges()){
            int to = e.to();
            int from = e.from();
            double w = e.weight();
            if(distTo[from]!=Double.MAX_VALUE && distTo[to]>distTo[from]+ w){
                return true;
            }
        }
        return false;
    }
    private void relax(EdgeWeighted e){
        int from = e.from();
        int to = e.to();
        double w  = e.weight();
        if(distTo[to]>distTo[from]+w){
            distTo[to]=distTo[from] + w;
            edgeTo[to]= from;
        }
    }
    public boolean hasNegCicl(){
        return this.hasNegativeCicles;
    }
}
