package org.frank.reflection;

/*
    一个类只有一个Class对象
 */
public class Test01  {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        // 通过Class.forName属性获取该类的Class对象
        Class c1 = Class.forName("org.frank.reflection.Student");
        System.out.println(c1.hashCode());
        System.out.println(c1.getName());

        // 通过实例方法getClass获取该类的Class对象
        Class c2 = person.getClass();
        System.out.println(c2.hashCode());
        System.out.println(c2.getName());

        // 通过类的.class属性获取该类的Class对象
        Class c3 = Student.class;
        System.out.println(c3.hashCode());
        System.out.println(c3.getName());

        // 基础类都有一个.TYPE属性该类的Class对象
        Class i = Integer.TYPE;
        System.out.println(i.hashCode());
        System.out.println(i.getName());

        // 获取父类Class对象
        Class c11 = c1.getSuperclass();
        System.out.println(c11);

    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Student extends Person {
    public Student() {
        this.name = "I'm a student.";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "I'm a teacher.";
    }
}