package org.frank.reference.lei_class.class_math;

import java.util.Scanner;

/*
    需求：猜数字小游戏

    分析：
        1. 系统给出一个随机数 A
            int number = (int)(Math.random() * 100) + 1;
        2. 用户输入一个随机数 B
            用 Scanner 实现
        3. 比较两个数
            B > A: 提示大了
            B < A: 提示小了
            B = A: 猜对了
        4. 使用循环，直到猜对，比给出猜的次数

    Math.random() 该值大于等于 0.0 且 小于 1.0
 */
public class GuessNumberDemo {
    public static void main(String[] args) {
        // 系统给出一个随机数
        int number = (int)(Math.random() * 100) + 1;

        // 统计猜的次数
        int count = 1;

        while(true) {
            // 创建Scanner对象
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个数字(1 - 100): ");
            int guessNumber = sc.nextInt();
            count++;

            // 比较大小
            if(guessNumber > number) {
                System.out.println("你猜的数字 " + guessNumber + " 大了");
            } else if(guessNumber < number) {
                System.out.println("你猜的数字 " + guessNumber + " 小了");
            } else {
                System.out.println("恭喜你猜对了，数字是：" + number);
                System.out.println("你一共猜了 " + count + " 次\n欢迎再来玩！");
                break;
            }
        }
    }
}
