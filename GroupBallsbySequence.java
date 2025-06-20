//https://www.geeksforgeeks.org/problems/group-balls-by-sequence/1

import java.util.*;

class Solution {
    public boolean validgroup(int[] arr, int k) {
        if (arr.length % k != 0) return false;
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        while (!countMap.isEmpty()) {
            int first = countMap.firstKey(); 
            for (int i = 0; i < k; i++) {
                int current = first + i;
                if (!countMap.containsKey(current)) {
                    return false;
                }
                countMap.put(current, countMap.get(current) - 1);
                if (countMap.get(current) == 0) {
                    countMap.remove(current);
                }
            }
        }
        return true;
    }
}
