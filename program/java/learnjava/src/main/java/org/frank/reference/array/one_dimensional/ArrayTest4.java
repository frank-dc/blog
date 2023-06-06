package org.frank.reference.array.one_dimensional;

import java.util.Scanner;

/*
    通过索引，获取数组对应元素。
 */
public class ArrayTest4 {
    public static void main(String[] args) {
        // 定义一个数组
        String[] arr = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 键盘录入数据
        System.out.println("请输入一个数字（1 ~ 7）： ");
        int week = sc.nextInt();

        // 通过索引获取数组元素
        System.out.println("你想要得到的是： " + arr[week - 1]);
    }
}
