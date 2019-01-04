package stringMatching;

import org.jetbrains.annotations.NotNull;

public class KnuthMorrisPratt {
    public static void main(String[] args) {
        KMPMatcher("bacbababaabcbab", "ababaca");
    }

    private static void KMPMatcher(@NotNull String T, @NotNull String P) {
        int n = T.length();
        int m = P.length();
        int[] pi = computePrefixFunction(P);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && P.charAt(q) != T.charAt(i)) q = pi[q - 1];
            if (P.charAt(q) == T.charAt(i)) q++;
            if (q == m) {
                System.out.println("Pattern occurs with shift " + (i - m));
                q = pi[q - 1];
            }
        }
    }

    static private int[] computePrefixFunction(@NotNull String P) {
        int m = P.length();
        int[] pi = new int[m];
        int k = 0;
        pi[0] = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && P.charAt(k) != P.charAt(q)) k = pi[k];
            if (P.charAt(k) == P.charAt(q)) k++;
            pi[q] = k;
        }
        return pi;
    }
}