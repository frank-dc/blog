package org.frank.reference.lei_class.final_keyword;
/*
    final：最终的意思，就是不让子类修改我的数据。

    作用：
        可以修饰类，成员变量，成员方法

    特点：
        类：被final修饰后，说明该类是最终类，不能被继承。
        成员变量：被final修饰后，就变成了常量，值不能被修改。
        成员方法：被final修饰后，不能被子类重写。
 */
final class Father {
    public int num = 10;
    final int num2 = 20;

    public final void getResource() {
        System.out.println("这里是绝密资源，可以看，不可以改");
    }

    public void show() {
        num = 100;
        System.out.println(num);
//        num2 = 200;     // Cannot assign a value to final variable 'num2'
        System.out.println(num2);
    }
}

/*Cannot inherit from final 'org.frank.reference.lei_class.final_keyword.Father'
class Son extends Father {
    public void getResource() {
        System.out.println("'getResource()' cannot override 'getResource()' in 'org.frank.reference.lei_class.final_keyword.Father'; overridden method is final")
    }
}
 */


public class FinalDemo {
    public static void main(String[] args) {
        Father f = new Father();
        f.getResource();
        f.show();
    }
}
