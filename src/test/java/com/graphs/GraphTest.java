package com.graphs;

import com.graphs.AdjacencyListGraph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void AdjacencyListGraphConstructorTest(){
        AdjacencyListGraph G = new AdjacencyListGraph(4);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(0, 3);
        G.addEdge(1, 3);
        assertEquals(4,G.E());
        assertEquals(4,G.V());
    }
}
