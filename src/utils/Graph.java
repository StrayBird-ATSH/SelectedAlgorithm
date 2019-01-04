package utils;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> V = new ArrayList<>();
    public ArrayList<Edge> E = new ArrayList<>();

    public class Vertex {
        public Vertex p; /* This attribute is for disjoint set operations */
        public int rank; /* This attribute is for disjoint set operations */
        public int key;
        public Vertex pi;
        public ArrayList<Vertex> adj;
    }

    public class Edge {
        public Vertex u;
        public Vertex v;
    }
}
