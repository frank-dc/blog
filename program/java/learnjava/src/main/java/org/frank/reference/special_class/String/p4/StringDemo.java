package org.frank.reference.special_class.String.p4;
/*
    String类的获取功能：
        int length(): 返回字符串的长度。字符的个数。
        char charAt(int index): 返回字符串中指定位置的字符。
        int indexOf(int ch): 返回指定字符在字符串中第一次出现的位置
        int indexOf(String str): 返回指定字符串在字符串中第一次出现的位置
        int indexOf(int ch,int fromIndex): 返回指定字符从指定位置开始在字符串中第一次出现的位置
        int indexOf(String str,int fromIndex): 返回指定字符串从指定位置开始在字符串中第一次出现的位置
        String substring(int start): 返回从指定位置开始到末尾的子串
        String substring(int start,int end): 返回从指定位置开始到指定位置结束的子串----注意左包右不包
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "helloworld";

        System.out.println(s.length());         // 10
        System.out.println(s.charAt(5));        // w

        System.out.println(s.indexOf('o'));     // 4
        System.out.println(s.indexOf("wo"));    // 5
        System.out.println(s.indexOf('o', 5));  // 6
        System.out.println(s.indexOf("el", 2)); // -1

        System.out.println(s.substring(5));     // world
        System.out.println(s.substring(3,7));           // lowo
    }
}
