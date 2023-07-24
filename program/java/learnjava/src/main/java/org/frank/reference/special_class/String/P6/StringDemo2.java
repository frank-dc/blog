package org.frank.reference.special_class.String.P6;
/*
    public String trim()： 去除字符串两头空格。
    public int compareTo(String anotherString): 比较两个字符串，从第一个不同的字符开始比较
    public int compareToIgnoreCase(String str): 比较两个字符串，从第一个不同的字符开始比较（不区分大小写）
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String s = "   Hello  world  ";

        // public String trim()： 去除字符串两头空格。
        String ns = s.trim();

        System.out.println("s = " + s);
        System.out.println("ns = " + ns);

        String s2 = "hello";
        System.out.println(s2.compareTo("hello"));  // 0
        System.out.println(s2.compareTo("agaaaa")); // 7     h: 104; a: 97

        System.out.println(s2.compareToIgnoreCase("Hello"));    // 0
        System.out.println(s2.compareToIgnoreCase("aaaaaa"));   // 7
    }
}
