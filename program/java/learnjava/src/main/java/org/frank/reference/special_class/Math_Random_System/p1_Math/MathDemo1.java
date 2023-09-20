package org.frank.reference.special_class.Math_Random_System.p1_Math;

/*
    Math是用于数学操作的类。方法都是静态的
 */
public class MathDemo1 {
    public static void main(String[] args) {
        // public static int abs(int a): 求绝对值
        System.out.println("abs of 12: " + Math.abs(12));
        System.out.println("abs of -12: " + Math.abs(-12));

        // public static double ceil(double a): 向上取整
        System.out.println("ceil of 12.34: " + Math.ceil(12.34));
        System.out.println("ceil of -12.34: " + Math.ceil(-12.34));

        // public static double floor(double a): 向下取整
        System.out.println("floor of 12.34: " + Math.floor(12.34));
        System.out.println("floor of -12.34: " + Math.floor(-12.34));

        // public static int max(int a, int b): 返回两个整数中的较大值
        System.out.println("Max of 12 and 13: " + Math.max(12, 13));

        // public static double pow(double a, double b): 返回第一个参数的第二个参数次方的值。
        System.out.println("2**3 = " + Math.pow(2, 3));

        // public static double sqrt(double a): 返回双精度值的正确舍入正平方根。
        System.out.println("x**2 = 16; x = " + Math.sqrt(16));

        // public static int round(float a): 四舍五入
        System.out.println(Math.round(12.34f));
        System.out.println(Math.round(12.56f));

        // public static double random(): 返回带正号的双精度值，大于或等于 0.0 且小于 1.0。
        System.out.println(Math.random());

    }
}
