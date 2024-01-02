package Question541;

import java.util.Arrays;

public class Solution {
    public String reverseStr(String s, int k) {
        int num = s.length() / k;
        if (s.length() % k != 0) {
            num++;
        }
        char[][] subRes = new char[num][];
        for (int i = 0; i < num - 1; i++) {
            subRes[i] = s.substring(i * k, (i + 1) * k).toCharArray();
        }
        subRes[num - 1] = s.substring((num - 1) * k).toCharArray();
        for (int i = 0; i < num; i+=2) {
            reverse(subRes[i]);
        }
        char[] res = new char[s.length()];
        int i = 0;
        for (char[] sub : subRes) {
            for (char chars : sub) {
                res[i++] = chars;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char ss:res){
            ans.append(ss);
        }
        return ans.toString();
    }

    public static void reverse(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char cur = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = cur;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.reverseStr(s, k));
    }

}
