class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1;
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int len = lps[i - 1];
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) len++;
            lps[i] = len;
        }

        int x = lps[n - 1];
        int smallestBorder = 0;
        while (x > 0) {
            smallestBorder = x;     
            x = lps[x - 1];
        }

        if (smallestBorder == 0) return -1;   
        return n - smallestBorder;            
    }
}
