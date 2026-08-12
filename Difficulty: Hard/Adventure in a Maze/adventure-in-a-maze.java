class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        int MOD = 1000000007;

        long[][] paths = new long[n][n];
        int[][] maxVal = new int[n][n];

        paths[0][0] = 1;
        maxVal[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (paths[i][j] == 0) continue;

                int val = grid[i][j];

                if ((val == 1 || val == 3) && j + 1 < n) {
                    paths[i][j + 1] = (paths[i][j + 1] + paths[i][j]) % MOD;
                    maxVal[i][j + 1] = Math.max(maxVal[i][j + 1], maxVal[i][j] + grid[i][j + 1]);
                }

                if ((val == 2 || val == 3) && i + 1 < n) {
                    paths[i + 1][j] = (paths[i + 1][j] + paths[i][j]) % MOD;
                    maxVal[i + 1][j] = Math.max(maxVal[i + 1][j], maxVal[i][j] + grid[i + 1][j]);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if (paths[n - 1][n - 1] == 0) {
            ans.add(0);
            ans.add(0);
        } else {
            ans.add((int) paths[n - 1][n - 1]);
            ans.add(maxVal[n - 1][n - 1]);
        }

        return ans;
    }
}