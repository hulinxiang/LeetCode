package bytedance.q4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;
    static ArrayList<E>[] g;
    static boolean[] isRed;
    static long sumPairs;
    static int m, k;

    static class E {
        int to;
        long w;

        E(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static long qpow(long a, long e) {
        long r = 1 % MOD;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) {
                r = (r * a) % MOD;
                a = (a * a) % MOD;
                e >>= 1;
            }
        }
        return r;
    }

    static long C(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            long num = (n - r + i) % MOD;
            long denInv = qpow(i, MOD - 2);
            res = (((res * num) % MOD) * denInv) % MOD;
        }
        return res;
    }

    static long dfs(int u, int p) {
        long cnt = isRed[u] ? 1 : 0;
        for (E e : g[u]) {
            int v = e.to;
            if (v == p) {
                continue;
            }
            long sub = dfs(v, u);
            long add = ((e.w % MOD) * (sub % MOD)) % MOD;
            add = (add * ((m - sub) % MOD)) % MOD;
            sumPairs += add;
            if (sumPairs >= MOD) {
                sumPairs -= MOD;
            }
            cnt += sub;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
    }
}
