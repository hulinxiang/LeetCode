package Question2864;

public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int tot = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                tot++;
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append("1".repeat(Math.max(0, tot - 1)));
        ans.append("0".repeat(Math.max(0, s.length() - ans.length() - 1)));
        ans.append('1');
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "010";
        Solution solution = new Solution();
        System.out.println(solution.maximumOddBinaryNumber(s));
    }
}
