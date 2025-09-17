package bytedance.q1;

import java.util.ArrayList;
import java.util.Scanner;

// Tk有一个长度为n的仅有小写字母构成的字符串，长度为s，下标从1开始
// 要求：按照编号从小到大的顺序，依次对每个字符串执行以下操作：
// 定义对于位置i，记x为位置i之后（不包括si）与si相同的字符个数；
// 如果满足n-i<x乘26,则将si修改为对应的大写字母
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int len = 0;
        String s = null;

        len = in.nextInt();
        in.nextLine();
        s = in.nextLine();


        String res = new Main().parseString(len, s);
        System.out.println(res);
    }

    private String parseString(int len, String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            freq[index]--;
            int x = freq[index];
            int after = len - i - 1;
            if (after < x * 26) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
