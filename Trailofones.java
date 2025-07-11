//https://www.geeksforgeeks.org/problems/trail-of-ones3242/1

class Solution {
    public int countConsec(int n) {
        if (n < 2) return 0;
        
        int[] a = new int[n + 1]; 
        int[] b = new int[n + 1]; 
        
        a[1] = 1;
        b[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        
        int noConsec = a[n] + b[n];
        int total = (int) Math.pow(2, n);
        
        return total - noConsec;
    }
}
