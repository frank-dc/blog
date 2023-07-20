package org.frank.reference.special_class.String.p3;
/*
    String类的判断功能：
        boolean equals(Object obj): 比较字符串的内容是否相同，严格区分大小写
        boolean equalsIgnoreCase(String str): 比较字符串的内容是否相同，不考虑大小写
        boolean contains(String str): 判断是否包含指定的小串
        boolean startsWith(String str): 判断是否以指定的字符串开头
        boolean endsWith(String str): 判断是否以指定的字符串结尾
        boolean isEmpty(): 判断字符串的内容是否为空
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "helloworld";

        // boolean equals(Object obj): 比较字符串的内容是否相同，区分大小写
        System.out.println(s.equals("helloworld"));     // true
        System.out.println(s.equals("HelloWorld"));     // false

        // boolean equalsIgnoreCase(String str): 比较字符串的内容是否相同，不考虑大小写
        System.out.println(s.equalsIgnoreCase("helloworld"));   // true
        System.out.println(s.equalsIgnoreCase("HelloWorld"));   // true

        // boolean contains(String str): 判断是否包含指定的子字符串
        System.out.println(s.contains("llo"));  // true
        System.out.println(s.contains("hw"));   // false

        // boolean startsWith(String str): 判断是否以指定的字符串开头
        System.out.println(s.startsWith("he"));     // true
        System.out.println(s.startsWith("owo"));    // false

        // boolean endsWith(String str): 判断是否以指定的字符串结尾
        System.out.println(s.endsWith("world"));    // true
        System.out.println(s.endsWith("owo"));      // false

        // boolean isEmpty(): 判断字符串是否为空
        System.out.println(s.isEmpty());    // false
        System.out.println("".isEmpty());   // true
    }
}
