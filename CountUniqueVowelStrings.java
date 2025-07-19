//https://www.geeksforgeeks.org/problems/count-unique-vowel-strings/1

class Solution {
    public int vowelCount(String s) {
        Map<Character, List<Integer>> vowelMap = new HashMap<>();
        String vowels = "aeiou";
        for (char c : vowels.toCharArray()) {
            vowelMap.put(c, new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowelMap.containsKey(c)) {
                vowelMap.get(c).add(i);
            }
        }
        List<Character> presentVowels = new ArrayList<>();
        for (char c : vowels.toCharArray()) {
            if (!vowelMap.get(c).isEmpty()) {
                presentVowels.add(c);
            }
        }
        if (presentVowels.isEmpty()) return 0;
        int totalWays = 1;
        for (char c : presentVowels) {
            totalWays *= vowelMap.get(c).size();
        }
        totalWays *= factorial(presentVowels.size());

        return totalWays;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
