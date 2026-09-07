class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, n, n, arr, dp);
    }

    private int solve(int i, int lastInc, int lastDec, int[] arr, int[][][] dp) {
        if (i == arr.length) {
            return 0;
        }

        if (dp[i][lastInc][lastDec] != -1) {
            return dp[i][lastInc][lastDec];
        }

        int res = 1 + solve(i + 1, lastInc, lastDec, arr, dp);

        if (lastInc == arr.length || arr[i] > arr[lastInc]) {
            res = Math.min(res, solve(i + 1, i, lastDec, arr, dp));
        }

        if (lastDec == arr.length || arr[i] < arr[lastDec]) {
            res = Math.min(res, solve(i + 1, lastInc, i, arr, dp));
        }

        return dp[i][lastInc][lastDec] = res;
    }
}