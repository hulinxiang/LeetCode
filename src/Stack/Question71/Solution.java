package Stack.Question71;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                deque.addLast(name);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (deque.isEmpty()) {
            stringBuilder.append('/');
        } else {
            while (!deque.isEmpty()) {
                stringBuilder.append('/').append(deque.removeFirst());
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String s = "/home";
        System.out.println(new Solution().simplifyPath(s));
    }
}
