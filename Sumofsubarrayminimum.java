//https://www.geeksforgeeks.org/problems/sum-of-subarray-minimum/1

class Solution {
    public int sumSubMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long count = (i - prevLess[i]) * (nextLess[i] - i) % MOD;
            sum = (sum + arr[i] * count % MOD) % MOD;
        }

        return (int)sum;
    }
}
