//https://www.geeksforgeeks.org/problems/equalize-the-towers2804/1

import java.util.*;

class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = heights[i];
            pair[i][1] = cost[i];
        }
        Arrays.sort(pair, Comparator.comparingInt(a -> a[0]));
        long totalCost = 0;
        for (int[] p : pair) {
            totalCost += p[1];
        }
        long currCost = 0;
        int targetHeight = 0;
        for (int i = 0; i < n; i++) {
            currCost += pair[i][1];
            if (currCost >= (totalCost + 1) / 2) {
                targetHeight = pair[i][0];
                break;
            }
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) Math.abs(heights[i] - targetHeight) * cost[i];
        }

        return (int) result;
    }
}
