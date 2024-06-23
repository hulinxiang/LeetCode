package GreedyAlgorithm.Question2663;

public class Solution {
    /**
     * 因为美丽字符串不包括回文串，所以由逆否关系命题可以知道，长度为m的回文串其实也是长度为m-2的回文串。
     * 故而根据奇偶性，那么就检查是否有长度为2或者3的回文串。
     * 1.检查长度为2的回文串：
     * 判断s[i]!=s[i-1]
     * 2.检查长度为3的回文串：
     * 判断s[i]!=s[i-1]
     * 然后运用贪心算法，把初始的美丽字符串看作为一个k进制数，从右往左加1
     *
     * @param S 初始的美丽字符串
     * @param k 前k个英文字母
     * @return 符合要求的美丽字符串
     */
    public String smallestBeautifulString(String S, int k) {
        k += 'a';
        char[] s = S.toCharArray();
        int n = s.length;
        //从最后一个字母开始
        int i = n - 1;
        //先贪心，把最右边的字母加一
        s[i]++;
        while (i < n) {
            //当需要进位的时候
            if (s[i] == k) {
                //当无法进位的时候
                if (i == 0) {
                    return "";
                }
                //进位
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
