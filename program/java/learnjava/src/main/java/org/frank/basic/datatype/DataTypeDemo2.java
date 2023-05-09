package org.frank.basic.datatype;
/*
    使用变量的注意事项：
        A: 作用域
            变量定义在哪一级大括号中，哪个大括号的范围就是这个变量的作用域
            相同的作用域中不能定义两个相同的变量
        B: 初始化值
            没有初始化值不能直接使用
        C: 定义变量的问题
            在一行上只定义一个变量，可以定义多个，但不建议
 */

public class DataTypeDemo2 {
    int i = 100;
    public static void main(String[] args) {
        int i = 200;
        System.out.println("i = " + i);

        int j;
//        System.out.println("j = " + j);    错误：未初始化不能直接使用
        j = 300;
        System.out.println("j = " + j);
    }
}
