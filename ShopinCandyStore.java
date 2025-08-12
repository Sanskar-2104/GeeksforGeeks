class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(prices); 
        int minCost = 0;
        int start = 0;
        int end = prices.length - 1;
        while (start <= end) {
            minCost += prices[start]; /
            start++;
            end -= k; 
        }
        int maxCost = 0;
        start = 0;
        end = prices.length - 1;
        while (end >= start) {
            maxCost += prices[end]; 
            end--;
            start += k; 
        }
        
        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}
