//https://www.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1

class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        Arrays.sort(b);
        ArrayList<Integer> result = new ArrayList<>();

        for (int val : a) {
            int count = upperBound(b, val);
            result.add(count);
        }

        return result;
    }

    private static int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= x) {
                left = mid + 1; 
            } else {
                right = mid;    
            }
        }
        return left; 
    }
}
