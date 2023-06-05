package org.frank.method;
/*
    方法重载：
        在同一个类中，允许存在一个以上的同名方法，只要他们的参数个数或参数类型不同即可。
        和返回值类型无关
 */
public class OverloadingDemo {
    public static void main(String[] args) {
        // 需求：写一个方法，实现两个数的求和
        System.out.println(sum(11, 22));
        System.out.println(sum(11.11, 22.22));

        // 需求：写一个方法，实现三个数的求和
        System.out.println(sum(11, 22, 33));
        System.out.println(sum(11.11, 22.22, 33.33));
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static double sum(double a, double b, double c) {
        return a + b + c;
    }
}
