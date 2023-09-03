package org.frank.reference.special_class.StringBuffer.test;
/*
    把字符串反转
    1. 将字符串对象转换成StringBuffer对象
    2. 使用StringBuffer reverse函数实现反转
    3. 将StringBuffer对象转换成字符串对象
 */
public class StringBufferTest2 {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = reverse1(s);
        String s2 = reverse2(s);
        String s3 = reverse3(s);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
    }

    public static String reverse1(String str) {
        // 将字符串转成数组，反向遍历数组
        String s = "";
        char[] chars = str.toCharArray();

        for(int x = chars.length - 1; x >= 0; x--) {
            s += chars[x];
        }
        return s;
    }

    public static String reverse2(String str) {
        // 将字符串转成数组，反转数组元素
        char[] chars = str.toCharArray();
        for(int start = 0, end = chars.length - 1; start <= end; start++, end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
        return String.valueOf(chars);
    }

    public static String reverse3(String str) {
        // 创建StringBuffer对象，调用reverse函数实现反转
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return new String(sb);
    }
}
