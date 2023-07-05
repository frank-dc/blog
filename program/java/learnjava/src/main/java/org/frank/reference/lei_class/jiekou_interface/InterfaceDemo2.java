package org.frank.reference.lei_class.jiekou_interface;
/*
    接口的成员特点：
        1. 成员变量
            是常量，并且是静态的修饰的。
            默认的修饰符：public static final
        2. 构造方法
            没有构造方法
        3. 成员方法
            只能是抽象方法
            默认的修饰符：public abstract

    建议：自己写接口的内容的时候，把这些默认修饰符加上。
 */
interface Animal2 {
    int num2 = 20;      // 等同于 public static final int num2 = 20;
    final int num3 = 30;    // 等同于 public static final int num3 = 30;
    public static final int num = 10;

//    public Animal2(){}  // Not allowed in interface

    public abstract void show();

//    public void method() {}     // Interface abstract methods cannot have body
    void method2();     // 等同于 public abstract void method2();
}

class Dog2 implements Animal2 {
    public void show() {
//        num = 100;    // Cannot assign a value to final variable 'num'
        System.out.println(num);
//        num2 = 200;   // Cannot assign a value to final variable 'num2'
        System.out.println(num2);
//        num3 = 300;   // Cannot assign a value to final variable 'num3'
        System.out.println(num3);

        System.out.println(Animal2.num);
        System.out.println(Animal2.num2);
        System.out.println(Animal2.num3);
    }

    public void method2() {}
}

public class InterfaceDemo2 {
    public static void main(String[] args) {
        Dog2 d = new Dog2();
        d.show();
    }
}
