package org.frank.reference.lei_class.polymorphism;

class A {
    public void show() {
        System.out.println("show() from A");
    }

    public void show2() {
        System.out.println("show2() from A");
    }
}

class B extends A {
    public void show2() {
        System.out.println("show2() from B");
    }
}

class C extends B {
    public void show() {
        System.out.println("show() from C");
    }
}

public class DuoTaiTest {
    public static void main(String[] args) {
        A a = new B();
        a.show();   // show() from A
        B b = new C();
        b.show();   // show() from C
    }
}
