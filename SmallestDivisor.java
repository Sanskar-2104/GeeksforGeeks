class Solution {
    int smallestDivisor(int[] arr, int k) {
        int left = 1;
        int right = getMax(arr); 
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (getSum(arr, mid) <= k) {
                result = mid;    
                right = mid - 1;
            } else {
                left = mid + 1;    
            }
        }

        return result;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    private int getSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;  
        }
        return sum;
    }
}
