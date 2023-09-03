package org.frank.reference.special_class.StringBuffer.test;
/*
    判断一个字符串是否是对称字符串
        例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串

    其实就是将字符穿反转后，在比较两个字符串内容是否相等
 */
public class StringBufferTest3 {
    public static void main(String[] args) {
        String s = "mnanm";

        boolean b1 = ifSymmetry1(s);
        System.out.println(b1);

        boolean b2 = ifSymmetry2(s);
        System.out.println(b2);

        boolean b3 = ifSymmetry3(s);
        System.out.println(b3);
    }
    public static boolean ifSymmetry1(String str) {
        // 将str转换成数组，反向遍历数组，组成新的字符串，将其与原始字符串比较
        String newstr = "";
        char[] chars = str.toCharArray();
        for(int i = chars.length - 1; i >= 0; i--) {
            newstr += chars[i];
        }
        if (str.equals(newstr)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ifSymmetry2(String str) {
        // 将str转换成数组
        // 遍历数组，首尾比较
        char[] chars = str.toCharArray();
        for(int start = 0, end = chars.length - 1; start <= end; start++, end--) {
            if (chars[start] != chars[end]) {
                return false;
            }
        }
        return true;
    }

    public static boolean ifSymmetry3(String str) {
        // 创建StringBuffer对象sb，使用str初始化sb
        // 调用sb reverse函数，再将其转换成String
        // 比较转换前后的字符串是否相等
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        String newstr = new String(sb);
        if(str.equals(newstr)) {
            return true;
        } else {
            return false;
        }
    }
}
