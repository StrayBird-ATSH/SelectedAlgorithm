package utils;

import java.util.Comparator;
import java.util.TreeMap;

public class EdgeWeightComparator implements Comparator<Graph.Edge> {
    TreeMap<Graph.Edge, Integer> w;

    public EdgeWeightComparator(TreeMap<Graph.Edge, Integer> w) {
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
