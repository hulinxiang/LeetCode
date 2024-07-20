package Array.Question28;

/**
 * KMP算法匹配
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            // 如果needle为空字符串，返回0
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();
        int[] next = buildNext(needle);
        // haystack指针
        int i = 0;
        // needle指针
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
        // 未找到匹配的模式串
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
