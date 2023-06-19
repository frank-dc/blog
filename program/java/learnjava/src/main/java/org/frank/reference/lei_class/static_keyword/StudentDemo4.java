package org.frank.reference.lei_class.static_keyword;
/*
    静态的内容是被所有对象共享的，非静态的是每个对象特有的。
 */

class Student4 {
    // 姓名
    String name;

    // 年龄
    int age;

    // 班级编号
    static String classNumber;

    public Student4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student4(String name, int age, String classNumber) {
        this.name = name;
        this.age = age;
        this.classNumber = classNumber;
    }

    public void show() {
        System.out.println(name + "\t" + age + "\t" + classNumber);
    }


}

public class StudentDemo4 {
    public static void main(String[] args) {
        Student4 s1 = new Student4("大乔", 28, "sgvy001");
        Student4 s2 = new Student4("小乔", 20);
        Student4 s3 = new Student4("貂蝉", 18);

        s1.show();  // 小乔	20	sgvy001
        s2.show();  // 大乔	28	sgvy001
        s3.show();  // 貂蝉	18	sgvy001

        s2.name = "曹操";
        s2.classNumber = "sgyy007";

        s1.show();  // 大乔	28	sgyy007
        s2.show();  // 曹操	20	sgyy007
        s3.show();  // 貂蝉	18	sgyy007
    }
}
