package org.frank.basic.arithmetic;
/*
    运算：对常量或变量进行操作的过程。
    运算符：对常量或变量进行操作的符号。
    表达式：由运算符把常量或变量连接起来的式子。
        a + b
        注意：表达式必须有结果

    常见的运算符：
        算术运算符   +, -, *, /, %, ++, --
        赋值运算符   =
        比较运算符   >, <, ==, >=, <=
        逻辑运算符   ||，&&，!
        位运算符     &, |, ^, ~, >>, <<
        三目运算符   condition ? expression1 : expression2

 */

public class OperatorDemo {
    public static void main(String[] args) {
        System.out.println("\n10 + 20");
        System.out.println(10 + 20);
        System.out.println("\n10 - 20");
        System.out.println(10 - 20);
        System.out.println("\n10 * 20");
        System.out.println(10 * 20);
        System.out.println("\n10 / 20 整数相除只能得到整数");
        System.out.println(10 / 20);
        System.out.println("\n10 / 20.0 可以得到小数");
        System.out.println(10 / 20.0);

        System.out.println("\n加号的用法：正号、加法、字符串拼接");
        System.out.println("正号 +5");
        System.out.println(+5);
        System.out.println("加法 1 + 2");
        System.out.println(1 + 2);
        System.out.println("字符串拼接 \"1\" + \"2\"，可以参考DataTypeDemo3.java");
        System.out.println("1" + "2");
    }
}
