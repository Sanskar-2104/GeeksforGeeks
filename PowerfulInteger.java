//https://www.geeksforgeeks.org/problems/powerfull-integer--170647/1

class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int currCount = 0;
        int lastPosition = -1;
        int maxPowerful = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int delta = entry.getValue();

            if (currCount >= k && lastPosition != -1) {
                maxPowerful = Math.max(maxPowerful, point - 1);
            }

            currCount += delta;
            lastPosition = point;
        }

        return maxPowerful;
    }
}
