//https://www.geeksforgeeks.org/problems/count-reverse-pairs/1

class Solution {
    public int countRevPairs(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(arr, low, mid) + mergeSort(arr, mid + 1, high);
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        merge(arr, low, mid, high);
        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];
        
        for (int p = 0; p < temp.length; p++) {
            arr[low + p] = temp[p];
        }
    }
}
