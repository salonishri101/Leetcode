import java.util.*;

class Solution {

    class Pair {
        int node;
        int dist;
        int count;

        Pair(int node, int dist, int count) {
            this.node = node;
            this.dist = dist;
            this.count = count;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        if (k == 0) {
            return -1;
        }

        // Directed graph
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new int[]{v, wt});
        }

        // dist[node][count]
        int[][] dist = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Source node's label has consecutive count 1
        dist[0][1] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        pq.offer(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int u = curr.node;
            int currDist = curr.dist;
            int count = curr.count;

            if (currDist != dist[u][count]) {
                continue;
            }

            // Destination reached
            if (u == n - 1) {
                return currDist;
            }

            for (int[] edge : graph.get(u)) {

                int v = edge[0];
                int wt = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Consecutive identical characters cannot exceed k
                if (newCount > k) {
                    continue;
                }

                int newDist = currDist + wt;

                if (newDist < dist[v][newCount]) {

                    dist[v][newCount] = newDist;

                    pq.offer(new Pair(v, newDist, newCount));
                }
            }
        }

        return -1;
    }
}