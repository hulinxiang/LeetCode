package String.Question2810;

public class Solution {
    public String finalString(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i') {
                ans.append(s.charAt(i));
            } else {
                ans = reverse(ans);
            }
        }
        return ans.toString();
    }

    public StringBuilder reverse(StringBuilder stringBuilder) {
        StringBuilder ans = new StringBuilder();
        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            ans.append(stringBuilder.charAt(i));
        }
        return ans;
    }
}
