package SlidingWindow.Question438;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenp = p.length();
        int lens = s.length();
        List<Integer> list = new ArrayList<>();
        if (lens < lenp) {
            return list;
        }
        int dif = 0;
        int[] count = new int[26];
        for (int i = 0; i < lenp; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        for (int j : count) {
            if (j != 0) {
                dif++;
            }
        }
        if (dif == 0) {
            list.add(0);
        }
        for (int i = 1; i <= lens - lenp; i++) {
            count[s.charAt(i - 1) - 'a']--;
            if (count[s.charAt(i - 1) - 'a'] == 0) {
                dif--;
            }
            if (count[s.charAt(i - 1) - 'a'] == -1) {
                dif++;
            }
            count[s.charAt(i + lenp - 1) - 'a']++;
            if (count[s.charAt(i + lenp - 1) - 'a'] == 0) {
                dif--;
            }

            if (count[s.charAt(i + lenp - 1) - 'a'] == 1) {
                dif++;
            }
            if (dif == 0) {
                list.add(i);
            }
        }
        return list;
    }
}