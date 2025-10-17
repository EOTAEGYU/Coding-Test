class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] blocked = new boolean[n + 1][m + 1];

        // puddle 좌표 마킹
        for (int[] p : puddles) {
            blocked[p[1]][p[0]] = true; // y,x 순서
        }

        // 시작점
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (blocked[i][j]) {
                    dp[i][j] = 0; // puddle은 경로 없음
                    continue;
                }
                dp[i][j] = ((dp[i - 1][j] + dp[i][j - 1]) % MOD);
            }
        }

        return dp[n][m];
    }
}
