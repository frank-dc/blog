package org.frank.statement.switch_choose;

import java.util.Scanner;

/*
    switch 语句格式：
        switch(表达式) {
            case 值1:
                语句体1;
                break;
            case 值2:
                语句体2;
                break;
            case 值n:
                语句体n;
                break;
            default:
                语句体n+1;
                break;
        }

    格式解释：
        1. 表达式的取值：
            byte,short,int,char
            JDK5以后可以是枚举类型（enum）
            JDK7以后可以字符串（String）
        2. case 后面的值是要和 表达式 比较，匹配的执行相应的语句体
        3. 语句体可以是多条语句
        4. break 表示结束，可以结束 switch 语句
        5. default 语句表示所有 case 都不匹配的时候，就执行该处的语句，和 if 语句的 else 相似

    需求：根据键盘录入的数值1，2，3，…7输出对应的星期一，星期二，星期三…星期日。
		分析：
			A:键盘录入数据，用Scanner实现
			B:对录入的数据进行判断，用switch实现
			C:输出对应的结果
 */
public class SwitchDemo {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 键盘录入数据
        System.out.println("请输入一个数据(1-7): ");
        int week = sc.nextInt();

        // 使用 switch 语句实现
        switch (week) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("输入的数据不正确");
                break;
        }
    }
}
