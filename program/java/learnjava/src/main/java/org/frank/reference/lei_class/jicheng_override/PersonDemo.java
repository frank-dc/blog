package org.frank.reference.lei_class.jicheng_override;
/*
    方法重写注意事项：
        1. 父类中私有方法不能被重写
        2. 子类重写父类方法时，访问权限不能更低（建议一样）
        3. 父类静态方法，子类也必须通过静态方法进行重写
 */

class Person {
    public void show() {
        System.out.println("show() from Person");
    }

    private void show2() {
        System.out.println("show2() from Person");
    }

    public static void show3() {
        System.out.println("show3() from Person");
    }
}

class Student extends Person {
    public void show() {
        System.out.println("show() from Student");
    }

    private void show2() {
        System.out.println("show2() from Student");
    }

    public static void show3() {
        System.out.println("show3() from Student");
    }
}
public class PersonDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.show();
//        s.show2();
        s.show3();
    }
}
