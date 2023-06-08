package org.frank.reference.lei_class.one_file;
/*
    一个.java文件可以有多个类

    只能有一个类被public修饰，即带main方法的类（测试类）。

    在测试类中使用类的格式：
        类名 对象名 = new 类名();

    在测试类中使用类的成员：
        成员变量：对象名.变量名;
        成员方法：对象名.方法名(...);

    注意：
        引用类型的默认值是null
 */

import java.sql.Struct;

class Student {
    // 成员变量
    // 学号
    String sid;

    // 姓名
    String name;

    // 年龄
    int age;

    // 成员方法
    // 学习的方法
    public void study() {
        System.out.println("学生爱学习");
    }

    // 吃法的方法
    public void eat() {
        System.out.println("学生要吃饭");
    }

    // 睡觉的方法
    public void sleep() {
        System.out.println("学生要睡觉");
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // 创建学生对象
        Student s = new Student();

        // 输出对象名
        System.out.println(s);  // org.frank.reference.lei_class.one_file.Student@1134affc

        // 输出成员变量
        System.out.println("初始学号是：" + s.sid);   // null
        System.out.println("初始姓名是：" + s.name);  // null
        System.out.println("初始年龄是：" + s.age);   // 0

        // 给成员变量赋值
        s.sid = "itcast001";
        s.name = "王祖贤";
        s.age = 28;

        // 再次输出成员变量
        System.out.println("学号是：" + s.sid);     // itcast001
        System.out.println("姓名是：" + s.name);    // 王祖贤
        System.out.println("年龄是：" + s.age);     // 28

        // 使用成员方法
        s.study();
        s.eat();
        s.sleep();
    }
}
