package minimumSpanningTree;

import utils.Graph;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Prim {
    public static void main(String[] args) {

    }

    void MSTPrim(Graph G, TreeMap<Graph.Edge, Integer> w, Graph.Vertex r) {
        for (Graph.Vertex u : G.V) {
            u.key = Integer.MAX_VALUE;
            u.pi = null;
        }
        r.key = 0;
        PriorityQueue<Graph.Vertex> vertices = new PriorityQueue<>();
    }
}
