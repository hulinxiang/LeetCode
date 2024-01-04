package Question151;

/**
 * @author 胡霖翔
 * 双指针：运用从后往前的思想
 */
public class Solution1 {
    public String reverseWords(String s) {
        //去掉s前后的空格
        s = s.trim();
        StringBuilder ans = new StringBuilder();
        //倒着遍历
        int left, right;
        int mark = 0;
        //一开始right指向最后一个字母的位置
        right = s.length() - 1;
        //最后退出循环的时候就是i==0的时候，最后再把最后一个字母加上即可
        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            right = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            left = i;
            if (left < 0) {
                ans.append(" ").append(s, 0, right+1);
                break;
            }
            ans.append(" ").append(s, left+1, right+1);
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reverseWords(s) + "11111");
    }
}
