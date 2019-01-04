package minimumSpanningTree;

import org.jetbrains.annotations.NotNull;
import utils.EdgeWeightComparator;
import utils.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static disjointSet.DisjointSetForest.*;

public class Kruskal {
    public static void main(String[] args) {
    }

    static List MSTKruskal(@NotNull Graph G, TreeMap<Graph.Edge, Integer> w) {
        ArrayList<Graph.Edge> A = new ArrayList<>();
        for (Graph.Vertex v : G.V)
            makeSet(v);
        G.E.sort(new EdgeWeightComparator(w));
        for (Graph.Edge edge : G.E)
            if (findSet(edge.u) != findSet(edge.v)) {
                A.add(edge);
                union(edge.u, edge.v);
            }
        return A;
    }
}
