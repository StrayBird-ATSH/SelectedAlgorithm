package utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> V = new ArrayList<>();
    public ArrayList<Edge> E = new ArrayList<>();

    public static void initializeSingleSource(@NotNull Graph G, Vertex s) {
        for (Vertex v : G.V) {
            v.d = Integer.MAX_VALUE;
            v.pi = null;
        }
        s.d = 0;
    }

    public static void relax(@NotNull Edge edge) {
        Vertex v = edge.v;
        Vertex u = edge.u;
        if (v.d > u.d + edge.weight) {
            v.d = u.d + edge.weight;
            v.pi = u;
        }
    }

    public Edge getEdge(Vertex u, Vertex v) {
        for (Edge edge : E)
            if (edge.u == u && edge.v == v || edge.u == v && edge.v == u) return edge;
        return null;
    }


    public class Vertex {
        public Vertex p; /* This attribute is for disjoint set operations */
        public int rank; /* This attribute is for disjoint set operations */
        public int key;
        public Vertex pi;
        public ArrayList<Vertex> adj;
        public int d; /* This attribute is for shortest path */
    }

    public class Edge {
        public Vertex u;
        public Vertex v;
        public int weight;
    }
}
