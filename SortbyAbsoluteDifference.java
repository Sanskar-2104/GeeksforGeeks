//https://www.geeksforgeeks.org/problems/sort-by-absolute-difference-1587115621/1

class Solution {
    public void rearrange(int[] arr, int x) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], i});
        }
        Collections.sort(list, (a, b) -> {
            int diff1 = Math.abs(a[0] - x);
            int diff2 = Math.abs(b[0] - x);
            if (diff1 != diff2) {
                return diff1 - diff2; 
            } else {
                return a[1] - b[1];  
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i)[0];
        }
    }
}
