package org.frank.basic.comparison;
/*
    逻辑与：都为true，结果才是true。
    && 和 & 的区别？
        && 运算符执行短路逻辑，即如果第一个操作数的值为 false，则不会执行第二个操作数。
        & 运算符不执行短路逻辑，即无论第一个操作数的值是什么，都会执行第二个操作数。
    综上所述，&& 运算符和 & 运算符的区别在于它们执行短路逻辑的方式不同。
    通常情况下，使用 && 运算符的情况更为常见，因为它可以提高程序的效率。


    逻辑或：只要有一个是true，结果都是true。
    || 和 | 的区别？
        || 运算符执行短路逻辑，即如果第一个操作数的值为 true，则不会执行第二个操作数。
        | 运算符不执行短路逻辑，即无论第一个操作数的值是什么，都会执行第二个操作数。
    综上所述，|| 运算符和 | 运算符的区别在于它们执行短路逻辑的方式不同。
    通常情况下，使用 || 运算符的情况更为常见，因为它可以提高程序的效率。

 */

public class OperatorDemo2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println("& 不管第一个操作数的值是false还是true，都会继续第二个操作数的判断。");
        System.out.println(a > b & a > c);  // false & false = false
        System.out.println(a > b & a < c);  // false & true = false
        System.out.println(a < b & a > c);  // true & false = false
        System.out.println(a < b & a < c);  // true & true = true


        System.out.println("&& 第一个操作数的值是true时，才会进行第二个操作数的判断。");
        System.out.println("&& 第一个操作数的值是false时，直接返回false，不再对第二个操作进行判断");
        System.out.println(a > b && a > c); // false && (false) = false 其实第二个判断不会执行
        System.out.println(a > b && a < c); // false && (true) = false  同样，第二个判断不会执行
        System.out.println(a < b && a > c); // true && false = false    第二个判断会执行
        System.out.println(a < b && a < c); // true && true = true

        System.out.println("| 不管第一个操作数的值是false还是true，都会继续第二个操作数的判断。");
        System.out.println(a > b | a > c);  // false | false = false
        System.out.println(a > b | a < c);  // false | true = true
        System.out.println(a < b | a > c);  // true | false = true
        System.out.println(a < b | a < c);  // true | true = true

        System.out.println("|| 第一个操作数的值是false时，才会进行第二个操作数的判断。");
        System.out.println("|| 第一个操作数的值是true时，直接返回true，不再对第二个操作数进行判断。");
        System.out.println(a > b || a > c); // false || false = false
        System.out.println(a > b || a < c); // false || true = true
        System.out.println(a < b || a > c); // true || (false) = true
        System.out.println(a < b || a < c); // true || (true) = true

        int x = 3;
        int y = 4;
        System.out.println("自增位于前后问题可参考《算术运算符Demo3和Test》");
        System.out.println((x++) > 3 && (y++) > 4);// (y++)是没有执行，所以后续打印y的值依然是4
        System.out.println(x);
        System.out.println(y);
    }
}
