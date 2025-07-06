class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.sum - x.sum);
        Set<String> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        int i = n - 1, j = n - 1;
        maxHeap.add(new Pair(a[i] + b[j], i, j));
        visited.add(i + "," + j);

        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            result.add(curr.sum);
            if (curr.i - 1 >= 0 && !visited.contains((curr.i - 1) + "," + curr.j)) {
                maxHeap.add(new Pair(a[curr.i - 1] + b[curr.j], curr.i - 1, curr.j));
                visited.add((curr.i - 1) + "," + curr.j);
            }
            if (curr.j - 1 >= 0 && !visited.contains(curr.i + "," + (curr.j - 1))) {
                maxHeap.add(new Pair(a[curr.i] + b[curr.j - 1], curr.i, curr.j - 1));
                visited.add(curr.i + "," + (curr.j - 1));
            }
        }

        return result;
    }

    class Pair {
        int sum;
        int i;
        int j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
}
