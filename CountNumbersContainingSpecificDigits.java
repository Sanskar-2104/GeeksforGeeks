//https://www.geeksforgeeks.org/problems/count-numbers-containing-specific-digits/1

class Solution {
    public int countValid(int n, int[] arr) {
        boolean[] targetDigits = new boolean[10];
        for (int digit : arr) {
            targetDigits[digit] = true;
        }
        int totalDigits = 10;
        int totalNumbers = 9 * (int)Math.pow(10, n - 1);
        int countWithoutTarget = countWithoutDigits(n, targetDigits);
        return totalNumbers - countWithoutTarget;
    }

    private int countWithoutDigits(int n, boolean[] targetDigits) {
        int allowedFirstDigits = 0, allowedOtherDigits = 0;
        for (int d = 1; d <= 9; d++) {
            if (!targetDigits[d]) allowedFirstDigits++;
        }
        for (int d = 0; d <= 9; d++) {
            if (!targetDigits[d]) allowedOtherDigits++;
        }
        if (allowedFirstDigits == 0) return 0; 
        int count = allowedFirstDigits;
        for (int i = 1; i < n; i++) {
            count *= allowedOtherDigits;
        }
        return count;
    }
}
