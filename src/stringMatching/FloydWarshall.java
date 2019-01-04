package stringMatching;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class FloydWarshall {

    public static void main(String[] args) {
        int[][] W = {
                {0, 3, 7, 10, 10},
                {10, 0, 10, -1, 6},
                {10, 8, 0, -4, 10},
                {10, 10, 11, 0, 9},
                {-5, 10, 2, 10, 0}
        };
        W = floyd_warshall(W);
        for (int[] row : W)
            System.out.println(Arrays.toString(row));
    }

    private static int[][] floyd_warshall(@NotNull int[][] W) {
        int n = W.length;
        int[][][] D = new int[n + 1][n][n];
        D[0] = W;
        for (int k = 1; k <= n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    D[k][i][j] = Math.min(D[k - 1][i][j], D[k - 1][i][k - 1] + D[k - 1][k - 1][j]);
        return D[n];
    }
}
