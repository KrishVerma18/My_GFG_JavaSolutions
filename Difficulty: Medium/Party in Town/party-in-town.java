import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int far1 = bfs(1, n, adj)[0];
        int[] far2 = bfs(far1, n, adj);
        return (far2[1] + 1) / 2;
    }

    private int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        int[] q = new int[n + 1];
        int head = 0, tail = 0;

        q[tail++] = start;
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (head < tail) {
            int curr = q[head++];
            int d = dist[curr];

            if (d > maxDist) {
                maxDist = d;
                farthestNode = curr;
            }

            for (int neighbor : adj.get(curr - 1)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = d + 1;
                    q[tail++] = neighbor;
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}