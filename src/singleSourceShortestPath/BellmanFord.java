package singleSourceShortestPath;

import utils.Graph;

import static utils.Graph.initializeSingleSource;
import static utils.Graph.relax;

public class BellmanFord {
    public static void main(String[] args) {

    }

    private static boolean bellmanFord(Graph G, Graph.Vertex s) {
        initializeSingleSource(G, s);
        for (int i = 0; i < G.V.size() - 1; i++) {
            for (Graph.Edge edge : G.E)
                relax(edge);
            for (Graph.Edge edge : G.E)
                if (edge.v.d > edge.u.d + edge.weight)
                    return false;
        }
        return true;
    }
}
