class Solution {
    static final int MAX = 10001;

    int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];
        int n = arr.length;
        for (int num : arr) {
            freq[num]++;
        }
        int[] multiples = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                multiples[i] += freq[j];
            }
        }
        long[] dp = new long[MAX];
        for (int i = MAX - 1; i >= 1; i--) {
            dp[i] = ((long)multiples[i] * (multiples[i] - 1)) / 2;
            for (int j = 2 * i; j < MAX; j += i) {
                dp[i] -= dp[j];
            }
        }

        return (int) dp[1]; 
    }
}
