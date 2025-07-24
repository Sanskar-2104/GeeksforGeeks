//https://www.geeksforgeeks.org/problems/last-moment-before-all-ants-fall-out-of-a-plank/1

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;
        for (int position : left) {
            maxTime = Math.max(maxTime, position); 
        }
        for (int position : right) {
            maxTime = Math.max(maxTime, n - position); 
        }
        
        return maxTime;
    }
}
