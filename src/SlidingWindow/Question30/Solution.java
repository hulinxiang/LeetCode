package SlidingWindow.Question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return ans;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int windowLen = wordLen * numWords;
        int sLen = s.length();

        // 记录words中单词的频率
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            // 对于每个单词的偏移，我们都运行一次滑动窗口
            int left = i, right = i;
            HashMap<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordCount.containsKey(w)) {
                    seen.put(w, seen.getOrDefault(w, 0) + 1);
                    if (seen.get(w).equals(wordCount.get(w))) {
                        count++;
                    }
                }

                if (right - left == windowLen) {
                    if (count == wordCount.size()) {
                        ans.add(left);
                    }

                    String leftWord = s.substring(left, left + wordLen);
                    left += wordLen;
                    if (seen.containsKey(leftWord)) {
                        if (seen.get(leftWord).equals(wordCount.get(leftWord))) {
                            count--;
                        }
                        seen.put(leftWord, seen.get(leftWord) - 1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        System.out.println(new Solution().findSubstring(s, words));  // 输出: [6, 9, 12]
    }
}
