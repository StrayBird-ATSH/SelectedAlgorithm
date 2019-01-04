package Utils;

import java.util.ArrayList;
import java.util.Comparator;

public class Graph {
    public ArrayList<Vertex> V = new ArrayList<>();
    public ArrayList<Edge> E = new ArrayList<>();

    public class Vertex {
        public Vertex p; /* This attribute is for disjoint set operations */
        public int rank; /* This attribute is for disjoint set operations */
    }

    public class Edge {
        Vertex u;
        Vertex v;
    }

    class EdgeWeightComparator implements Comparator<Edge> {
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
        public int compare(Edge o1, Edge o2) {
            return 0;
        }
    }
}
