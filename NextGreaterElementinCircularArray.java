//https://www.geeksforgeeks.org/problems/next-greater-element/1

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[index]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    result.set(index, arr[stack.peek()]);
                }
            }
            stack.push(index);
        }

        return result;
    }
}
