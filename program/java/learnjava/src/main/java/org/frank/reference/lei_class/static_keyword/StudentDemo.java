package org.frank.reference.lei_class.static_keyword;
/*
    班级编号应该是每个人共享的，所以定义一个就行了。
    而姓名和年龄，每个人都不一样，所以，每个对象，都应该定义自己的。

    在 Java 中，使用 static 关键字来表示成员变量是被共享的。
 */

class Student {
    // 姓名
    private String name;

    // 年龄
    private int age;

    // 班级编号
    static String classNumber;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String classNumber) {
        this.name = name;
        this.age = age;
        this.classNumber = classNumber;
    }

    public void show() {
        System.out.println(name + "\t" + age + "\t" + classNumber);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student("马云", 35, "20150503");
        s1.show();

        Student s2 = new Student("马化腾", 32);
        s2.show();

        Student s3 = new Student("马斯克", 33);
        s3.show();
    }
}
