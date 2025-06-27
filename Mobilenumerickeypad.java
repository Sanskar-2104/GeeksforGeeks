class Solution {
    static final int[][] moves = {
        {0, 8},     
        {1, 2, 4},  
        {2, 1, 3, 5},
        {3, 2, 6},
        {4, 1, 5, 7},
        {5, 2, 4, 6, 8},
        {6, 3, 5, 9},
        {7, 4, 8},
        {8, 0, 5, 7, 9},
        {9, 6, 8}
    };

    public int getCount(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 10;
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int move : moves[digit]) {
                    dp[i][digit] += dp[i - 1][move];
                }
            }
        }

        int total = 0;
        for (int i = 0; i <= 9; i++) {
            total += dp[n][i];
        }

        return total;
    }
}
