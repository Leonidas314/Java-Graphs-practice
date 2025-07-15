package com.graphs;
import java.util.ArrayDeque;
public class BreadthFirstSearch{
    private boolean[] marked;
    private int[] edgeTo;
    private ArrayDeque<Integer> queue;
    private int s;
    public BreadthFirstSearch(IntGraph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g,s);
    }
    private void bfs(IntGraph g, int s){
        marked[s] = true;
        ArrayDeque queue = new ArrayDeque<>();
        queue.offer(s);
        while(!queue.isEmpty()){
            int q = (int) queue.pollLast();
            for (int currAdj : g.adj(q)){
                if(!marked[currAdj]){
                    marked[currAdj] = true;
                    edgeTo[currAdj] = q;
                    queue.addFirst(currAdj); 
                }
            }
        }
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for(int i = 0; i<edgeTo.length;i++){
            if(i<edgeTo.length-1){
                res.append(edgeTo[i]+", ");
            }else{
                res.append(edgeTo[i]);
            }
        }
        res.append("]");
        return res.toString();
    }

}