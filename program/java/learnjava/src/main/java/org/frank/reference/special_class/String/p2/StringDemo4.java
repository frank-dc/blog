package org.frank.reference.special_class.String.p2;
/*
    字符串变量相加：先分配内存地址，再加内容。
    字符串字面量相加：先加，再去`字符串池`中找，有则引用，没有再分配内存空间。
 */
public class StringDemo4 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = s1 + s2;
        String s5 = "hello" + "world";

        System.out.println(s4);
        System.out.println(s5);

        System.out.println(s3 == s1 + s2);              // false
        System.out.println(s3 == "hello" + "world");    // true
        System.out.println(s3.equals(s1 + s2));         // true
        System.out.println(s3 == s4);   // false
        System.out.println(s3 == s5);   // true
    }
}
