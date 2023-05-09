package org.frank.basic.comparison;
/*
        关系运算符
            ==, !=, >, >=, <, <=
 */

public class OperatorDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        int c = 12;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println((a + b * c) == (a * b + c) );

        System.out.println(a = b);  // 把b的值赋给a，把a的值作为结果留下来
        System.out.println(a = c);
    }
}
