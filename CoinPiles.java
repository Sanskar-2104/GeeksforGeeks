

import java.util.Arrays;

class Solution {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        long totalSum = 0;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
            totalSum += arr[i];
        }

        long minCoinsToRemove = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long coinsRemovedBefore = prefixSum[i];
            int low = i, high = n - 1, j = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > arr[i] + k) {
                    j = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            long coinsToRemoveAfter = prefixSum[n] - prefixSum[j] - (long)(n - j) * (arr[i] + k);

            minCoinsToRemove = Math.min(minCoinsToRemove, coinsRemovedBefore + coinsToRemoveAfter);
        }

        return (int)minCoinsToRemove;
    }
}
