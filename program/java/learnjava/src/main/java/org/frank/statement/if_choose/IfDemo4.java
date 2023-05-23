package org.frank.statement.if_choose;
/*
    if 语句格式2和三元运算符的区别：
        三元运算符：
            关系表达式?表达式1:表达式2

        if 语句格式2：
            if(关系表达式) {
                语句体1;
            }else {
                语句体2;
            }
    区别：
        三元运算符能够实现的，使用 if 语句格式2都可以实现。反之则不成立。
		什么时候不成立呢?
			当if语句的语句体是一条输出语句时，就不成立。
		原因： 因为三元运算符是一个运算符，要求有结果返回，而输出语句不能作为一个结果返回。
 */

import java.util.Scanner;

public class IfDemo4 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        //获取键盘录入数据
        System.out.println("请输入第一个数据：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数据：");
        int b = sc.nextInt();

        //使用三元运算符实现
        int c =  (a > b) ? a : b;
        System.out.println("使用三元运算符获取较大的数值是："+c);

        //使用if语句格式2实现
        int d;
        if(a > b) {
            d = a;
        }else {
            d = b;
        }
        System.out.println("使用if语句格式2获取较大的数值是："+d);

        // 使用 if 语句格式2可以，三元运算符不可以
        if(a > b) {
            System.out.println("a大于b");
        }else {
            System.out.println("a小于等于b");
        }

        // (a>b) ? System.out.println("a:"+a):System.out.println("b:"+b);
        String msg = (a > b) ? "a大于b" : "a小于等于b";
        System.out.println(msg);
    }
}
