package org.frank.reference.special_class.StringBuffer.compare;
/*
    1. String、StringBuffer、StringBuilder的区别？
        String长度固定，StringBuffer、StringBuilder的长度可变
        StringBuffer线程安全，效率低；StringBuilder线程不安全，效率高。

    2. StringBuffer和数组的区别？
        StringBuffer的长度可变，可以存储任意的数据类型，最终结果其实是一个字符串。
        数组长度固定，存储同一种数据类型的元素。

    3. String作为参数传递是一种值传递。即引用参数的值改变，实际参数的值不改变。不可变的
       StringBuffer作为参数传递是一种引用传递。即引用参数的值改变，实际参数的值也改变。可变的
 */
public class demo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        change(s1, s2);
        System.out.println("---------------------");

        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("world");
        change(sb1, sb2);
    }

    public static void change(String s1, String s2) {
        System.out.println(s1 + "---" + s2);
        s1 = s2;    // 创建了一个新的字符串对象s1
        s2 = s1 + s2;   // 也是创建了一个新的字符串对象s2
        System.out.println(s1 + "---" + s2);
    }

    public static void change(StringBuffer sb1, StringBuffer sb2) {
        System.out.println(sb1 + "---" + sb2);
        sb1 = sb2;
        sb2 = sb1.append(sb2);
        System.out.println(sb1 + "---" + sb2);
    }
}
