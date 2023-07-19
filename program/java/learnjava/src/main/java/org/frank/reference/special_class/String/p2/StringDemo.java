package org.frank.reference.special_class.String.p2;
/*
    字符串是常量，它的值在创建后不能更改。
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "Hello";

        s += " world";
        System.out.println(s);
    }
}
