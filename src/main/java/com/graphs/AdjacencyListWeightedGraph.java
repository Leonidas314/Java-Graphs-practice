package com.graphs;
import com.graphs.WeightedGraph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.graphs.EdgeWeighted;
public class AdjacencyListWeightedGraph implements WeightedGraph {
    private List<EdgeWeighted>[] adj;
    private int V;
    private int E;
    public AdjacencyListWeightedGraph(int V){
        this.V = V;
        this.adj = new LinkedList[V];
        for(int i = 0 ; i < adj.length; i++){
            adj[i] = new LinkedList<EdgeWeighted>();
        }
    }
    public int E(){
        return this.E;
    }
    public int V(){
        return this.V;
    }
    public void addEdge(int from, int to, double weight){
        if(from > this.V || to > this.V) throw new IllegalArgumentException();
        EdgeWeighted e = new EdgeWeighted(from, to, weight);
        adj[from].add(e);
        E++;
    }
    public List<EdgeWeighted> edges(){
        List<EdgeWeighted> edges = new LinkedList<EdgeWeighted>();
        for(int i = 0 ; i < this.V; i++){
            for(EdgeWeighted e : adj[i]){
                edges.add(e);
            }
        }
        return edges;
    }
    public List<EdgeWeighted> adj(int v){
        List<EdgeWeighted> adj = new LinkedList<>();
        for (EdgeWeighted e : this.adj[v]) {
            adj.add(e);            
        }
        return adj;
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < adj.length; i++) {
            res.append(i+"-> [");
            Iterator<EdgeWeighted> it =  adj[i].iterator(); 
            while (it.hasNext()) {
                EdgeWeighted next = it.next();
                res.append(next.toString());
                if(it.hasNext()){
                    res.append(", ");
                }
            }
        res.append("]\n");

        }
        return res.toString();
    }

}
