package test;

public class split {

    public void test(String s){
        System.out.println(s.indexOf("Hello"));
    }

    public static void main(String[] args) {
        new split().test(" Hello World");
    }

}
