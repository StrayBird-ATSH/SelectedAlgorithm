package GreedyAlgorithms;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        Node[] characters = new Node[6];
        characters[0] = new Node('a', 45);
        characters[1] = new Node('b', 13);
        characters[2] = new Node('c', 12);
        characters[3] = new Node('d', 16);
        characters[4] = new Node('e', 9);
        characters[5] = new Node('f', 5);
        Node root = huffman(Arrays.asList(characters));
        System.out.println(root.left.character);
    }

    static private Node huffman(@NotNull List<Node> C) {
        int n = C.size();
        PriorityQueue<Node> Q = new PriorityQueue<>(C);
        for (int i = 0; i < n - 1; i++) {
            Node z = new Node();
            Node x = Q.poll();
            Node y = Q.poll();
            assert x != null;
            assert y != null;
            z.left = x;
            z.right = y;
            z.freq = x.freq + y.freq;
            Q.add(z);
        }
        return Q.element();
    }
}

class Node implements Comparable<Node> {
    char character;
    Node left;
    Node right;
    int freq;

    Node() {
    }

    Node(char character, int freq) {
        this.character = character;
        this.freq = freq;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull Node o) {
        return this.freq - o.freq;
    }
}