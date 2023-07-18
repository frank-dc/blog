package org.frank.reference.object_class.p3;

public class StudentDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("王祖贤", 28);

        Object obj = s1.clone();
        Student s2 = (Student) obj;

        System.out.println(s1.toString());      //...Student@1134affc
        System.out.println(obj.toString());     //...Student@d041cf
        System.out.println(s2.toString());      //...Student@d041cf

        System.out.println(s1.getName() + "\t" + s1.getAge());  // 王祖贤	28
        System.out.println(s2.getName() + "\t" + s2.getAge());  // 王祖贤	28

        Student s3 = s1;
        System.out.println(s3.toString());      //...Student@1134affc
        System.out.println(s3.getName() + "\t" + s3.getAge());  // 王祖贤	28

        s1.setName("张曼玉");

        System.out.println(s1.getName() + "\t" + s1.getAge());  // 张曼玉	28
        System.out.println(s2.getName() + "\t" + s2.getAge());  // 王祖贤	28
        System.out.println(s3.getName() + "\t" + s3.getAge());  // 张曼玉	28

    }
}
