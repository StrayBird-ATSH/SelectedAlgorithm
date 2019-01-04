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
        Graph G = new Graph(9);
        int[][] weight = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        G.constructGraph(weight);

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
