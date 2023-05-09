package org.frank.basic.assignment;
/*
        赋值运算符:
            基本: =
            复合: +=, -=, *=, /=, %=, ...
 */
public class OperatorDemo {
    public static void main(String[] args) {
        System.out.println("把10赋值给int类型的变量a");
        int a = 10;
        System.out.println(a);

        System.out.println("先把10赋值给int类型的变量b，再将b的值加上20，最后赋值给b");
        int b = 10;
        b += 20;    // 等价于 b = b + 20;
        System.out.println(b);
    }
}
