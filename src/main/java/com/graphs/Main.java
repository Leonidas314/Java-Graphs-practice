package com.graphs;

import com.graphs.BreadthFirstSearch;
import com.graphs.DeepFirstSearch;
import com.graphs.Dijkstra;
import com.graphs.MatrixIntegerGraph;
import com.graphs.AdjacencyListWeightedGraph;
public class Main {
    public static void main(String[] args) {
        AdjacencyListGraph listG1 = new AdjacencyListGraph(10);
        
        listG1.addEdge(0, 1);
        listG1.addEdge(0, 2);
        listG1.addEdge(0, 3);
        listG1.addEdge(1, 4);
        listG1.addEdge(1, 5);
        listG1.addEdge(2, 6);
        listG1.addEdge(2, 7);
        listG1.addEdge(2, 8);
        listG1.addEdge(2, 3);
        listG1.addEdge(3, 9);
        
        //System.out.println("Mi grafo:");
        //System.out.println(listG1);  // Llama a toString()
        
        /*MatrixIntegerGraph matrixG = new MatrixIntegerGraph(5);

        matrixG.addEdge(0, 1);
        matrixG.addEdge(1, 2);
        matrixG.addEdge(2, 3);
        matrixG.addEdge(3, 4);

        System.out.println("Mi grafo:");
        System.out.println(matrixG);  // Llama a toString()
        
        DeepFirstSearch dfs1 = new DeepFirstSearch(listG1, 0);
        System.out.println("DFS:");
        System.out.println(dfs1);
        BreadthFirstSearch bfs1 = new BreadthFirstSearch(listG1, 0);
        System.out.println("BFS:");
        System.out.println(bfs1);*/

        AdjacencyListWeightedGraph GW1 = new AdjacencyListWeightedGraph(9);
        GW1.addEdge(0, 1, 2.0);
        GW1.addEdge(0, 4, 3.0);
        GW1.addEdge(1, 2, 2.0);
        GW1.addEdge(1, 4, 5.0);
        GW1.addEdge(1, 5, 1.0);
        GW1.addEdge(2, 5, 1.0);
        GW1.addEdge(3, 6, 10.0);
        GW1.addEdge(3, 7, 2.0);
        GW1.addEdge(4, 3, 1.0);
        GW1.addEdge(4, 8, 7.0);
        GW1.addEdge(5, 4, 1.0);
        GW1.addEdge(5, 8, 10.0);
        GW1.addEdge(7, 8, 1.0);

        System.out.println("Mi grafo con pesos:");
        System.out.println(GW1);
        Dijkstra djk = new Dijkstra<>(GW1, 0);
        System.out.println(djk);
        System.out.println(djk.pathTo(8));
    }
}
