package Question2748;
public class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            while (first >= 10) {
                first /= 10;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j] % 10;
                if (gcd(first,second) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }


    //����a,b�����������Լ��
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().countBeautifulPairs(new int[]{31, 25, 72, 79, 74}));
    }
}
