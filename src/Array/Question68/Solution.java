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
            if (len + tmp.size() - 1 > maxWidth) { // �޸ģ�len + tmp.size() - 1 ���ǵ���֮��Ŀո�
                len -= words[i].length();
                tmp.remove(tmp.size() - 1);
                ans.add(buildString(tmp, len, maxWidth));
                i -= 1;
                len = 0;
                tmp.clear();
            }
            // �������һ��Ԫ��
            if (i == n - 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : tmp) {
                    stringBuilder.append(s).append(" "); // �޸ģ�ʹ�� j ������ i
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1); // ɾ�����һ������Ŀո�
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

        if (n == 1) { // �޸ģ����������ʵ����
            stringBuilder.append(list.get(0));
            while (stringBuilder.length() < maxWidth) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        int eachSpace = space / (n - 1);
        int extra = space % (n - 1);

        for (int i = 0; i < n - 1; i++) { // �޸ģ������ո�׷���߼�
            stringBuilder.append(list.get(i));
            for (int j = 0; j < eachSpace + (i < extra ? 1 : 0); j++) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(list.get(n - 1)); // ������һ�����ʶ���׷�ӿո�

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // �����ַ�������
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        System.out.println(new Solution().fullJustify(words, 16));

    }


}
