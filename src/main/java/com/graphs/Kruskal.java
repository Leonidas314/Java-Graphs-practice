import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import com.graphs.EdgeWeighted;
import com.graphs.WeightedGraph;
import com.graphs.UF;
public class Kruskal {
    /*Algoritmo de Kruskal para arboles abarcadores minimales
     * Inicializar un arreglo de Edges
     * Ordenarlo de forma no decresciente
     * Inicializar instancia de Union-Find
     * para cada Edge en el arreglo chequear si from - other estan conectados
     * Si no lo estan, "conectarlos", agragar el edge al mst , sumar el peso de la arista
     */
    private double weight;
    private List<EdgeWeighted> mst;

    public Kruskal(WeightedGraph G){
        EdgeWeighted[] edgesArray = new EdgeWeighted[G.E()];
        List<EdgeWeighted> listEdges = G.edges();
        int i = 0;
        for(EdgeWeighted e : listEdges){
            edgesArray[i++] = e; 
        }
        Arrays.sort(edgesArray);
        mst = new LinkedList<>();
        UF uf = new UF(G.E());
        for(int j = 0; j< G.E() && mst.size() < G.V()-1 ; j++){
            EdgeWeighted e = edgesArray[j];
            int u = e.from();
            int v = e.other(u);
            double w = e.weight();
            if(uf.find(v)!=uf.find(u)){
                uf.union(u, v);
                mst.add(e);
                weight += e.weight();
            }
        }
    }
}
