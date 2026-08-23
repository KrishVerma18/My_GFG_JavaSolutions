class Solution {
    static class Node {
        int r, c, u, d;
        Node(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }
    }

    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        if (mat[r][c] == '#') return 0;

        int n = mat.length;
        int m = mat[0].length;

        int[][] visU = new int[n][m];
        int[][] visD = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visU[i][j] = -1;
                visD[i][j] = -1;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, u, d));
        visU[r][c] = u;
        visD[r][c] = d;

        int count = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                int nu = curr.u - (dr[i] == -1 ? 1 : 0);
                int nd = curr.d - (dr[i] == 1 ? 1 : 0);

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == '.' && nu >= 0 && nd >= 0) {
                    if (nu > visU[nr][nc] || nd > visD[nr][nc]) {
                        if (nu > visU[nr][nc]) visU[nr][nc] = nu;
                        if (nd > visD[nr][nc]) visD[nr][nc] = nd;
                        q.add(new Node(nr, nc, nu, nd));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visU[i][j] != -1) count++;
            }
        }

        return count;
    }
}