package Graph.Question127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        // 如果最后的目标字符串不在合理的字符串集里面，直接return 0
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int steps = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;
                        String newWord = new String(chars);

                        if (endSet.contains(newWord)) {
                            return steps + 1;
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextLevel.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[i] = old;
                }
            }

            beginSet = nextLevel;
            steps++;
        }

        return 0;
    }
}
