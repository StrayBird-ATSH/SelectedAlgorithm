package MinimumSpanningTree;

import Utils.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import static DisjointSet.DisjointSetForest.*;

public class Kruskal {
    public static void main(String[] args) {
    }

    List MSTKruskal(Graph G, TreeMap<Graph.Edge, Integer> w) {
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

    public class EdgeWeightComparator implements Comparator<Graph.Edge> {
        TreeMap<Graph.Edge, Integer> w;

        EdgeWeightComparator(TreeMap<Graph.Edge, Integer> w) {
            this.w = w;
        }

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(Graph.Edge o1, Graph.Edge o2) {
            return w.get(o1) - w.get(o2);
        }
    }
}
