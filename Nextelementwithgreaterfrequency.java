//http://geeksforgeeks.org/problems/next-element-with-greater-frequency--170637/1

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int currFreq = freqMap.get(arr[i]);
            while (!stack.isEmpty() && freqMap.get(stack.peek()) <= currFreq) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        for (int val : res) {
            result.add(val);
        }

        return result;
    }
}
