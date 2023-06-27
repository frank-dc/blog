package org.frank.reference.lei_class.final_keyword;
/*
    final 修饰局部变量
        基本类型：其值不能改变
        引用类型：其地址值不能改变
 */
class Student {
    int age = 10;
}

class Person {
    public void show() {
        // 局部变量 - 基本类型
        int num = 100;
        System.out.println(num);    // 100
        num = 101;
        System.out.println(num);    // 101

        // final 修饰局部变量 - 基本类型
        final int num2 = 200;
        System.out.println(num2);   // 200
//        num2 = 201;  // Cannot assign a value to final variable 'num2'
        System.out.println(num2);   // 200
    }

    public void method() {
        // 局部变量 - 引用类型
        Student s1 = new Student();
        System.out.println(s1.age); // 10
        s1.age = 11;
        System.out.println(s1.age); // 11

        // final 修饰局部变量 - 引用类型
        final Student s2 = new Student();
        System.out.println(s2.age); // 10
        s2.age = 12;
        System.out.println(s2.age); // 12

//        s2 = new Student();     // Cannot assign a value to final variable 's2'
    }
}

public class FinalDemo2 {
    public static void main(String[] args) {
        Person p = new Person();
//        p.show();
        p.method();
    }
}
