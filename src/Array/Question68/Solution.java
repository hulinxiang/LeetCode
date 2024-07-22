package Array.Question68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int len = 0;
        List<String> tmp = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(words[i]);
            len += words[i].length();
            if (len + tmp.size() - 1 > maxWidth) { // 修改：len + tmp.size() - 1 考虑单词之间的空格
                len -= words[i].length();
                tmp.remove(tmp.size() - 1);
                ans.add(buildString(tmp, len, maxWidth));
                i -= 1;
                len = 0;
                tmp.clear();
            }
            // 到达最后一个元素
            if (i == n - 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : tmp) {
                    stringBuilder.append(s).append(" "); // 修改：使用 j 而不是 i
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1); // 删除最后一个多余的空格
                int space = maxWidth - stringBuilder.length();
                stringBuilder.append(" ".repeat(Math.max(0, space)));
                ans.add(stringBuilder.toString());
            }
        }
        return ans;
    }

    public static String buildString(List<String> list, int len, int maxWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        int space = maxWidth - len;
        int n = list.size();

        if (n == 1) { // 修改：处理单个单词的情况
            stringBuilder.append(list.get(0));
            while (stringBuilder.length() < maxWidth) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        int eachSpace = space / (n - 1);
        int extra = space % (n - 1);

        for (int i = 0; i < n - 1; i++) { // 修改：调整空格追加逻辑
            stringBuilder.append(list.get(i));
            for (int j = 0; j < eachSpace + (i < extra ? 1 : 0); j++) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(list.get(n - 1)); // 添加最后一个单词而不追加空格

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // 创建字符串数组
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        System.out.println(new Solution().fullJustify(words, 16));

    }


}
