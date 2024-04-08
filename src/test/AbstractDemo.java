package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* ÎÄ¼þÃû : AbstractDemo.java */
public class AbstractDemo {
    public static void main(String[] args) {
        String[] s1 = new String[2];
        s1[0] = "a";
        s1[1] = "b";
        String[] s2 = new String[2];
        s2[0] = "a";
        s2[1] = "b";
        String[] s3 = s1;
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }
}