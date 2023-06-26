package org.frank.reference.lei_class.jicheng_extends;
/*
    Java 中的继承特点：
        1. 只支持单继承，不支持多继承
        2. 支持多层继承
 */
class A {

}

class B extends A {

}

/* Class cannot extend multiple classes
class C extends A, B {

}
 */

class C extends B {

}

public class ExtendsDemo {
    public static void main(String[] args) {

    }
}
