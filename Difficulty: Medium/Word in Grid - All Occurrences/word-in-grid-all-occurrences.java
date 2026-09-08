class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == word.charAt(0)) {
                    if (search(mat, r, c, word, dx, dy)) {
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(r);
                        pos.add(c);
                        ans.add(pos);
                    }
                }
            }
        }
        return ans;
    }

    private boolean search(char[][] mat, int r, int c, String word, int[] dx, int[] dy) {
        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int k;
            int currR = r;
            int currC = c;

            for (k = 0; k < len; k++) {
                if (currR < 0 || currR >= n || currC < 0 || currC >= m) {
                    break;
                }
                if (mat[currR][currC] != word.charAt(k)) {
                    break;
                }
                currR += dx[dir];
                currC += dy[dir];
            }

            if (k == len) {
                return true;
            }
        }
        return false;
    }
}