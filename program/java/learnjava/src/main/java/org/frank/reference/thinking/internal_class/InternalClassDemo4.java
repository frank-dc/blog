package org.frank.reference.thinking.internal_class;
/*
    匿名内部类：没有名字的内部类。

    前提：存在一个类或者接口
            这里的类可以是具体类也可以是抽象类

    格式：
        new 类名或者接口名() {
            重写方法;
        }

    本质理解：其本质是匿名子类对象。
 */
interface Inter {
    public abstract void show();
    public abstract void show2();
}

class Outer4 {
    private int num = 100;

    public void method() {
        // 方式一
        new Inter() {
            public void show() {
                System.out.println("show()");
            }

            public void show2() {
                System.out.println("show2()");
            }
        }.show();

        new Inter() {
            public void show() {
                System.out.println("show()");
            }

            public void show2() {
                System.out.println("show2()");
            }
        }.show2();

        // 方式二
        Inter i = new Inter() {
            public void show() {
                System.out.println("show()");
            }

            public void show2() {
                System.out.println("show2()");
            }
        };
        i.show();
        i.show2();
    }
}

public class InternalClassDemo4 {
    public static void main(String[] args) {
        Outer4 o = new Outer4();
        o.method();
    }
}
