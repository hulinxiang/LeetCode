package GreedyAlgorithm.Question2663;

public class Solution {
    /**
     * ��Ϊ�����ַ������������Ĵ�������������ϵ�������֪��������Ϊm�Ļ��Ĵ���ʵҲ�ǳ���Ϊm-2�Ļ��Ĵ���
     * �ʶ�������ż�ԣ���ô�ͼ���Ƿ��г���Ϊ2����3�Ļ��Ĵ���
     * 1.��鳤��Ϊ2�Ļ��Ĵ���
     * �ж�s[i]!=s[i-1]
     * 2.��鳤��Ϊ3�Ļ��Ĵ���
     * �ж�s[i]!=s[i-1]
     * Ȼ������̰���㷨���ѳ�ʼ�������ַ�������Ϊһ��k�����������������1
     *
     * @param S ��ʼ�������ַ���
     * @param k ǰk��Ӣ����ĸ
     * @return ����Ҫ��������ַ���
     */
    public String smallestBeautifulString(String S, int k) {
        k += 'a';
        char[] s = S.toCharArray();
        int n = s.length;
        //�����һ����ĸ��ʼ
        int i = n - 1;
        //��̰�ģ������ұߵ���ĸ��һ
        s[i]++;
        while (i < n) {
            //����Ҫ��λ��ʱ��
            if (s[i] == k) {
                //���޷���λ��ʱ��
                if (i == 0) {
                    return "";
                }
                //��λ
                s[i] = 'a';
                s[--i]++;
            } else if (i > 0 && s[i] == s[i - 1] || i > 1 && s[i] == s[i - 1]) {
                s[i]++;
            } else {
                i++;
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestBeautifulString("abcz",26));
    }
}
