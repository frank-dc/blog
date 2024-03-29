package org.frank.reference.lei_class.abstract_class;
/*
    抽象类的成员特点：
        1. 成员变量
            可以是变量，也可以是常量
        2. 构造方法
            有构造方法，但不能实例化
            问题：构造方法有什么作用？
                用于子类访问父类数据的初始化
        3. 成员方法
            可以有抽象方法，也可以有非抽象方法
            抽象方法：强制要求子类做某些事
            非抽象方法：用于给子类直接使用，提高了代码的复用性
 */
abstract class Animal2 {
    int num = 10;
    final int num2 = 20;

    public Animal2(){}

    public void method() {
        System.out.println("method");
    }

    public abstract void method2();
}

class Dog2 extends Animal2 {
    public void show() {
        num = 100;
        System.out.println(num);
//        num2 = 200; // Cannot assign a value to final variable 'num2'
        System.out.println(num2);
    }

    public void method2() {}
}

public class AbstractDemo2 {
    public static void main(String[] args) {
        Dog2 d = new Dog2();
        d.show();
        d.method();
    }
}
