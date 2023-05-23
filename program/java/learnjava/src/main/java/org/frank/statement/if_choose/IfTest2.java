package org.frank.statement.if_choose;

import java.util.Scanner;

/*
    需求：获取三个数据中的最大值
 */
public class IfTest2 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 键盘录入数据
        System.out.println("请输入第一个数据：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数据：");
        int b = sc.nextInt();
        System.out.println("请输入第三个数据：");
        int c = sc.nextInt();

        // 使用三元运算符实现
        int temp = a > b ? a : b;
        int max = (temp > c) ? temp : c;
        System.out.println("最大值是：" + max);

        // 使用if语句实现
        int max2;
        if(a > b) {
            if( a > c) {
                max2 = a;
            }else {
                max2 = c;
            }
        }else {
            if(b > c) {
                max2 = b;
            }else {
                max2 = c;
            }
        }
        System.out.println("最大值是：" + max2);
    }
}
