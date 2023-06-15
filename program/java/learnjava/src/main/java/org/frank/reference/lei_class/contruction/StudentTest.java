package org.frank.reference.lei_class.contruction;
/*
    构造方法：给对象的变量进行初始化。

    特点：
        1. 方法名和类名相同
        2. 没有返回值类型，连void都没有
        3. 没有具体的返回值

    格式：
        修饰符 类名(...) {

        }

    注意事项：
        1. 如果不提供构造方法，编译器会给出默认无参构造方法。
        2. 如果提供了构造方法，编译器就不会给出默认无参构造方法。
            如果还想继续使用无参构造方法，就必须自己给出。
        3. 构造方法也是可以重载的。
        4. 构造方法可以有return，只能是`return;`
 */
class Student {
    private String name;
    private int age;

    // 构造方法
    public Student() {
        System.out.println("我是无参构造方法");
    }

    // 以下重载构造方法
    public Student(String name) {
        this.name = name;
    }

    public Student(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 以下是setXxx()/getXxx()方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    // 显示成员变量的方法
    public void show() {
        System.out.println("我的姓名是：" + name + "\t年龄是：" + age);
    }
}

public class StudentTest {
    public static void main(String[] args) {
        // 创建 Student 对象
        Student s1 = new Student();
        s1.show();

        Student s2 = new Student("王祖贤");
        s2.show();

        Student s3 = new Student(28);
        s3.show();

        Student s4 = new Student("王祖贤", 28);
        s4.show();
    }
}
