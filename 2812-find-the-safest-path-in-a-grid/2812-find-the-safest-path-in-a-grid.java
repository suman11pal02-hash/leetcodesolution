class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
         int n = grid.size();   // ✅ use size() for List
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {   // ✅ use get()
                    dist[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr>=0 && nr<n && nc>=0 && nc<n && dist[nr][nc] == Integer.MAX_VALUE) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        int lo = 0, hi = 2*n; 
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canReach(dist, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(int[][] dist, int k) {
        int n = dist.length;
        if (dist[0][0] < k) return false;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n-1 && cur[1] == n-1) return true;
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr>=0 && nr<n && nc>=0 && nc<n && !vis[nr][nc] && dist[nr][nc] >= k) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}