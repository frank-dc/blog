package org.frank.basic.constant;
/*
    常量：在程序执行的过程中其值不可以改变。
            举例：π

    分类：
        A:字面值常量
            1，12.5
        B:自定义常量（面向对象）

    字面值常量分类：
        a) 字符串常量，用双引号""括起来的内容
        b) 整数常量
        c) 小数常量
        d) 字符常量，用单引号''括起来的内容
        e) 布尔常量，只有两个值：true和false
        f) 空常量 null

 */
public class ConstantDemo {
    public static void main(String[] args) {
        // 字符串常量
        System.out.println("Hello world");

        // 整数常量
        System.out.println(100);

        // 小数常量
        System.out.println(1.25);

        // 字符常量
        System.out.println('A');
        System.out.println('1');
        //下面的是错误的
        // System.out.println('BC');

        // 布尔常量
        System.out.println(true);
        System.out.println(false);
    }
}
