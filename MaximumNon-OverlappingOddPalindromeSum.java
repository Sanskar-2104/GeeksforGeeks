//https://www.geeksforgeeks.org/problems/maximum-non-overlapping-odd-palindrome-sum/1

class Solution {
    public int maxSum(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] d = manacherOdd(s); 
        int[] bestEnd = new int[n];t
        int[] bestStart = new int[n];

        for (int i = 0; i < n; i++) {
            int radius = d[i];
            int len = 2 * radius - 1;
            int start = i - radius + 1;
            int end = i + radius - 1;
            if (bestEnd[end] < len) bestEnd[end] = len;
            if (bestStart[start] < len) bestStart[start] = len;
        }
        for (int i = n - 2; i >= 0; i--) {
            int candidate = bestEnd[i + 1] - 2;
            if (candidate < 0) candidate = 0;
            if (bestEnd[i] < candidate) bestEnd[i] = candidate;
        }
        int[] maxLeft = new int[n];
        maxLeft[0] = bestEnd[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], bestEnd[i]);
        }
        for (int i = 1; i < n; i++) {
            int candidate = bestStart[i - 1] - 2;
            if (candidate < 0) candidate = 0;
            if (bestStart[i] < candidate) bestStart[i] = candidate;
        }
        int[] maxRight = new int[n];
        maxRight[n - 1] = bestStart[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], bestStart[i]);
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, maxLeft[i] + maxRight[i + 1]);
        }
        return ans;
    }
    private int[] manacherOdd(String s) {
        int n = s.length();
        int[] d = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = 1;
            if (i <= r) {
                k = Math.min(d[l + r - i], r - i + 1);
            }
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }
            d[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }
        return d;
    }
}
