class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;
        int[] moves = new int[target + 1];

        for (int i = 0; i < lad.length; i += 2) {
            moves[lad[i]] = lad[i + 1];
        }
        for (int i = 0; i < sn.length; i += 2) {
            moves[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[target + 1];
        java.util.Queue<Integer> q = new java.util.LinkedList<>();

        q.add(1);
        visited[1] = true;
        int throwsCount = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == target) return throwsCount;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next <= target) {
                        if (moves[next] != 0) {
                            next = moves[next];
                        }
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
            throwsCount++;
        }

        return -1;
    }
}