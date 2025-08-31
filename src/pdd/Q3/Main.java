package pdd.Q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        String A = sc.next();
        String B = sc.next();

        int[] freqA = buildFreq(A);
        int[] freqB = buildFreq(B);

        long[] cntA = buildCntAtLeast(freqA);
        long[] cntB = buildCntAtLeast(freqB);

        if (k <= 0) {
            System.out.println(0);
            return;
        }

        long ans = 0;
        for (long d = 1; d * d <= k; d++) {
            if (k % d != 0) {
                continue;
            }
            long h = d;
            long w = k / d;
            if (h <= n && w <= m) {
                ans += cntA[(int) h] * cntB[(int) w];
            }
            if (h != w) {
                long h2 = w, w2 = h;
                if (h2 <= n && w2 <= m) {
                    ans += cntA[(int) h2] * cntB[(int) w2];
                }
            }
        }
        System.out.println(ans);
    }

    private static int[] buildFreq(String str) {
        int n = str.length();
        int[] freq = new int[n + 1];
        int run = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a') {
                run++;
            } else {
                if (run > 0) {
                    freq[run]++;
                }
                run = 0;
            }
        }
        if (run > 0) {
            freq[run]++;
        }
        return freq;
    }

    private static long[] buildCntAtLeast(int[] freq) {
        int n = freq.length - 1;
        long[] F = new long[n + 2];
        long[] G = new long[n + 2];
        for (int L = n; L >= 1; L--) {
            F[L] = F[L + 1] + freq[L];
            G[L] = G[L + 1] + (long) L * freq[L];
        }
        long[] cnt = new long[n + 1];
        for (int t = 1; t <= n; t++) {
            cnt[t] = G[t] - (long) (t - 1) * F[t];
        }
        return cnt;

    }

}
