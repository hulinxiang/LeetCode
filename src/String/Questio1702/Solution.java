package String.Questio1702;


public class Solution {
    //Note that with the operations, you can always make the string only contain at most 1 zero.
    //模拟 + 贪心
    public String maximumBinaryString(String binary) {
        int len = binary.length();
        char[] s = binary.toCharArray();
        int secondIndex = 0;
        for (int i = 0; i < len; i++) {
            //出现了第一个0
            if (s[i] == '0') {
                int firstIndex = i;
                while (secondIndex <= firstIndex || (secondIndex < len && s[secondIndex] == '1')) {
                    secondIndex++;
                }
                //出现了第二个0
                if (secondIndex < len) {
                    s[firstIndex] = '1';
                    s[secondIndex] = '1';
                    s[firstIndex + 1] = '0';
                }

            }
        }
        return new String(s);
    }


    public static void main(String[] args) {
        String binary = new String("000110");
        System.out.println(new Solution().maximumBinaryString(binary));
    }
}
