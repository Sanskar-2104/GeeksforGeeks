class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;
        
        // Expand around each possible center
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= 2) { // only count length >= 2
                    count++;
                }
                left--;
                right++;
            }
        }
        
        return count;
    }
}
