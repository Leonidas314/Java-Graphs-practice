import com.graphs.EdgeWeighted;
import com.graphs.WeightedGraph;
import java.util.List;
import java.util.LinkedList;
public class MatrixIntWeightedGraph<E extends EdgeWeighted> implements WeightedGraph {
    private int E;
    private int V;
    private double[][] adj;
    public MatrixIntWeightedGraph(int V){
        this. V = V;
        this.E = 0;
        this. adj = new double[V][V];
        for(int i = 0 ; i < V; i++){
            for(int j = 0; j< V; j++){
                if(i == j)
                    adj[i][j]=0;
                else
                    adj[i][j] = Double.MAX_VALUE;
            }
        }
    }
    public int V(){
        return this.V;
    }
    public int E(){
        return this.E;
    }
    public void addEdge(int from , int to, double weight){
        adj[from][to]= weight;
        this.E++;
    }
    public void addEdge(EdgeWeighted e){
        int from = e. from();
        int to = e. to();
        adj[from][to]= e.weight();
        this.E++;
    }
    public List<EdgeWeighted> adj(int v){
        List<EdgeWeighted> list = new LinkedList<>();
        for(int j = 0 ; j<V(); j ++){
            if(adj[v][j]!= Double.MAX_VALUE){
                EdgeWeighted e = new EdgeWeighted(v, j, adj[v][j]);
            list.add(e);
            }
        }
        return list;
    }
    public List<EdgeWeighted> edges(){
        List<EdgeWeighted> list = new LinkedList<>();
        for(int i = 0 ; i < this.V; i ++){
            for(int j = 0 ; j < this.V; j++){
                if(adj[i][j] != Double.MAX_VALUE){
                    EdgeWeighted e = new EdgeWeighted(i, j, adj[i][j]);
                    list.add(e);
                }
            }
        }
        return list;
    }
}
