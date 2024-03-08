package Question2834;

public class Solution {
    public int minimumPossibleSum(int n, int target) {
        final int mod = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % mod);
        } else {
            return (int) (((long) (1 + n) * n / 2 + ((long) target + target + n - m - 1) * (n - m) / 2) % mod);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumPossibleSum(2, 3));
    }
}
