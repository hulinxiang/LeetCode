package DoublePointer.Question522;

class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        l1:
        for (int i = 0; i < strs.length; i++) {
            //说明当前长度对ans不产生影响
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
     * 判断s是否为t的子序列
     *
     * @param s 字符串S
     * @param t 字符串t
     * @return true 如果是, false 如果不是
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
