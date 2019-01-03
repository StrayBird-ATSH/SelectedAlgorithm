package StringMatching;

import org.jetbrains.annotations.NotNull;

public class RabinKarp {
    public static void main(String[] args) {
        RabinKarpMatcher("abcdejiklakdkdjfabcdef", "jiklakdkdj", Character.MAX_VALUE, 10000019);
    }

    private static void RabinKarpMatcher(@NotNull String T, @NotNull String P, int d, int q) {
        int n = T.length();
        int m = P.length();
        int h = (int) Math.pow(d, m - 1) % q;
        int p = 0;
        int[] t = new int[n];
        t[0] = 0;
        for (int i = 0; i < m; i++) {
            p = (d * p + P.charAt(i)) % q;
            t[0] = (d * t[0] + T.charAt(i)) % q;
        }
        for (int s = 0; s < n - m; s++) {
            if (p == t[s])
                if (P.substring(1, m).equals(T.substring(s + 1, s + m)))
                    System.out.println("Pattern occurs with shift " + s);
            if (s < n - m)
                t[s + 1] = (d * (t[s] - T.charAt(s + 1) * h) + T.charAt(s + m + 1)) % q;
        }
    }
}
