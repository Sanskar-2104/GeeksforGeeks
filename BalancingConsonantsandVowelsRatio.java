class Solution {
    public int countBalanced(String[] arr) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  
        int prefixSum = 0;
        int balancedCount = 0;

        for (String s : arr) {
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (vowels.contains(ch)) {
                    count++;
                } else {
                    count--;
                }
            }
            prefixSum += count;

            balancedCount += prefixCount.getOrDefault(prefixSum, 0);
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return balancedCount;
    }
}
