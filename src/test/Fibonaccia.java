package test;

import java.util.Arrays;

/**
 * @author 胡霖翔
 */
public class Fibonaccia {
    //自顶向下备忘还是使用了递归
    public static int Fibonaccia(int n) {
        if (n <= 0) {
            return n;
        }
        int[] Memo = new int[n + 1];
        Arrays.fill(Memo, -1);
        return fibo(n, Memo);
    }

    public static int fibo(int n, int[] Memo) {
        //说明它这个值直接就有备注，直接返回值
        if (Memo[n] != -1) {
            return Memo[n];
        }
        if (n == 0) {
            Memo[n] = 0;
        } else if (n == 1) {
            Memo[n] = 1;
        } else {
            Memo[n] = fibo(n - 1, Memo) + fibo(n - 2, Memo);
        }
        return Memo[n];
    }

    //递归
    public static int digui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return digui(n - 1) + digui(n - 2);
    }

    //自底向上
    public static int Fibonaccia2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib2(n, memo);

    }


    public static int fib2(int n, int[] m) {
        m[0] = 0;
        m[1] = 1;
        for (int i = 2; i <= n; i++) {
            m[i] = m[i - 1] + m[i - 2];
        }
        return m[n];

    }


    public static void main(String[] args) {
        System.out.println(digui(7));
        System.out.println(Fibonaccia(7));
        System.out.println(Fibonaccia2(7));
    }


}
