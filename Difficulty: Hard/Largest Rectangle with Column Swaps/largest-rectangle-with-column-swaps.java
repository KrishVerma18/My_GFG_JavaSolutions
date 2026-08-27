class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] hist = new int[n][m];

        for (int j = 0; j < m; j++) {
            hist[0][j] = mat[0][j];
            for (int i = 1; i < n; i++) {
                hist[i][j] = (mat[i][j] == 0) ? 0 : hist[i - 1][j] + 1;
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int[] count = new int[n + 1];
            for (int j = 0; j < m; j++) {
                count[hist[i][j]]++;
            }

            int colCount = 0;
            for (int h = n; h >= 0; h--) {
                colCount += count[h];
                maxArea = Math.max(maxArea, colCount * h);
            }
        }

        return maxArea;
    }
}