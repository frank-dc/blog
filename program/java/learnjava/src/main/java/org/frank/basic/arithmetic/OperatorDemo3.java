package org.frank.basic.arithmetic;

/*
        ++: 自增1
        --: 自减1

        A: 单独使用，放在操作数据的前后，效果一样。
        B: 参与赋值运算
            a. 放在操作数前面，先自增或自减，再参与运算。
            b. 放在操作数后面，先参与运算，再自增或自减。
 */

public class OperatorDemo3 {
    public static void main(String[] args){
        int a = 10;
        int b = a++;    // 先参与运算，再自增。所以 b 的值为 10，a 的值为 11。
        System.out.println(a);  // 11
        System.out.println(b);  // 10

        int c = 10;
        int d = ++c;    // 先自增，再参与运算。
        System.out.println(c);  // 11
        System.out.println(d);  // 11

        int e = 10;
        e++;
        ++e;
        System.out.println(e);  // 12
    }
}
