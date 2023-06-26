package org.frank.reference.lei_class.jicheng_extends;
/*
    继承之间成员变量关系：
        名字不同：该谁就是谁
        名字相同：就近原则

    使用变量的时候，首先找局部范围。
    如果想直接使用成员变量，加关键字：this 即可。
    如果想直接使用父类的成员变量，加关键字：super 即可。
 */
class Father {
    public int age = 50;
}

class Son extends Father {
    public int num = 100;
    public int age = 20;

    public void show() {
        int age = 22;
        System.out.println(age);        // 局部范围     22
        System.out.println(this.age);   // 本类成员范围   20
        System.out.println(super.age);  // 父类成员范围   50
        System.out.println(num);        // 100
    }
}

public class ExtendsDemo3 {
    public static void main(String[] args) {
        Son s = new Son();
        System.out.println(s.num);  // 100
        System.out.println(s.age);  // 20
        s.show();
    }
}
