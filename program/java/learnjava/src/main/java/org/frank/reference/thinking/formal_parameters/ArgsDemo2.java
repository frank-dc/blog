package org.frank.reference.thinking.formal_parameters;
/*
    形式参数如果是引用类型：
        具体类：该类的对象
        抽象类：该类的子类对象
        接口：该接口的实现类对象
        数组：数组的地址值，其实就是一个数组对象
 */

// 具体类（concrete class)
class ConcreteClass {
    public void show() {
        System.out.println("我是一个具体类");
    }
}

class ConcreteClassDemo {
    public void method(ConcreteClass cc) {
        cc.show();
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
    public void method(AbstractClass ac) {
        ac.show();
    }
}

// 接口
interface Interface {
    public abstract void show();
}

class ImplementsInterface implements Interface {
    public void show() {
        System.out.println("我实现了一个接口");
    }
}

class InterfaceDemo {
    public void method(Interface i) {
        i.show();
    }
}

// 测试类
public class ArgsDemo2 {
    public static void main(String[] args) {
        ConcreteClassDemo ccd = new ConcreteClassDemo();
        // 方式一
        ConcreteClass cc = new ConcreteClass();
        ccd.method(cc);
        // 方式二
        ccd.method(new ConcreteClass());

        System.out.println("----------------------- 分割线1 -----------------------");

        AbstractClassDemo acd = new AbstractClassDemo();
        // 方式一
        AbstractClass eac = new ExtendsAbstractClass();
        acd.method(eac);
        // 方式二
        acd.method(new ExtendsAbstractClass());

        System.out.println("----------------------- 分割线2 -----------------------");

        InterfaceDemo id = new InterfaceDemo();
        // 方式一
        Interface i = new ImplementsInterface();
        id.method(i);
        // 方式二
        id.method(new ImplementsInterface());
    }
}
