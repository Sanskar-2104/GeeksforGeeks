//https://www.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1

class Solution {
    public int substrCount(String s, int k) {
        int n = s.length();
        if(k > n) return 0;
        
        int count = 0;
        
        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            for (int j = i; j < i + k; j++) {
                int index = s.charAt(j) - 'a';
                if (freq[index] == 0) {
                    distinct++;
                }
                freq[index]++;
            }
            if (distinct == k - 1) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String s1 = "abcc";
        int k1 = 2;
        System.out.println("Output: " + sol.substrCount(s1, k1)); 
        
        String s2 = "aabab";
        int k2 = 3;
        System.out.println("Output: " + sol.substrCount(s2, k2)); 
    }
}
