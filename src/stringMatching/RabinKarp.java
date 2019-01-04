package stringMatching;

import org.jetbrains.annotations.NotNull;

public class RabinKarp {
    public static void main(String[] args) {
        RabinKarpMatcher("abcdejiklakdkdjfabcdef", "jiklakdkdj", Character.MAX_VALUE, 10000019);
    }

    private static void RabinKarpMatcher(@NotNull String T, @NotNull String P, int d, int q) {
        int n = T.length();
        int m = P.length();
        long h = (long) Math.pow(d, m - 1) % q;
        int p = 0;
        long[] t = new long[n];
        t[0] = 0;
        for (int i = 0; i < m; i++) {
            p = (d * p + P.charAt(i)) % q;
            t[0] = (d * t[0] + T.charAt(i)) % q;
        }
        for (int s = 0; s < n - m + 1; s++) {
            if (p == t[s]) if (P.equals(T.substring(s, s + m))) System.out.println("Pattern occurs with shift " + s);
            if (s < n - m) t[s + 1] = (d * (t[s] - T.charAt(s) * h) + T.charAt(s + m)) % q;
        }
    }
}
