//https://www.geeksforgeeks.org/problems/tywins-war-strategy0527/1

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int neededLuckyTroops = (n + 1) / 2; 
        int alreadyLucky = 0;
        List<Integer> additions = new ArrayList<>();
        
        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                alreadyLucky++;
            } else {
                additions.add(k - (soldiers % k));
            }
        }
        
        if (alreadyLucky >= neededLuckyTroops) return 0;
        
        Collections.sort(additions);
        
        int troopsToConvert = neededLuckyTroops - alreadyLucky;
        int totalAdded = 0;
        
        for (int i = 0; i < troopsToConvert; i++) {
            totalAdded += additions.get(i);
        }
        
        return totalAdded;
    }
}
