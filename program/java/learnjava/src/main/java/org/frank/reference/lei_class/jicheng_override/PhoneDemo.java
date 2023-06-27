package org.frank.reference.lei_class.jicheng_override;
/*
    方法重写：子类中出现了和父类中一模一样的方法声明，也称为方法覆盖，方法复写。
 */

class Phone {
    public void call(String name) {
        System.out.println("打电话给 " + name);
    }
}

class NewPhone extends Phone {
    public void call(String name) {
        System.out.println("拨号");
        super.call(name);
    }
}
public class PhoneDemo {
    public static void main(String[] args) {
        // phone
        Phone p = new Phone();
        p.call("王祖贤");

        // new phone
        NewPhone np = new NewPhone();
        np.call("马云");
    }
}


