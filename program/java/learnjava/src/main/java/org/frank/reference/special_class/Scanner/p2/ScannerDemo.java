package org.frank.reference.special_class.Scanner.p2;
/*
    Scanner成员方法：
        1. hasNextXxx(): 判断下一个输入项是不是指定的数据类型。
        2. nextXxx(): 获取该类型的数据。
 */
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");

        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            System.out.println(number);
        } else {
            System.out.println("输入有误！");
        }

        System.out.println("over");
    }
}
