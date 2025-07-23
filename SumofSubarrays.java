//https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1

class Solution {
    public int subarraySum(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i] * (i + 1) * (n - i);
        }

        return totalSum;
    }
}
