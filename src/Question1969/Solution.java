package Question1969;

public class Solution {
    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long mod = (long) (1e9 + 7);
        //x:2^p-1
        long x = fastPow(2, p, mod) - 1;
        //y:2^(p-1)
        long y = (long) 1 << (p - 1);
        long cur = fastPow(x - 1, y - 1, mod);
        return (int) (cur * x % mod);


    }

    //快速幂的思想就是：先把指数p转化为二进制形式
    //再把该二进制形式下每个位置上的1对应的十进制数求指数然后依次乘起来
    public long fastPow(long n, long p, long mod) {
        long res = 1;
        for (; p >= 1; p = p >> 1) {
            if ((p & 1) == 1) {
                res = res * n % mod;
            }
            n = n * n % mod;
        }
        return res;
    }

}
