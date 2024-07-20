package Array.Question28;

/**
 * KMP�㷨ƥ��
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            // ���needleΪ���ַ���������0
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();
        int[] next = buildNext(needle);
        // haystackָ��
        int i = 0;
        // needleָ��
        int j = 0;

        while (i < n) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == m) {
                return i - m;
            }

        }
        // δ�ҵ�ƥ���ģʽ��
        return -1;
    }

    public static int[] buildNext(String pattern) {
        int m = pattern.length();
        int[] ret = new int[m];
        ret[0] = -1;
        int j = 0;
        int k = -1;
        while (j < m - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;
                ret[j] = k;
            } else {
                k = ret[k];
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().strStr("ABCABC", "ABABCABAA"));
    }
}
