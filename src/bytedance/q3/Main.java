package bytedance.q3;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
// 给定一个长度为n的非增整数数组，a1>=a2>=a3>=...>=an
// 允许进行任意次以下操作，
// 选择两个索引 i<j，同时将ai修改为ai+aj，aj修改为0
// 操作结束后计算 求和从1到n [min(a1,....,ai)+max(ai,...,an)]
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
