class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        {
        int n = board.size(), MOD = 1_000_000_007;
        int[][] dpSum = new int[n][n];
        int[][] dpCount = new int[n][n];
        for (int[] row : dpSum) Arrays.fill(row, -1);
        dpSum[n-1][n-1] = 0;
        dpCount[n-1][n-1] = 1;
        for (int r = n-1; r >= 0; r--) {
            for (int c = n-1; c >= 0; c--) {
                if (board.get(r).charAt(c) == 'X' || dpSum[r][c] == -1) continue;
                int val = Character.isDigit(board.get(r).charAt(c)) ? board.get(r).charAt(c) - '0' : 0;
                int[][] dirs = {{-1,0},{0,-1},{-1,-1}};
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nc < 0 || board.get(nr).charAt(nc) == 'X') continue;
                    int newSum = dpSum[r][c] + val;
                    if (newSum > dpSum[nr][nc]) {
                        dpSum[nr][nc] = newSum;
                        dpCount[nr][nc] = dpCount[r][c];
                    } else if (newSum == dpSum[nr][nc]) {
                        dpCount[nr][nc] = (int)((dpCount[nr][nc] + (long)dpCount[r][c]) % MOD);
                    }
                }
            }
        }
        return dpSum[0][0] == -1 ? new int[]{0,0} : new int[]{dpSum[0][0], dpCount[0][0]};
    }
}
}