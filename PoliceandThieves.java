class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thieves = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }

            while (!police.isEmpty() && !thieves.isEmpty()) {
                int p = police.peek();
                int t = thieves.peek();
                
                if (Math.abs(p - t) <= k) {
                    count++;
                    police.poll();
                    thieves.poll();
                } else if (t < p) {
                    thieves.poll();
                } else {
                    police.poll(); 
                }
            }
        }

        return count;
    }
}
