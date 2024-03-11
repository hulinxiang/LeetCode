package Question2129;

/**
 * @author Hu
 * 'A'-'Z':65-90
 * 'a'-'z':97-122
 */
public class Solution {
    public String capitalizeTitle(String title) {
        String[] words = new String[title.length()];
        int cnt = 0;
        int i = 0;
        int j = 0;
        while (j < title.length()) {
            if (title.charAt(j) != ' ') {
                j++;
            } else {
                words[cnt++] = title.substring(i, j);
                j++;
                i = j;
            }
        }
        words[cnt] = title.substring(i, j);
        for (int k = 0; k <= cnt; k++) {
            String s = words[k];
            s = s.toLowerCase();
            if (s.length() <= 2) {
                words[k]=s;
                continue;
            }
            if (s.charAt(0) - 'Z' > 0) {
                s = (char)(s.charAt(0) - 32) + s.substring(1);
                words[k]=s;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k <= cnt; k++) {
            stringBuilder.append(words[k]).append(" ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }


    public static void main(String[] args) {
        String s = "First leTTeR of EACH Word";
        System.out.println(new Solution().capitalizeTitle(s));
    }
}
