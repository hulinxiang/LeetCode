package Array.Question58;

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int right = s.length();
        int left = s.lastIndexOf(' ');
        if (left == -1) {
            return right;
        }
        return right - left-1;
    }
}
