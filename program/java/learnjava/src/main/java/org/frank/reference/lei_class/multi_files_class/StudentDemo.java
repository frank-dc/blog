package org.frank.reference.lei_class.multi_files_class;

public class StudentDemo {
    public static void main(String[] args) {
        // 创建学生对象
        Student s = new Student();

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
