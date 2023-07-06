package org.frank.reference.jiekou_interface;
/*
    接口概述：现在在动物园里面，有些猫可以钻火圈，狗跳高，做计算等东西；
            而这些行为并不是动物天生就具备的，所以，不适合定义在动物类中；
            并且，也不是所有的猫和狗都能做出这些行为，所以直接定义在猫或者狗类中也不适合。
            针对这样的一种扩展功能，Java 提供了接口来实现。

    接口的特点：
        1. 接口用关键字 interface 表示
            格式：interface 接口名 {}
        2. 类实现接口用 implements 表示
            格式：class 类名 implements 接口名 {}
        3. 接口不能实例化
            接口多态
        4. 接口的子类
            a. 要么是抽象类
            b. 要么重写接口中的所有抽象方法
 */
interface Animal {
    public abstract void show();
}

abstract class Dog implements Animal {}

// Class 'Cat' must either be declared abstract or implement abstract method 'show()' in 'Animal'
class Cat implements Animal {
    public void show() {}
}
public class InterfaceDemo {
    public static void main(String[] args) {}
}
