package org.frank.reference.lei_class.encapsulation;
/*
    private的应用场景：
        1. 把成员变量私有化
        2. 对外提供公共的 getXxx() 和 setXxx() 方法
 */

class StudentTwo {
    private String name;
    private int age;

    // 针对 name 给出 get 和 set
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    // 针对 age 给出 get 和 set
    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

}
public class StudentDemo2 {
    public static void main(String[] args) {
        // 创建对象
        StudentTwo st = new StudentTwo();

        // 输出成员变量的值
        System.out.println(st.getName() + '\t' + st.getAge());

        // 给成员变量赋值
        st.setName("王祖贤");
        st.setAge(28);

        // 再次输出成员变量的值
        System.out.println(st.getName() + '\t' + st.getAge());
    }
}
