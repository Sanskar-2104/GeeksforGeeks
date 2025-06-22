import java.util.*;

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);  
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[j] + 1 >= dp[i]) {
                    if (dp[j] + 1 > dp[i] || (dp[j] + 1 == dp[i] && arr[j] > arr[prev[i]])) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > dp[maxIndex] || 
                (dp[i] == dp[maxIndex] && arr[i] > arr[maxIndex])) {
                maxIndex = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (maxIndex >= 0) {
            result.add(arr[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.sort(result);  
        return result;
    }
}
