package org.frank.reference.thinking.internal_class;
/*
    匿名内部类在开发中的使用
 */
interface Person {
    public abstract void show();
}

class PersonDemo {
    public void method(Person p) {
        p.show();
    }
}

/*
class Student implements Person {
    public void show() {
        System.out.println("show student");
    }
}
 */

public class AnonymousInternalClassDemo {
    public static void main(String[] args) {
        // 调用PersonDemo类的method方法
        /*
        PersonDemo pd = new PersonDemo();
        Person p = new Student();
        pd.method(p);
         */

        // 匿名对象实现
        /*
        new PersonDemo().method(new Student());
         */

        // 匿名内部类实现
        new PersonDemo().method(new Person(){
            public void show() {
                System.out.println("anonymous inner class");
            }
        });

        new PersonDemo().method(new Person(){
            public void show() {
                System.out.println("show");
            }
        });
    }
}
