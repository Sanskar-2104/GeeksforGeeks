class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int res = helper(s, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(String s, int index, int[] dp) {
        if (index == s.length()) return 0;  

        if (dp[index] != -1) return dp[index];

        int minCuts = Integer.MAX_VALUE;

        for (int end = index; end < s.length(); end++) {
            if (isPowerOf5(s.substring(index, end + 1))) {
                int cuts = helper(s, end + 1, dp);
                if (cuts != Integer.MAX_VALUE) {
                    minCuts = Math.min(minCuts, 1 + cuts);
                }
            }
        }
        return dp[index] = minCuts;
    }

    private boolean isPowerOf5(String str) {
        if (str.charAt(0) == '0') return false;  

        long num = Long.parseLong(str, 2);  
        if (num == 0) return false;

        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
