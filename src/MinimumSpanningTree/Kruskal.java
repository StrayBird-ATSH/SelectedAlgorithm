package MinimumSpanningTree;

import Utils.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static DisjointSet.DisjointSetForest.makeSet;

public class Kruskal {
    public static void main(String[] args) {

    }

    List MSTKruskal(Graph G, TreeMap<Graph.Edge, Integer> w) {
        ArrayList<Graph.Edge> A = new ArrayList<>();
        for (Graph.Vertex v : G.V)
            makeSet(v);
        G.E.sort(null);
        return null;
    }
}
