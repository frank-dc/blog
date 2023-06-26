package org.frank.reference.lei_class.jicheng_extends;
/*
    Java 中继承注意事项：
        1. 子类只能继承父类所有非私有的成员（成员变量和成员函数）。
        2. 子类不能继承父类的构造方法，但是可以通过super关键字去访问父类的构造方法。
        3. 满足以下关系才考虑继承
            继承中类之间体现的是："is a"的关系
            如果两个类满足这个关系：xxx is a yyy，则可以使用继承
            举例：
                Student, Person     可以继承
                Dog, Animal         可以继承
                Dog, Pig            不可以继承

 */
class Parent {
    private int num = 10;
    public int num2 = 100;

    private void show() {
        System.out.println("show");
    }

    public void show2() {
        System.out.println("show2");
    }
}

class Child extends Parent {

}

public class ExtendsDemo2 {
    public static void main(String[] args) {
        // 创建子类对象
        Child c = new Child();
//        System.out.println(c.num);    // 'num' has private access in 'org.frank.reference.lei_class.jicheng_extends.Parent'
        System.out.println(c.num2);
//        c.show();     // 'show()' has private access in 'org.frank.reference.lei_class.jicheng_extends.Parent'
        c.show2();

        // 创建父类对象
        // 父类对象同样不能访问私有成员
        Parent p = new Parent();
//        System.out.println(p.num);
        System.out.println(p.num2);
//        p.show();
        p.show2();
    }
}
