class Solution {
    public int largestSubsquare(char[][] mat) {
        int n = mat.length;
        int[][] row = new int[n][n];
        int[][] col = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    row[i][j] = (j == 0) ? 1 : row[i][j - 1] + 1;
                    col[i][j] = (i == 0) ? 1 : col[i - 1][j] + 1;
                }
            }
        }

        int maxSide = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int small = Math.min(row[i][j], col[i][j]);

                while (small > maxSide) {
                    if (row[i - small + 1][j] >= small && col[i][j - small + 1] >= small) {
                        maxSide = small;
                        break;
                    }
                    small--;
                }
            }
        }

        return maxSide;
    }
}