package org.frank.reference.lei_class.formal_params;
/*
    匿名对象：没有名字的对象。

    使用场景：
        1. 调用方法，该方法仅仅被使用一次的时候适用
        2. 作为实际参数传递
 */

class Student {
    public void love() {
        System.out.println("学生喜欢放假");
    }
}

class StudentDemo {
    public void test(Student s) {
        s.love();
    }
}

public class NoNameObject {
    public static void main(String[] args) {
        // 有名字的情况
//        Student s = new Student();
//        StudentDemo sd = new StudentDemo();
//        sd.test(s);

        // 没有名字的情况
//        StudentDemo sd = new StudentDemo();
//        sd.test(new Student());

        new StudentDemo().test(new Student());
    }
}
