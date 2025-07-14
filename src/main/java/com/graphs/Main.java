package com.graphs;

import com.graphs.DeepFirstSearch;
import com.graphs.MatrixIntegerGraph;

public class Main {
    public static void main(String[] args) {
        AdjacencyListGraph listG = new AdjacencyListGraph(5);
        
        listG.addEdge(0, 1);
        listG.addEdge(1, 2);
        listG.addEdge(2, 3);
        listG.addEdge(3, 4);

        System.out.println("Mi grafo:");
        System.out.println(listG);  // Llama a toString()
        
        MatrixIntegerGraph matrixG = new MatrixIntegerGraph(5);

        matrixG.addEdge(0, 1);
        matrixG.addEdge(1, 2);
        matrixG.addEdge(2, 3);
        matrixG.addEdge(3, 4);

        System.out.println("Mi grafo:");
        System.out.println(matrixG);  // Llama a toString()

        DeepFirstSearch dfs1 = new DeepFirstSearch(listG, 0);
        System.out.println("DFS:");
        System.out.println(dfs1);
    }
}
