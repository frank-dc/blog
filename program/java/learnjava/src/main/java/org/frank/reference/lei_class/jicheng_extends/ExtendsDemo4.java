package org.frank.reference.lei_class.jicheng_extends;
/*
    继承之间构造方法关系：
        子类中的所有构造方法默认都会访问父类中空参数的构造方法。

        原因是：
            因为子类会继承父类中的数据，可能还会使用父类的数据。
            所以，子类初始化之前，一定要完成父类数据的初始化。

    我们可以通过 super(...) 访问父类中带参构造方法。

    注意事项：
        1. 子类中每一个构造方法的第一条语句默认都是：super()。
        2. super(...) 这样的形式在构造方法中只能出现一次。
        3. 如果父类没有无参构造方法，我们可以通过
            a. super去访问父类的带参构造方法。
            b. this去访问本类的其它构造方法。
 */

class Fu {

     public Fu() {
         System.out.println("Fu()");
     }

    public Fu(String name) {
        System.out.println("hello " + name + " from Fu");
    }
}

class Zi extends Fu {
    public Zi() {
//        super("Alvin");
//        this("Zhangsan");
        System.out.println("Zi()");
    }

    public Zi(String name) {
        super("Simon");
//        this();
        System.out.println("hello " + name + " from Zi");
    }
}
public class ExtendsDemo4 {
    public static void main(String[] args) {
        // 创建子类对象
        Zi z = new Zi();
        Zi z2 = new Zi("Theadore");
    }
}
