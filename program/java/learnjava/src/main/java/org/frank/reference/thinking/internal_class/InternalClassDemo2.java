package org.frank.reference.thinking.internal_class;

class Outer2 {
    public static class Inner {
        public void show() {
            System.out.println("我是一个成员内部类，并且使用static修饰");
        }

        public static void show2() {
            System.out.println("我是一个成员内部类的成员方法，并且使用static修饰");
        }
    }
}
public class InternalClassDemo2 {
    public static void main(String[] args) {
        // 使用static修饰内部类后，这种写法错误。
//        Outer2.Inner oi = new Outer2().new Inner(); // Qualified new of static class
        Outer2.Inner oi = new Outer2.Inner();
        oi.show();
        oi.show2();     // 静态方法一般直接通过类调用，不需要对象
        Outer2.Inner.show2();
    }
}
