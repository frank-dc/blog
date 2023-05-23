package org.frank.statement.if_choose;

import java.util.Scanner;

/*
    需求：键盘录入月份的值，输出对应的季节。
        春：3 4 5
        夏：6 7 8
        秋：9 10 11
        冬：12 1 2
 */
public class IfTest {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 键盘录入分月
        System.out.println("请输入月份：");
        int month = sc.nextInt();

        if(month < 1 || month > 12) {
            System.out.println("输入的月份有误");
        }else if(month >= 3 && month <= 5) {
            System.out.println("春季");
        }else if(month >= 6 && month <= 8) {
            System.out.println("夏季");
        }else if(month >= 9 && month <= 11) {
            System.out.println("秋季");
        }else {
            System.out.println("冬季");
        }
    }
}
