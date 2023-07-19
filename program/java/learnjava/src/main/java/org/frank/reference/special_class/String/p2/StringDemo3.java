package org.frank.reference.special_class.String.p2;
/*
    当你使用字符串字面量创建一个字符串时，Java会使用一个特殊的内存区域，称为"字符串池"（String Pool），
    来存储和管理这些字面量。字符串池是Java虚拟机（JVM）中的一个特定内存区域，用于存储唯一的字符串字面量。

    当代码遇到字符串字面量时，比如"hello"，JVM首先会检查字符串池中是否已经存在具有相同值的字符串。
    这里的值指的是字符串中的字符序列，比如"hello"。如果在池中找到具有相同值的字符串，Java不会创建
    新的字符串对象，而是返回对字符串池中现有字符串的引用。
    通过"字符串池化"或"字符串合并"，Java可以重用具有相同值的字符串对象，从而优化内存使用。

    需要注意的是，字符串池和字符串合并只适用于字符串字面量，并不适用于通过new关键字
    或字符串操作方法创建的字符串。
 */
public class StringDemo3 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);       // false
        System.out.println(s1.equals(s2));  // true

        String s3 = new String("hello");
        String s4 = "hello";
        System.out.println(s3 == s4);       // false
        System.out.println(s3.equals(s4));  // true

        String s5 = "hello";    // When using string literals, Java checks if the string with the same value already exists in the string pool. If it does, it reuses it; otherwise, it creates a new string in the pool.
        String s6 = "hello";
        System.out.println(s5 == s6);       // true
        System.out.println(s5.equals(s6));  // true

        System.out.println(s4 == s6);       // true
    }
}
