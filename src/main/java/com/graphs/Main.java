package com.graphs;

public class Main {
    public static void main(String[] args) {
        AdjacencyListGraph g = new AdjacencyListGraph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Mi grafo:");
        System.out.println(g);  // Llama a toString()
    }
}
