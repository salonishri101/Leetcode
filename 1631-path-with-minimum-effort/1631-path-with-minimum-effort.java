class Solution {



        class Pair {
        int row;
        int col;
        int effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }



    public int minimumEffortPath(int[][] heights) {


 int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.effort - b.effort);

        pq.add(new Pair(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};


         while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int r =curr.row;
            int c =curr.col;
            int currEffort=curr.effort;

               if (r == n - 1 && c == m - 1)
                return currEffort;

            if (currEffort > dist[r][c])
                continue;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    int edgeWeight =
                        Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort =
                        Math.max(currEffort, edgeWeight);

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        
         }
        return 0;
         




        
    }
}