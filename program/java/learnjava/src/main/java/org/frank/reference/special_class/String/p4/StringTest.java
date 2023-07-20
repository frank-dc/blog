package org.frank.reference.special_class.String.p4;
/*
    字符串遍历：遍历获取字符串中的每一个字符。
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "helloworld";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
}
