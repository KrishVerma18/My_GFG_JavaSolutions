class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean[][] unsafe = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    unsafe[i][j] = true;
                    for (int[] d : dirs) {
                        int r = i + d[0];
                        int c = j + d[1];
                        if (r >= 0 && r < n && c >= 0 && c < m) {
                            unsafe[r][c] = true;
                        }
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                q.add(new int[]{i, 0, 1});
                visited[i][0] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (c == m - 1) {
                return dist;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !unsafe[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}