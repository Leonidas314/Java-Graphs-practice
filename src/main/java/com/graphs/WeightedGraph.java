package com.graphs;
/**
* WeightedGraph represent a edge weighted int digraph, where vertices are labeled
* with integers and the edge's weight whit a float.
* Formally, a graph G=<V,E> consists of a set of vertices V,
* and a relation E in VxV that describes the edges of the graph.
*/
import java.util.List;
import com.graphs.EdgeWeighted;
public interface WeightedGraph<E extends EdgeWeighted> {
    /**
    * @post Returns the number of vertices in this graph. */
    public int V();
    /**
    * @post Returns the number of edges in this graph. */
    public int E();
    /**
    * @pre 0 <= v < V && 0 <= w < V
    * @post Adds the undirected edge v-w to this graph. */
    public void addEdge(int from, int to, double weight);
    /**
    * @pre 0 <= v < V
    * @post Returns the list of vertices adjacent to vertex v.*/
    public List<E> adj(int v);

    /**
     * @post Return a list with all the edges on the graphs
     */
    public List<E> edges();
}
