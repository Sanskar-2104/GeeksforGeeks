//https://www.geeksforgeeks.org/problems/game-with-string4100/1

class Solution {
    public int minValue(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        while (k > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            top--;
            k--;
            if (top > 0) {
                maxHeap.add(top);
            }
        }

        int result = 0;
        while (!maxHeap.isEmpty()) {
            int val = maxHeap.poll();
            result += val * val;
        }

        return result;
    }
}
