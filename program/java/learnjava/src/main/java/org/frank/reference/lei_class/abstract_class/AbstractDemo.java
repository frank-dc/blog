package org.frank.reference.lei_class.abstract_class;
/*
    抽象类概述：
        动物不是一个具体的事物，只有猫、狗...才是具体的个体。
        并且，在动物中针对吃的功能，不应该给出具体地表现。
        因为不同的动物吃的内容不一样，我们应该让具体的动物自己去实现自己吃的功能。
        而一个功能如果没有具体的表现，就是一个抽象的内容。

        为了表示这是一个抽象的东西，Java提供了一个标识的关键字：abstract
        格式：
            修饰符 abstract 返回值类型 方法名(参数列表...);
        一个类中的方法如果是抽象的话，那么，该类就必须定义为抽象类。

    抽象类的特点：
        1. 抽象类和抽象方法必须用abstract修饰。
        2. 抽象类的子类。
            a. 要么是抽象类；
            b. 要么实现抽象类中的所有抽象方法；
        3. 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类。
        4. 抽象类不能实例化。
            按照多态的方式使用抽象类的功能

 */
abstract class Animal {
    // 这个方法是有方法体的，只不过内容为空。
    // public void sport() {}

    // 抽象方法，没有方法体
    public abstract void eat();
}

// Class 'Dog' must either be declared abstract or implement abstract method 'eat()' in 'Animal'
abstract class Dog extends Animal {}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
//        Animal a = new Animal();    // 'Animal' is abstract; cannot be instantiated

//        Dog d = new Dog();  // 'Dog' is abstract; cannot be instantiated

        /* 正常创建一个Cat对象
        Cat c = new Cat();
        c.eat();
         */

        // 多态
        Animal a = new Cat();
        a.eat();
    }
}
