package org.frank.reference.lei_class.polymorphism;
/*
    多态成员访问特点：
        1. 成员变量
            编译看左边，运行看左边

        2. 成员方法
            编译看左边，运行看右边
            原因：成员方法有重写，而变量没有。

        3. 静态方法
            编译看左边，运行看左边
            原因：静态方法没有重写一说，因为它是跟类相关。
 */
class Person {
    public int age = 0;

    public void show() {
        System.out.println("show() from Person");
    }

    public static void method() {
        System.out.println("method() from Person");
    }
}

class Student extends Person {
    public int age = 18;

    public void show() {
        System.out.println("show() from Student");
    }

    public static void method() {
        System.out.println("method() from Student");
    }
}

public class DuoTaiDemo2 {
    public static void main(String[] args) {
        Person p = new Student();
        System.out.println(p.age);

        p.show();
        p.method();
    }
}
