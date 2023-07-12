package org.frank.reference.thinking.return_value;
/*
    如果返回值是一个引用数据类型：
        具体类：返回的是该类的对象。
        抽象类：返回的是该类的子类对象。
        接口：返回的是该接口的实现类对象。
 */
// 具体类（concrete class）
class ConcreteClass {
    public void show() {
        System.out.println("我是一个具体类");
    }
}

class ConcreteClassDemo {
    public ConcreteClass getConcreteClass() {
        return new ConcreteClass();
    }
}

// 抽象类（abstract class）
abstract class AbstractClass {
    public abstract void show();
}

class ExtendsAbstractClass extends AbstractClass {
    public void show() {
        System.out.println("我继承了一个抽象类");
    }
}

class AbstractClassDemo {
    public AbstractClass getAbstractClass() {
        return new ExtendsAbstractClass();
    }
}

// 接口（interface）
interface Interface {
    public abstract void show();
}

class ImplementsInterface implements Interface {
    public void show() {
        System.out.println("我实现了一个接口");
    }
}

class InterfaceDemo {
    public Interface getInterface() {
        return new ImplementsInterface();
    }
}

// 测试类
public class ReturnDemo2 {
    public static void main(String[] args) {
        ConcreteClassDemo ccd = new ConcreteClassDemo();
        ConcreteClass cc = ccd.getConcreteClass();
        cc.show();

        System.out.println("----------------------- 分割线1 -----------------------");

        AbstractClassDemo acd = new AbstractClassDemo();
        AbstractClass ac = acd.getAbstractClass();
        ac.show();

        System.out.println("----------------------- 分割线2 -----------------------");

        InterfaceDemo id = new InterfaceDemo();
        Interface i =  id.getInterface();
        i.show();
    }
}
