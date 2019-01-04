package minimumSpanningTree;

import utils.Graph;
import utils.VertexKeyComparator;

import java.util.PriorityQueue;

public class Prim {
    public static void main(String[] args) {

    }

    void MSTPrim(Graph G, int[][] w, Graph.Vertex r) {
        for (Graph.Vertex u : G.V) {
            u.key = Integer.MAX_VALUE;
            u.pi = null;
        }
        r.key = 0;
        PriorityQueue<Graph.Vertex> Q = new PriorityQueue<>(new VertexKeyComparator());
        Q.addAll(G.V);
        while (!Q.isEmpty()) {
            Graph.Vertex u = Q.poll();
            for (Graph.Vertex v : u.adj)
                if (Q.contains(v) && w[G.V.indexOf(u)][G.V.indexOf(v)] < v.key) {
                    v.pi = u;
                    v.key = w[G.V.indexOf(u)][G.V.indexOf(v)];
                }
        }
    }
}
