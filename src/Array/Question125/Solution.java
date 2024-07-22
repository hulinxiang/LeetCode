package Array.Question125;

public class Solution {
    public boolean isPalindrome(String s){
        StringBuilder stringBuilder=new StringBuilder();
        char[] chars=s.toCharArray();
        for (char c:chars){
            if (Character.isLetter(c)){
                if (Character.isLowerCase(c)){
                    stringBuilder.append(c);
                }else {
                    stringBuilder.append(Character.toLowerCase(c));
                }
            }
            if (Character.isDigit(c)){
                stringBuilder.append(c);
            }
        }
        return ifPalindrome(stringBuilder.toString());

    }


    public boolean ifPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if (s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;

    }


}
