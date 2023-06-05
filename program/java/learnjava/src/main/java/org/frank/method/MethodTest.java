package org.frank.method;
/*
    需求：键盘录入两个数据，返回两个数中的较大值

    分析：
        1. 键盘录入两个数据，用 Scanner 实现
        2. 写一个方法实现，返回两个数中的较大值
        3. 调用方法
        4. 输出结果
 */

import java.util.Scanner;

public class MethodTest {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 键盘录入数据
        System.out.println("请输入第一个数据：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数据：");
        int b = sc.nextInt();

        // 调用函数
        int c = getLarger(a, b);

        // 输出结果
        System.out.println("两个数据中的较大值是：" + c);
    }

    public static int getLarger(int a, int b) {
        return a > b ? a : b;
    }
}
