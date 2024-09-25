package Stack.Question150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if ("+".equals(str)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = a + b;
                stack.push(Integer.toString(c));
            } else if ("-".equals(str)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b - a;
                stack.push(Integer.toString(c));
            } else if ("/".equals(str)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b / a;
                stack.push(Integer.toString(c));
            } else if ("*".equals(str)) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b * a;
                stack.push(Integer.toString(c));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
