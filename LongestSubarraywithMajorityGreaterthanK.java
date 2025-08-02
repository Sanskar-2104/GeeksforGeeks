//https://www.geeksforgeeks.org/problems/longest-subarray-with-majority-greater-than-k/1

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = (arr[i] > k) ? 1 : -1;
        }
        Map<Integer, Integer> prefixIndex = new HashMap<>();
        int maxLen = 0, prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += temp[i];
            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                if (prefixIndex.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - prefixIndex.get(prefixSum - 1));
                }
            }
            if (!prefixIndex.containsKey(prefixSum)) {
                prefixIndex.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
