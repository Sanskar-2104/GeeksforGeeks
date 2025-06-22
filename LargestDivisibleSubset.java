//https://www.geeksforgeeks.org/problems/largest-divisible-subset--170643/1

import java.util.*;

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); 
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) prev[i] = i;

        int maxLen = 1, maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] % arr[i] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int curr = maxIdx;

        while (prev[curr] != curr) {
            result.add(arr[curr]);
            curr = prev[curr];
        }
        result.add(arr[curr]);

        Collections.sort(result);
        return result;
    }
}
