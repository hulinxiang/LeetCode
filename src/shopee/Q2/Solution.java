package shopee.Q2;

import java.util.Scanner;

public class Solution {

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param s string字符串
     * @return int整型
     */
    public int MinOperations(String s) {
        // s为一个只有AB组成的字符创，求解最少多少步骤能变成互斥字符串
        int n = s.length();
        String s1 = buildString(n, 'A');
        String s2 = buildString(n, 'B');
        return Math.min(compare(s1, s), compare(s2, s));
    }

    public String buildString(int n, char c) {
        StringBuilder str = new StringBuilder();
        char[] chars = new char[]{'A', 'B'};
        if (c == chars[0]) {
            for (int i = 0; i < n; i++) {
                str.append(chars[i % 2]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                str.append(chars[(i + 1) % 2]);
            }
        }
        return str.toString();
    }

    public int compare(String s1, String s2) {
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(new Solution().MinOperations(s));
        sc.close();
    }

}
