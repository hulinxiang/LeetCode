package Question2580;

import java.util.Arrays;

class Solution {
    private int mod = 1000000007;

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> (a[0] - b[0]));
        int m = 1;
        int maxRight = ranges[0][1];
        for (int[] range : ranges) {
            if (range[0] > maxRight) {
                m++;
            }
            maxRight = Math.max(range[1], maxRight);
        }

        return fastPow(m);
    }

    public int fastPow(int m) {
        long res = 1;
        long n = 2;
        for (; m > 0; m >>= 1) {
            if ((m & 1) == 1) {
                res = res * n % mod;
            }
            n = n * n % mod;
        }
        return (int) res;
    }


}
