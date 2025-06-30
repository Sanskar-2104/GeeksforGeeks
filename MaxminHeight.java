class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int h : arr) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }
        high += k; 

        int result = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReachHeight(arr, k, w, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private boolean canReachHeight(int[] arr, int k, int w, int targetHeight) {
        int n = arr.length;
        int[] water = new int[n + 1]; 
        long operations = 0;
        long currWater = 0;

        for (int i = 0; i < n; i++) {
            currWater += water[i];
            long currentHeight = arr[i] + currWater;

            if (currentHeight < targetHeight) {
                long diff = targetHeight - currentHeight;
                operations += diff;
                if (operations > k) return false;

                currWater += diff;
                if (i + w < n) {
                    water[i + w] -= diff;
                }
            }
        }

        return true;
    }
}
