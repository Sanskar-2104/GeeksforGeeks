//https://www.geeksforgeeks.org/problems/maximum-sum-of-elements-not-part-of-lis/1

class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int lisLength = 0;
        for (int val : dp) {
            lisLength = Math.max(lisLength, val);
        }
        
        boolean[] isInLIS = new boolean[n];
        int currentLength = lisLength;
        int last = Integer.MAX_VALUE;
        
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == currentLength && arr[i] < last) {
                isInLIS[i] = true;
                last = arr[i];
                currentLength--;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!isInLIS[i]) {
                sum += arr[i];
            }
        }
        
        return sum;
    }
}
