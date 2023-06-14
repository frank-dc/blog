package org.frank.reference.lei_class.formal_params;
/*
    引用类型作为参数传递，需要传递的是对象（地址值）。
 */

class StudentTwo {
    public void study() {
        System.out.println("学生喜欢学习");
    }
}

class StudentTwoDemo {
    public void test(StudentTwo st) {
        st.study();
    }
}

public class StudentTest {
    public static void main(String[] args) {
        StudentTwo st = new StudentTwo();
        StudentTwoDemo std = new StudentTwoDemo();
        st.study();
        std.test(st);
    }
}
