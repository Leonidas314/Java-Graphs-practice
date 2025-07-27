import com.graphs.EdgeWeighted;
import com.graphs.WeightedGraph;
import com.graphs.IndexMinPQ;
public class PRIMMST<E extends EdgeWeighted>{
    private double[] distTo;
    private EdgeWeighted[] edgeTo;
    private IndexMinPQ<Double> pq;
    private boolean[] marked;
    private int s;
    public PRIMMST(WeightedGraph<E> G, int s){
        this.s=s;
        this.marked = new boolean[G.V()];
        this.distTo = new double[G.V()];
        this.edgeTo = new EdgeWeighted[G.V()];
        this.pq = new IndexMinPQ(G.V());
        for (int i = 0; i < G.V(); i++) {
            if(i != s){
                distTo[i]= Double.MAX_VALUE;
                pq.insert(i,distTo[i]);
            }
        }
        distTo[s]= 0.0;
        pq.insert(s,0.0);
        while(!pq.isEmpty()){
            int v = pq.delMin();
            marked[v] = true;
            for(EdgeWeighted e : G.adj(v)){
                int w = e.other(v);
                if(marked[w]) continue;
                if(e.weight()<distTo[w]){
                    distTo[w]=e.weight();
                    edgeTo[w]=e;
                    pq.decreaseKey(w,e.weight());
                }
            }
        }
    }
    
    
    /**
     * @post Return the total minimun weight of the spanning tree
     */
    public double treeWeight(){
        double res = 0;
        for(int i = 0; i < edgeTo.length; i++){
            res+=edgeTo[i].weight();
        }
        return res;
    }
}