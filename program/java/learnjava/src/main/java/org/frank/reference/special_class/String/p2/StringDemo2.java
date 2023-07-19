package org.frank.reference.special_class.String.p2;
/*
    String s = new String("hello"); 和 String s = "hello"; 的区别？
        其实后者创建对象就是调用构造方法public String(String original)实现的，等同于
        new String("hello")

    ==: 比较引用类型，比较的是地址值（即内存地址）
    equals: 默认比较的是地址值。String类重写了equals()方法，该方法的作用是比较字符串的内容是否相同。
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = "hello";

        System.out.println(s1 == s2);       // false
        System.out.println(s1.equals(s2));  // true
    }
}
