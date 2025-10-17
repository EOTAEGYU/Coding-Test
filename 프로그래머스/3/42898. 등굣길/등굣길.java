class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n + 1][m + 1];
        int MOD = 1_000_000_007;

        // 물에 잠긴 곳 표시
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            arr[y][x] = -1; // 주의: arr[y][x]
        }

        // 시작점
        arr[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점은 건드리지 않음
                if (i == 1 && j == 1) continue;

                if (arr[i][j] == -1) {
                    arr[i][j] = 0; // 물웅덩이는 경로 없음
                    continue;
                } else {
                        arr[i][j] += arr[i - 1][j];
                        arr[i][j] += arr[i][j - 1];
                    
                    arr[i][j] %= MOD;
                }
            }
        }

        return arr[n][m];
    }
}
