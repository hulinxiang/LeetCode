package TraceBack.Question17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    private final String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char[] chars = digits.toCharArray();
        int[] digitsMap = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digitsMap[i] = chars[i] - '0';
        }
        dfs(0, digitsMap, res, new StringBuilder());
        return res;
    }

    public void dfs(int index, int[] digits, List<String> res, StringBuilder sb) {
        if (index == digits.length) {
            res.add(sb.toString());
            return;
        }
        int digit = digits[index];
        String letters = mappings[digit];
        char[] chars = letters.toCharArray();
        for (char c : chars) {
            sb.append(c);
            dfs(index + 1, digits, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}