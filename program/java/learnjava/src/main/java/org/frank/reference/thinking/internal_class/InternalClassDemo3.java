package org.frank.reference.thinking.internal_class;
/*
    局部内部类：
        1. 位于成员方法内

    面试题：局部内部类访问局部变量为什么需要final修饰局部变量？
        因为局部变量会随着方法的调用完成而消失，
        这个时候，局部对象并没有立马从堆内存中消失，
        还要使用那个变量，为了让数据还能继续使用，
        故用final修饰，这样，在堆内存里面存储的其实是一个常量值。
 */

class Outer3 {
    public void method() {
        final int num = 100;

        class Inner {
            public void show() {
                System.out.println("我是一个位于成员方法内部的内部类，被称为局部内部类");
            }
        }

        Inner i = new Inner();
        i.show();
    }
}
public class InternalClassDemo3 {
    public static void main(String[] args) {
        Outer3 o = new Outer3();
        o.method();
    }
}
