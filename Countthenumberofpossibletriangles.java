class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        if (n < 3) return 0;

        Arrays.sort(arr);
        int count = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;

            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
