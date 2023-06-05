package org.frank.method;
/*
    比较两个数据是否相等，并在 main 方法中进行测试
    参数类型分别为：
        两个 byte 类型
        两个 short 类型
        两个 int 类型
        两个 long 类型
 */
public class OverloadingTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println("a = " + a + "\t\tb = " + b);

        System.out.println(compare(a, b));
        /*
        短字节类型可以作为长字节类型的参数
        比如：int 类型的 a 和 b, 可以作为函数 compare(long a, long b) 的参数
             但是不能作为 compare(byte a, byte b) 和 compare(short a, short b) 的参数
         */

    }

    public static boolean compare(byte a, byte b) {
        return a == b;
    }

    public static boolean compare(short a, short b) {
        return a == b;
    }

    public static boolean compare(int a, int b) {
        return a == b;
    }

    public static boolean compare(long a, long b) {
        return a == b;
    }
}
