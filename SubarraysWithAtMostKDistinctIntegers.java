class Solution {
    public int countAtMostK(int[] arr, int k) {
        int left = 0, right = 0;
        int count = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            while (freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
    
    public int subarraysWithAtMostKDistinct(int[] arr, int k) {
        return countAtMostK(arr, k);
    }

    public int subarraysWithExactlyKDistinct(int[] arr, int k) {
        return countAtMostK(arr, k) - countAtMostK(arr, k - 1);
    }

}
