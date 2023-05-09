package org.frank.basic.assignment;
/*
        在 Java 中，使用算术运算符执行的操作总是产生一个int类型的结果。
 */
public class OperatorTest {
    public static void main(String[] args) {
        short x = 1;
//        x = x + 1;    // int 类型赋值给 short 类型，编译错误，需要将其强制转换才行。
                        // x = (short) (x + 1)  // 正确
        System.out.println(x);

        short y = 1;
        y += 1;         // 使用复合赋值运算符将整数1添加到short类型的变量y上是安全的，因为编译器
                        // 会自动将右侧的整数转换为short类型。
        System.out.println(y);
    }
}
