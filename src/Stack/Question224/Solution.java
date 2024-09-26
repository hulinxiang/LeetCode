package Stack.Question224;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (Character.isDigit(cur)) {
                num = num * 10 + (cur - '0');
            } else if (cur == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (cur == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (cur == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (cur == ')') {
                result += sign * num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }

        if (num != 0) {
            result += sign * num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution calculator = new Solution();
        String s1 = "1 + 1";
        String s2 = "2 - 1 + 2";
        String s3 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println("Result of '" + s3 + "' = " + calculator.calculate(s3)); // Êä³ö 23
    }
}
