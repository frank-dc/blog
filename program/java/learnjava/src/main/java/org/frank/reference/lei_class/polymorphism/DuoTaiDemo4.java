package org.frank.reference.lei_class.polymorphism;
/*
	如何访问子类特有功能呢?
		A:创建子类对象即可。
		B:多态的转型问题
			向上转型
				从子到父
				父类引用指向子类对象
			向下转型
				从父到子
				父类引用转为子类对象
 */
class Animal3 {
    public void eat(){}
}

class Dog3 extends Animal3 {
    public void eat(){
        System.out.println("狗吃骨头");
    }

    public void help() {
        System.out.println("狗可以帮助警察叔叔抓小偷");
    }
}

class Cat3 extends Animal3 {
    public void eat() {
        System.out.println("猫吃老鼠");
    }
}

public class DuoTaiDemo4 {
    public static void main(String[] args) {
        // 多态
        Animal3 a = new Dog3();     // 向上转型
        a.eat();
//        a.help();   // 编译看左边

        // 向下转型
        Dog3 d = (Dog3)a;
        d.eat();
        d.help();

        a = new Cat3();
        a.eat();

        Cat3 c = (Cat3)a;
        c.eat();

//        Dog3 dd = (Dog3)a;  // Casting 'a' to 'Dog3' will produce 'ClassCastException' for any non-null value
//        dd.eat();
//        dd.help();

    }
}
