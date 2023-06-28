package org.frank.reference.lei_class.polymorphism;
/*
    多态：同一个对象在不同时刻表现出不同的状态。

    举例：
        A: 水（冰，水，水蒸气）
        B: 狗和动物
            把右边的值赋值给左边，如果能读通过（符合逻辑），就说明可以。
            动物 a = new 动物();
            动物 aa = new 狗();
            狗 d = new 狗();
            狗 dd = new 动物();    // 不可以
 */

class Animal {
    public void eat() {
        System.out.println("动物吃什么");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃肉");
    }
}

public class DuoTaiDemo {
    public static void main(String[] args) {
//        Animal a = new Animal();
//        Dog d = new Dog();

        // 多态
        Animal a = new Dog();
        a.eat();    // 狗吃肉
    }
}
