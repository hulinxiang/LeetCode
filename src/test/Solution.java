package test;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {

    public String getReversedString(String s) {
        LinkedList<String> list = new LinkedList<>();
        char[] allChars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = allChars[i];
            if (Character.isLetter(cur)) {
                list.push(String.valueOf(cur));
            } else if (cur == '(') {
                list.push(String.valueOf(cur));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (!"(".equals(list.peek())){
                    stringBuilder.append(list.pop());
                }
                list.pop();
                char[] toPushed=stringBuilder.toString().toCharArray();
                for (char c:toPushed){
                    list.push(String.valueOf(c));
                }

            }
        }
        StringBuilder ans=new StringBuilder();
        while (!list.isEmpty()){
            ans.append(list.pop());
        }
        String stringToReversed=ans.toString();
        char[] chars=stringToReversed.toCharArray();
        StringBuilder ret=new StringBuilder();
        for (int i=chars.length-1;i>=0;i--){
            ret.append(chars[i]);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getReversedString("a(bcdefghijkl(mno)p)q"));
    }
}
