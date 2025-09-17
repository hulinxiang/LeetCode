package bytedance.q2;

import java.util.Scanner;

// 每个测试文件均包含多组测试数据。第一行输入一个整数T代表数据组数，每组测试数据描述如下：
// 第一行输入一个整数n代表数组长度
// 第二行输入n个整数a1，a2，...an (-n<=ai<=n),表示数组元素

// 对于每个数组关注符合以下规则的数量，1<=i<j<=n,aixaj<=ai+aj

//其实问题就转换成(x-1)(y-1)<=1
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = in.nextInt(); // n组数据
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            Main.followRules(arr);
        }

    }

    private static void followRules(int[] arr) {
        long PosNum = 0;
        long NegNum = 0;
        long Pos1 = 0;
        long Neg1 = 0;
        long zero = 0;
        for (int i : arr) {
            int x = i - 1;
            if (x > 0) {
                PosNum++;
                if (x == 1) {
                    Pos1++;
                }
            }

            if (x == 0) {
                zero++;
            }
            if (x < 0) {
                NegNum++;
                if (x == -1) {
                    Neg1++;
                }
            }
        }
        long invalidPos = PosNum * (PosNum - 1) / 2 - Pos1 * (Pos1 - 1) / 2;
        long invalidNeg = NegNum * (NegNum - 1) / 2 - Neg1 * (Neg1 - 1) / 2;
        long valid = (long) arr.length * (arr.length - 1) / 2 - invalidNeg - invalidPos;

        System.out.println(valid);
    }
}
