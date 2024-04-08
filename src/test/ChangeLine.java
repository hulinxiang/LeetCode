package test;

public class ChangeLine {
    public static void main(String[] args) {
        String s = "abcdefg\nabc\ndef";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                System.out.println(i);
            }
        }
        System.out.println(s);
    }

}
