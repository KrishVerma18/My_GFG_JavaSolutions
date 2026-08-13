class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];
                    if (dist[u] + w > dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        return dist;
    }

    private void topoSort(int u, ArrayList<ArrayList<int[]>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int[] neighbor : adj.get(u)) {
            if (!visited[neighbor[0]]) {
                topoSort(neighbor[0], adj, visited, stack);
            }
        }
        stack.push(u);
    }
}