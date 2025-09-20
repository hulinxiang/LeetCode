package SlidingWindow.Question3;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0; // ����ַ�������
        int left = 0;
        int len = s.length();

        for (int right = 0; right < len; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) { // ˵���Ѿ��������������ĸ
                left = Math.max(left, map.get(c) + 1);
            }
            max = Math.max(max, right - left + 1);
            map.put(c, right);
        }
        return max;
    }
}
