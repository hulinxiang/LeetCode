package Question541;

/**
 * 更加优化的方法
 */
public class Solution1 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    /**
     * 将left到right之间的字符进行反转
     *
     * @param arr   将要反转的字符数组
     * @param left  开始位置
     * @param right 结束位置
     */
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char cur = arr[left];
            arr[left++] = arr[right];
            arr[right--] = cur;
        }

    }
}
