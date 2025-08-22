//https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);       
            high = Math.max(high, mat[i][m - 1]); 
        }
        
        int desired = (n * m + 1) / 2; 
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }
            
            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private int upperBound(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; 
    }
}
