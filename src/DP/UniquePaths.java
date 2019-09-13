package DP;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] b = new int[m][n];
        b[0][0] = 1;
        for(int i = 1; i < m; ++i) {
            b[i][0] = 1;
        }

        for(int i = 1; i < n;  ++i) {
            b[0][i] = 1;
        }

        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                b[i][j] = b[i][j-1] +  b[i-1][j];
            }
        }

        return b[m-1][n-1];
    }
}
