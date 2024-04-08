package test;

import java.util.Arrays;

/**
 * @author ������
 */
public class Fibonaccia {
    //�Զ����±�������ʹ���˵ݹ�
    public static int Fibonaccia(int n) {
        if (n <= 0) {
            return n;
        }
        int[] Memo = new int[n + 1];
        Arrays.fill(Memo, -1);
        return fibo(n, Memo);
    }

    public static int fibo(int n, int[] Memo) {
        //˵�������ֱֵ�Ӿ��б�ע��ֱ�ӷ���ֵ
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

    //�ݹ�
    public static int digui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return digui(n - 1) + digui(n - 2);
    }

    //�Ե�����
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
