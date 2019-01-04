package singleSourceShortestPath;

import utils.Graph;
import utils.VertexDComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static utils.Graph.initializeSingleSource;
import static utils.Graph.relax;

public class Dijkstra {
    public static void main(String[] args) {

    }

    private static void dijkstra(Graph graph, Graph.Vertex s) {
        initializeSingleSource(graph, s);
        PriorityQueue<Graph.Vertex> Q = new PriorityQueue<>(new VertexDComparator());
        Q.addAll(graph.V);
        while (!Q.isEmpty()) {
            Graph.Vertex u = Q.poll();
            for (Graph.Vertex v : u.adj)
                relax(graph.getEdge(u, v));
            Q = new PriorityQueue<>(new ArrayList<>(Q));
        }
    }
}