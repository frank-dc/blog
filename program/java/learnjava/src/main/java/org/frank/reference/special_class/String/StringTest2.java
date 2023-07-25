package org.frank.reference.special_class.String;

import java.util.Scanner;

/*
    需求：字符串反转
 */
public class StringTest2 {
    public static void main(String[] args) {
        // 创建Scanner对象，键盘录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();

        // 调用reverse方法，实现字符串反转
        String rs = reverse(s);
        System.out.println(rs);
    }

    public static String reverse(String s) {
        // 将字符串转换成字符数组
        char[] c = s.toCharArray();

        // 定义一个String变量，用于存储反转后的字符串
        String result = "";

        // 遍历字符数组
        for(int i = c.length - 1; i >= 0; i--) {
            result += c[i];
        }

        return result;
    }
}
