package org.frank.reference.lei_class.static_keyword;
/*
    static: 静态关键字。

    作用：可以修饰成员变量和方法。

    特点：
        1. 随着类的加载而加载
        2. 优先于对象而存在
        3. 被类的所有对象共享
            这也是我们判断是否使用静态关键字的条件
            饮水机：可以被静态共享
            水杯：不可以被静态共享
        4. 可以通过类名调用，也可以通过对象调用
 */

class Student2 {
    public void show() {
        System.out.println("我是没有被static修饰的方法");
    }

    public static void show2() {
        System.out.println("我是被static修饰的方法");
    }
}

public class StudentDemo2 {
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.show();
        s.show2();  // 静态方法可以被对象调用

        Student2.show2();   // 静态方法可以通过类名调用
//        Student2.show();    // Non-static method 'show()' cannot be referenced from a static context
    }
}
