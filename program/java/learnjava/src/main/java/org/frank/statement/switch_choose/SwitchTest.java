package org.frank.statement.switch_choose;

import java.util.Scanner;

/*
    if 语句和 switch 语句使用场景区别
        if 语句：
            1. 针对结果是 boolean 类型的判断
            2. 针对一个范围的判断
            3. 针对几个常量值的判断
        switch 语句：
            1. 针对几个常量值的判断
 */
public class SwitchTest {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 键盘录入数据
        System.out.println("请输入一个数据：");
        int month = sc.nextInt();

        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("输入的数据有误");
        }
    }
}
