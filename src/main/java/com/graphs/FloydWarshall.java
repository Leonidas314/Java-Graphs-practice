package com.graphs;
import java.util.List;

import com.graphs.EdgeWeighted;
import com.graphs.WeightedGraph;

public class FloydWarshall<E extends EdgeWeighted> {
    private double[][] distTo;
    private Integer[][] edgeTo;

    public FloydWarshall(WeightedGraph<E> G){
        this.distTo = new double[G.V()][G.V()];
        this.edgeTo = new Integer[G.V()][G.V()];
        for (int i = 0; i < G.V(); i++) {       
            for(int j = 0; j < G.V(); j++){
                edgeTo[i][j] = null;
                if(i==j){
                    distTo[i][j] = 0;
                }else{
                    distTo [i][j] = Double.MAX_VALUE;
                }
            }
        }
        for(int v = 0; v < G.V(); v ++){
            for(EdgeWeighted e : G.adj(v)){
                int to = e.to();
                double w = e.weight();
                edgeTo[v][to] = v; //Caminos
                distTo[v][to] = w;  //Distancias
            } 
        }
        
        for (int k = 0; k < G.V(); k++) {
            for (int i = 0; i < G.V(); i++) {
                for (int j = 0; j < distTo.length; j++) {
                    if(distTo[i][j]>distTo[i][k]+distTo[k][j])
                        edgeTo[i][j] = k;
                        distTo[i][j]= Math.min(distTo[i][j],distTo[i][k]+distTo[k][j]);
                }
            }
        }

    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Distancias (distTo):\n");
        for (int i = 0; i < distTo.length; i++) {
            for (int j = 0; j < distTo[i].length; j++) {
                if (distTo[i][j] == Double.MAX_VALUE) {
                    res.append("INF\t");
                } else {
                    res.append(String.format("%.1f\t", distTo[i][j]));
                }
            }
            res.append("\n");
        }
        res.append("\nCaminos (edgeTo):\n");
        for (int i = 0; i < edgeTo.length; i++) {
            for (int j = 0; j < edgeTo[i].length; j++) {
                res.append(edgeTo[i][j] + "\t");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
