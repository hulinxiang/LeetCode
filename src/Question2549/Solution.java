package Question2549;

import java.util.Stack;

/**
 * @author Hu
 */
public class Solution {
    private int[] arr = new int[101];
    private Stack<Integer> stacks = new Stack<Integer>();

    //���ڳ����������ϵ�ÿ������ x ���ҳ����� 1 <= i <= n ������ x % i == 1 ���������� i ��
    public int distinctIntegers(int n) {
        int ans = 1;
        stacks.push(n);
        arr[n] = 1;
        while (!stacks.isEmpty()) {
            int x = stacks.pop();
            for (int i = 1; i <= n; i++) {
                if (x % i == 1 && arr[i] != 1) {
                    arr[i] = 1;
                    stacks.push(i);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().distinctIntegers(5));
    }
}
