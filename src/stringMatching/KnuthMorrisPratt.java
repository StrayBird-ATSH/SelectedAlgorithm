package stringMatching;

import org.jetbrains.annotations.NotNull;

/**
 * These two procedures have much in common, because both match a string against the pattern P:
 * KMP-MATCHER matches the text T against P, and COMPUTE-PREFIX-FUNCTION matches P against itself.
 */
public class KnuthMorrisPratt {
    public static void main(String[] args) {
        KMPMatcher("bacbababaabcbab", "ababaca");
    }

    private static void KMPMatcher(@NotNull String T, @NotNull String P) {
        int n = T.length();
        int m = P.length();
        int[] pi = computePrefixFunction(P);
        int q = 0;                                                      //number of characters matched
        for (int i = 0; i < n; i++) {                                   //scan the text from left to right
            while (q > 0 && P.charAt(q) != T.charAt(i)) q = pi[q - 1];  //next character does not match
            if (P.charAt(q) == T.charAt(i)) q++;                        //next character matches
            if (q == m) {                                               //is all of P matched?
                System.out.println("Pattern occurs with shift " + (i - m));
                q = pi[q - 1];                                          //look for the next match
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