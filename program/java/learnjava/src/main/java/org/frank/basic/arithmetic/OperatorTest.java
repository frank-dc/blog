package org.frank.basic.arithmetic;
/*
        回顾
        ++/--
            位于操作数前面，先自增自减，再参与操作
            位于操作数后面，先参与操作，再自增自减
 */

public class OperatorTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = 10;

        a = b++;
        c = --a;
        b = ++a;
        a = c--;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        int x = 4;
        int y = (x++) + (++x) + (x * 10);
//                4   +   6   + 6 * 10
        System.out.println("x = " + x);     // 6
        System.out.println("y = " + y);     // 70
    }
}
