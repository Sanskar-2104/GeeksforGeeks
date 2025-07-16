//https://www.geeksforgeeks.org/problems/nine-divisors3751/1

class Solution {
    public static int countNumbers(int n) {
        List<Integer> primes = sieve((int)Math.sqrt(n));
        int count = 0;
        for (int p : primes) {
            long num = (long) Math.pow(p, 8);
            if (num <= n) count++;
            else break;
        }
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long pSquared = (long)primes.get(i) * primes.get(i);
            if (pSquared > n) break;

            for (int j = i + 1; j < size; j++) {
                long qSquared = (long)primes.get(j) * primes.get(j);
                if (pSquared * qSquared <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    private static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }
}
