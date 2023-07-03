package org.frank.reference.lei_class.polymorphism;

/*
    多态的好处：
        1. 提高了程序的维护性（由继承保证）
        2. 提高了程序的扩展性（由多态保证）

    多态的坏处：
        不能访问子类特有的功能
 */
class Animal2 {
    public void eat(){}

    public void sport(){}
}

class Dog2 extends Animal2 {
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void sport() {
        System.out.println("狗游泳");
    }

    public void lookDoor() {
        System.out.println("狗看门");
    }
}

class Cat2 extends Animal2 {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void sport() {
        System.out.println("猫追老鼠");
    }
}

class Pig2 extends Animal2 {
    public void eat() {
        System.out.println("猪吃饲料");
    }

    public void sport() {
        System.out.println("猪爱睡觉");
    }
}

public class DuoTaiDemo3 {
    public static void main(String[] args) {
        Dog2 d1 = new Dog2();
        /* 原始调用
        d1.eat();
        d1.sport();
         */

        Dog2 d2 = new Dog2();
        /* 原始调用
        d2.eat();
        d2.sport();
         */

        Dog2 d3 = new Dog2();
        /* 原始调用
        d3.eat();
        d3.sport();
         */

        /* 优化
        dogActive(d1);
        dogActive(d2);
        dogActive(d3);
         */

        // 终极优化
        animalActive(d1);
        animalActive(d2);
        animalActive(d3);

        Cat2 c1 = new Cat2();
        /* 原始调用
        c1.eat();
        c1.sport();
         */

        Cat2 c2 = new Cat2();
        /* 原始调用
        c2.eat();
        c2.sport();
         */
        Cat2 c3 = new Cat2();

        /* 原始调用
        c3.eat();
        c3.sport();
         */

        /* 优化
        catActive(c1);
        catActive(c2);
        catActive(c3);
         */

        // 终极优化
        animalActive(c1);
        animalActive(c2);
        animalActive(c3);

        Pig2 p1 = new Pig2();
        /* 原始调用
        p1.eat();
        p1.sport();
         */

        Pig2 p2 = new Pig2();
        /* 原始调用
        p2.eat();
        p2.sport();
         */

        Pig2 p3 = new Pig2();
        /* 原始调用
        p3.eat();
        p3.sport();
         */

        /* 优化
        pigActive(p1);
        pigActive(p2);
        pigActive(p3);
         */

        // 终极优化
        animalActive(p1);
        animalActive(p2);
        animalActive(p3);
    }

    /*
    public static void dogActive(Dog2 d) {
        d.eat();
        d.sport();
    }

    public static void catActive(Cat2 c) {
        c.eat();
        c.sport();
    }

    public static void pigActive(Pig2 p) {
        p.eat();
        p.sport();
    }
     */
    public static void animalActive(Animal2 a) {
        // 将对象作为函数参数
        a.eat();
//        a.lookDoor();     // 不能访问子类特有的功能
        a.sport();
    }
}
