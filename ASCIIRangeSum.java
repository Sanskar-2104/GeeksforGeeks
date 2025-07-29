//https://www.geeksforgeeks.org/problems/ascii-range-sum/1

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = s.length();
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!first.containsKey(ch)) {
                first.put(ch, i);
            }
            last.put(ch, i);
        }
        for (char ch : first.keySet()) {
            int start = first.get(ch);
            int end = last.get(ch);

            if (end > start + 1) {
                int sum = 0;
                for (int i = start + 1; i < end; i++) {
                    sum += (int) s.charAt(i);
                }
                if (sum != 0) {
                    result.add(sum);
                }
            }
        }

        return result;
    }
}
