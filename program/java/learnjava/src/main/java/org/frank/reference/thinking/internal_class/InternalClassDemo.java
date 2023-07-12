package org.frank.reference.thinking.internal_class;
/*
    成员内部类：
        通过创建内部类的对象即可访问内部的方法。
        格式：
            外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
 */
class Outer {
    private int num = 10;

    // 成员内部类
    class Inner {
        public void show() {
            System.out.println("我是一个成员内部类，可以访问私有成员变量 num = " + num);
        }
    }

    public void method() {
        Inner i = new Inner();
        i.show();
    }
}

public class InternalClassDemo {
    public static void main(String[] args) {
        // 创建Outer对象
        Outer o = new Outer();
        o.method();

        // 创建Outer内部类对象
        Outer.Inner oi = new Outer().new Inner();
        oi.show();
    }
}
