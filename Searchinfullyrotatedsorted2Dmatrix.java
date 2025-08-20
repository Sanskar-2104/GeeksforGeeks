class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = mat[mid / m][mid % m];

            if (midElement == x) return true;

            if (mat[low / m][low % m] <= midElement) {
                if (mat[low / m][low % m] <= x && x < midElement) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            else {
                if (midElement < x && x <= mat[high / m][high % m]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
