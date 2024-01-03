package Question151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        //去除调字符串s头部和尾部的空格
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
