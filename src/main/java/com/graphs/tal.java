import com.graphs.EdgeWeighted;
import com.graphs.WeightedGraph;

public class tal {
    private boolean[] marked;
    private IndexMInPQ pq;
    private double[] distTo;
    private EdgeWeighted[] edgeTo;

    public tal(WeightedGraph G, int s){
        distTo = new double[G.V()];
        for ( i = 0; i < G.V(); i++) {
            distTo[i]= Double.MAX_VALUE;
        }
        distTo[s] = 0;
        marked = new boolean[G.V()];
        pq = new IndeMinPQ(G.V());
        edgeTo = new int[G.V()];

        pq.insert(s,distTo[s]);
        while(!pq.isEmpty()){
            int w = pq.delMin();
            marked[w]=true;
            for(EdgeWeighted e : G.adj(w)){
                if(marked[to]) continue;
                int from = e.from();
                int to = e.to();
                double weight = e.weight();
                if(distTo[to]>weight){
                    distTo[to]=weight;
                    edgeTo[w]=e;
                    pq.decreaseKey(w,distTo[w]);
                }
            }
        }
    }
}
