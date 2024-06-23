package String.Question520;

public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        char first = word.charAt(0);
        // 如果第一个字符是大写的
        if (Character.isUpperCase(first)) {
            return checkAllUpper(word) || checkAllLower(word.substring(1));
        } else {
            //第一个字符串为小写的
            return checkAllLower(word);
        }

    }


    /**
     * 判断字符串是否全部都是大写
     *
     * @param word 要判断的字符串
     * @return true 如果全是大写; false, 反之即为false
     */
    private boolean checkAllUpper(String word) {
        return word.toUpperCase().equals(word);
    }

    /**
     * 判断字符串是否全部都是小写
     *
     * @param word 要判断的字符串
     * @return true 如果全是小写; false, 反之即为false
     */
    private boolean checkAllLower(String word) {
        return word.toLowerCase().equals(word);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("USA"));
    }

}
