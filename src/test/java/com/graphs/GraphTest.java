package com.graphs;

import com.graphs.AdjacencyListGraph;
import com.graphs.BellmanFord;
import com.graphs.DeepFirstSearch;
import com.graphs.Dijkstra;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphTest {
    @Test
    public void AdjacencyListGraphTest(){
        AdjacencyListGraph G1 = new AdjacencyListGraph(10);
        G1.addEdge(0, 1);
        G1.addEdge(0, 2);
        G1.addEdge(0, 3);
        G1.addEdge(1, 4);
        G1.addEdge(1, 5);
        G1.addEdge(2, 6);
        G1.addEdge(2, 7);
        G1.addEdge(2, 8);
        G1.addEdge(2, 3);
        G1.addEdge(3, 9);
        List<Integer> pathEsperado1= Arrays.asList(0,2,8);
        DeepFirstSearch dfs1 = new DeepFirstSearch(G1,0);
        assertEquals(pathEsperado1,dfs1.pathTo(8));
    }
    @Test
    public void MatrixIntGraphTest(){
        AdjacencyListGraph G1 = new AdjacencyListGraph(10);
        G1.addEdge(0, 1);
        G1.addEdge(0, 2);
        G1.addEdge(0, 3);
        G1.addEdge(1, 4);
        G1.addEdge(1, 5);
        G1.addEdge(2, 6);
        G1.addEdge(2, 7);
        G1.addEdge(2, 8);
        G1.addEdge(2, 3);
        G1.addEdge(3, 9);

        List<Integer> pathEsperado1= Arrays.asList(0,2,8);
        DeepFirstSearch dfs1 = new DeepFirstSearch(G1,0);
        assertEquals(pathEsperado1,dfs1.pathTo(8));
    }

    @Test
    public void hasNegativeCiclesTest(){
        //Grafo sin ciclos negativos
        AdjacencyListWeightedGraph g1 = new AdjacencyListWeightedGraph(9);

        g1.addEdge(0, 1, 4);
        g1.addEdge(0, 2, 8);
        g1.addEdge(1, 3, 5);
        g1.addEdge(2, 3, 2);
        g1.addEdge(2, 5, 5);
        g1.addEdge(3, 4, 3);
        g1.addEdge(4, 6, 4);
        g1.addEdge(5, 4, 1);
        g1.addEdge(5, 6, 6);
        g1.addEdge(6, 7, 2);
        g1.addEdge(7, 5, 1);
        g1.addEdge(7, 8, 3);
        g1.addEdge(8, 5, 2);
        g1.addEdge(1, 2, 1); 

        BellmanFord BF1 = new BellmanFord<>(g1, 0);
        assertFalse(BF1.hasNegCicl());

        //Grafo con 1 ciclo negativo
        AdjacencyListWeightedGraph g2 = new AdjacencyListWeightedGraph(9);

        g2.addEdge(0, 1, 4);
        g2.addEdge(0, 2, 8);
        g2.addEdge(1, 3, 5);
        g2.addEdge(2, 3, 2);
        g2.addEdge(2, 5, 5);
        g2.addEdge(3, 4, 3);
        g2.addEdge(4, 6, 4);
        g2.addEdge(5, 4, 1);
        g2.addEdge(5, 6, 6);
        g2.addEdge(6, 7, 2);
        g2.addEdge(7, 5, -9);  // <-- cambia este peso a negativo
        g2.addEdge(7, 8, 3);
        g2.addEdge(8, 5, 2);
        g2.addEdge(1, 2, 1);  // para completar 14 aristas

        BellmanFord BF2 = new BellmanFord<>(g2,0);
        assertTrue(BF2.hasNegCicl());
    }

    @Test 
    public void DijkstraTest(){
        AdjacencyListWeightedGraph g1 = new AdjacencyListWeightedGraph(9);

        // Aristas con pesos
        g1.addEdge(0, 1, 4);
        g1.addEdge(0, 7, 8);
        g1.addEdge(1, 2, 8);
        g1.addEdge(1, 7, 11);
        g1.addEdge(2, 3, 7);
        g1.addEdge(2, 8, 2);
        g1.addEdge(2, 5, 4);
        g1.addEdge(3, 4, 9);
        g1.addEdge(3, 5, 14);
        g1.addEdge(4, 5, 10);
        g1.addEdge(5, 6, 2);
        g1.addEdge(6, 7, 1);
        g1.addEdge(6, 8, 6);
        g1.addEdge(7, 8, 7);

         Dijkstra<EdgeWeighted> djkst1 = new Dijkstra<>(g1, 0);
        List<Integer> esperado = Arrays.asList(0,1,2,8);
        List<Integer> pathTo8 = djkst1.pathTo(8);
        assertEquals(esperado, pathTo8);

    }
}
