package org.frank.annotation;

public class Test01 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A {
    static {
        System.out.println("A 类静态代码初始化。");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A 类的无参构造。");
    }
}
