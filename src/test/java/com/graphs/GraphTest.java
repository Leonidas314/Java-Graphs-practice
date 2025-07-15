package com.graphs;

import com.graphs.AdjacencyListGraph;
import com.graphs.DeepFirstSearch;

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
}
