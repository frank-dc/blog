package org.frank.reference.lei_class.static_keyword;
/*
    static 使用注意事项：
        1. 在静态方法中是没有this关键字的
            因为静态是随着类的加载而加载，优先于对象而存在，而this是随着对象的创建而存在。
            先进内存的，不能访问后进内存的；而后进内存的，可以访问先进内存的。
        2. 静态只能访问静态
            非静态的成员方法
                可以访问静态成员和方法，非静态成员和方法
            静态的成员方法
                只能访问静态成员和方法
 */
class Student3 {
    // 非静态的成员
    int x = 10;

    // 静态的成员
    static int y = 20;

    public void show() {
        // 非静态的成员方法访问成员变量
        System.out.println("我在访问非静态的成员 x: " + x);
        System.out.println("我在访问静态的成员 y: " + y);
    }

    public static void show2() {
        // 静态的成员方法访问成员变量
//        System.out.println("我不能访问非静态的成员 x: " + x);  // Non-static field 'x' cannot be referenced from a static context
        System.out.println("我在访问静态的成员 y: " + y);
    }

    public void show3() {
        // 非静态的成员方法访问成员方法
        show();
        show2();
    }

    public static void show4() {
        // 静态的成员方法访问成员方法
//        show(); // Non-static method 'show()' cannot be referenced from a static context
        show2();
    }
}

public class StudentDemo3 {
    public static void main(String[] args) {
//        System.out.println(Student3.x); // Non-static field 'x' cannot be referenced from a static context
        System.out.println(Student3.y);
        Student3.show2();
        Student3.show4();

        Student3 s = new Student3();

        s.show();
        s.show2();
        s.show3();
        s.show4();
    }
}
