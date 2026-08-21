import java.util.*;

class Solution {

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long findKthSmallest(int[] coins, int k) {

        Arrays.sort(coins);

        // Remove redundant coins
        // Example: [2, 4, 8] -> only [2] is needed
        List<Long> list = new ArrayList<>();

        for (int coin : coins) {
            boolean redundant = false;

            for (long x : list) {
                if (coin % x == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                list.add((long) coin);
            }
        }

        int n = list.size();

        long low = 1;
        long high = list.get(0) * k;

        // Binary search
        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, list, n) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    long count(long x, List<Long> coins, int n) {

        long result = 0;

        // Inclusion-Exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    lcm = lcm(lcm, coins.get(i));

                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) {
                continue;
            }

            long multiples = x / lcm;

            // Odd number of coins -> add
            // Even number of coins -> subtract
            if (Integer.bitCount(mask) % 2 == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }

        return result;
    }
}