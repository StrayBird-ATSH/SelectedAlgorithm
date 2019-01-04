package utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> V;
    public ArrayList<Edge> E = new ArrayList<>();

    public Graph(int vertexNumber) {
        V = new ArrayList<>(vertexNumber);
        for (int i = 0; i < vertexNumber; i++)
            V.add(new Vertex());
    }

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

    public void constructGraph(int[][] edgeWeight) {
        for (int i = 0; i < edgeWeight.length; i++)
            for (int j = 0; j < edgeWeight[0].length; j++)
                if (edgeWeight[i][j] != 0)
                    E.add(new Edge(V.get(i), V.get(j), edgeWeight[i][j]));
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

        Edge(Vertex u, Vertex v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}
