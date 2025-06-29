class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        
        for (int num : arr) {
            low = Math.max(low, num); 
            high += num;             
        }
        
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(arr, k, mid)) {
                result = mid;     
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }
        
        return result;
    }
    
    private boolean canSplit(int[] arr, int k, int maxSumAllowed) {
        int currentSum = 0;
        int subarrays = 1;
        
        for (int num : arr) {
            if (currentSum + num > maxSumAllowed) {
                subarrays++;
                currentSum = num;
                if (subarrays > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
