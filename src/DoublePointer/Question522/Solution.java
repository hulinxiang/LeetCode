package DoublePointer.Question522;

class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        l1:
        for (int i = 0; i < strs.length; i++) {
            //˵����ǰ���ȶ�ans������Ӱ��
            if (strs[i].length() <= ans) {
                continue;
            }
            for (int j = 0; j < strs.length; j++) {
                if (j != i && isSubseq(strs[i], strs[j])) {
                    continue l1;
                }
            }
            ans = strs[i].length();
        }
        return ans;
    }

    /**
     * �ж�s�Ƿ�Ϊt��������
     *
     * @param s �ַ���S
     * @param t �ַ���t
     * @return true �����, false �������
     */
    private boolean isSubseq(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(i) && ++i == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }

}
