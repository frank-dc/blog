package org.frank.reference.lei_class.encapsulation;
/*
	定义学生类：姓名，年龄

	由于我们创建了对象，所以我们可以通过对象去使用类中的成员。
	而现在的情况是，我们不想对象直接去使用类的成员变量。
	肿么办呢?
	java针对这种情况，就提供了一个关键字：private。

	private:
		1. 是一个权限修饰符。
		2. 可以修饰成员(成员变量和成员方法)
	    3. 被 private 修饰的成员只在本类中才能访问。
 */

class Student {
    String name;
    private int age;

    public void checkAge(int a) {
        if(a < 0) {
            System.out.println("年龄有误！");
        } else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // 创建学生对象
        Student s = new Student();

        // 给 name 和 age 赋值
        s.name = "王祖贤";
//        s.age = -18;
        s.checkAge(-18);
        s.checkAge(28);

        System.out.println(s.name);
        System.out.println(s.getAge());
    }
}
