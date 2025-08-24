class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        
        if ((long)m * k > n) return -1;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int val : arr) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(arr, k, m, mid)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }
    
    private boolean canMakeBouquets(int[] arr, int k, int m, int day) {
        int count = 0, bouquets = 0;
        for (int val : arr) {
            if (val <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0; 
                }
            } else {
                count = 0; 
            }
            if (bouquets >= m) return true;
        }
        return false;
    }
}
