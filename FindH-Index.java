//https://www.geeksforgeeks.org/problems/find-h-index--165609/1

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        
        for (int i = 0; i < n; i++) {
            int papersWithAtLeast = n - i; 
            if (citations[i] >= papersWithAtLeast) {
                h = papersWithAtLeast;
                break;
            }
        }
        
        return h;
    }
}
