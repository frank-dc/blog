package org.frank.reference.jiekou_interface;
/*
    老师和学生的案例，加入抽烟的额外行为。

    Smoking：
        抽烟的行为

    老师：
        成员变量：姓名、年龄
        构造方法：无参、有参
        成员方法：getXXX()、setXXX()、学习、睡觉

    学生：
        成员变量：姓名、年龄
        构造方法：无参、有参
        成员方法：getXXX()、setXXX()、学习、睡觉

    通过老师和学生可以分析出人类：
    人：
        成员变量：姓名、年龄
        构造方法：无参、有参
        成员方法：getXXX()、setXXX()、学习、睡觉

    最终的分析：
    人：抽象类
        成员变量：姓名、年龄
        构造方法：无参、有参
        成员方法：getXXX()、setXXX()、学习、睡觉
            老师
                部分老师抽烟
            学生
                部分学生抽烟

    Smoking：接口
        抽烟的行为

 */

// 抽烟接口
interface Smoking {
    public abstract void smoke();
}

// 人抽象类
abstract class Person {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    // 老师、学生都要睡觉，所以定义一个公共的方法。
    public void sleep() {
        System.out.println("睡觉");
    }

    // 定义一个抽象方法，由老师、学生各自实现，因为学习的方向、内容有区别，所以要多态。
    public abstract void study();
}

// 一般的老师类
class Teacher extends Person {
    public Teacher(){}

    public Teacher(String name, int age) {
        super(name, age);
    }

    // 该类如果不是抽象类，则必须要重写study方法。
    public void study() {
        System.out.println("老师学习如何把知识讲明白");
    }
}

// 抽烟的老师类
class SmokeTeacher extends Teacher implements Smoking {
    public SmokeTeacher(){}

    public SmokeTeacher(String name, int age) {
        super(name, age);
    }

    // 该类实现Smoking接口，必须重写smoke方法。
    public void smoke() {
        System.out.println("抽烟的老师");
    }
}

// 一般的学生类
class Student extends Person {
    public Student(){}

    public Student(String name, int age) {
        super(name, age);
    }

    // 该类如果不是抽象类，则必须要重写study方法。
    public void study() {
        System.out.println("学生好好学习，报效祖国");
    }
}

// 抽烟的学生类
class SmokeStudent extends Student implements Smoking {
    public SmokeStudent() {}

    public SmokeStudent(String name, int age) {
        super(name, age);
    }

    public void smoke() {
        System.out.println("抽烟的学生");
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        SmokeTeacher st = new SmokeTeacher();
        st.setName("毕姥爷");
        st.setAge(35);
        System.out.println("这一位老师叫：" + st.getName() + "\t年龄是：" + st.getAge());
        st.study();
        st.sleep();
        st.smoke();

        System.out.println("------------------------- 分割线 -------------------------");

        SmokeTeacher st2 = new SmokeTeacher("急先锋", 30);
        System.out.println("那一位老师叫：" + st2.getName() + "\t年龄是：" + st2.getAge());
        st2.study();
        st2.sleep();
        st2.smoke();

        System.out.println("------------------------- 分割线 -------------------------");

        SmokeStudent ss = new SmokeStudent();
        ss.setName("张三");
        ss.setAge(13);
        System.out.println("这一位学生叫：" + ss.getName() + "\t年龄是：" + ss.getAge());
        ss.study();
        ss.sleep();
        ss.smoke();

        System.out.println("------------------------- 分割线 -------------------------");

        SmokeStudent ss2 = new SmokeStudent("刘五", 10);
        System.out.println("那一位学生叫：" + ss2.getName() + "\t年龄是：" + ss2.getAge());
        ss2.study();
        ss2.sleep();
        ss2.smoke();
    }
}
