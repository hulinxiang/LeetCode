package DoublePointer.Question392;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            if (!queue.isEmpty() && t.charAt(j) == queue.peek()) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
