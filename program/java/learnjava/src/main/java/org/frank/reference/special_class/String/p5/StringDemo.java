package org.frank.reference.special_class.String.p5;
/*
    String类的转换功能：
        byte[] getBytes(): 把字符串转换成字节数组
        char[] toCharArray(): 把字符串转换为字符数组
        static String valueOf(char[] chs): 把字符数组转换成字符串
        static String valueOf(int i): 把int类型的数据转换成字符串
        String toLowerCase(): 把字符串转小写
        String toUpperCase(): 把字符串转大写
        String concat(String str): 字符串拼接
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "abcde";

        // byte[] getBytes(): 把字符串转换成字节数组
        byte[] b = s.getBytes();
        for(int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        // char[] toCharArray(): 把字符串转换为字符数组
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

        // static String valueOf(char[] chs): 把字符数组转换成字符串
        String s2 = String.valueOf(c);
        System.out.println(s2);

        // static String valueOf(int i): 把int类型的数据转换成字符串
        int number = 100;
        String s3 = String.valueOf(number);
        System.out.println(s3);

        // String toLowerCase(): 把字符串转小写
        String s_upper = s.toUpperCase();
        System.out.println(s_upper);
        // String toUpperCase(): 把字符串转大写
        System.out.println(s_upper.toLowerCase());

        // String concat(String str): 字符串拼接
        System.out.println(s.concat(" helloworld"));
    }
}