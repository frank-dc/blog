package org.frank.basic.keyboard_input;

import java.util.Scanner;

public class InputDemo {
    public static void main(String[] agrs) {
        // 创建键盘录入对象，System.in作为输入源，即从标准输入读取用户的输入
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        // 读取用户输入的整数
        int i = sc.nextInt();
        System.out.println("你输入的整数是：" + i);

        System.out.println("请输入一个字符串：");
        // 读取用户输入的字符串
        String s = sc.next();
        System.out.println("你输入的字符串是：" + s);

        // 关闭 Scanner 对象，释放资源
        sc.close();
    }
}
