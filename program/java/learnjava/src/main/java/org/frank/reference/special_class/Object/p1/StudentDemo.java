package org.frank.reference.special_class.Object.p1;
/*
    Object: 是类层次结构的根类，所有类都直接或者间接的继承自该类。

    Object类的方法：
        1. public int hashCode(): 返回该对象的哈希码值。
            哈希码值不是实际的地址值，一般我们把它理解为地址值。因为它是根据地址换算出来的一个值。
        2. public final Class<?> getClass()：返回此 Object 的运行时类。
        3. public String getName(): 返回该对象对应的类/抽象类/接口的名称。
        4. public String toString(): 返回该对象的字符串表示。
            getClass().getName() + "@" + Integer.toHexString(hashCode())
        5. public boolean equals(Object obj)
        6. protected void finalize()
        7. protected Object clone()
   Integer
 * 		public static String toHexString(int i): 返回一个整数的十六进制的字符串表示形式
 */
public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.hashCode());  // 288665596
        Student s2 = new Student();
        System.out.println(s2.hashCode());  // 13648335

        System.out.println("-------------------- 分割线 --------------------");

        Student s3 = new Student();
        Class c = s3.getClass();
        System.out.println(c.getName());    // org.frank.reference.object_class.p1.Student

        System.out.println("-------------------- 分割线 --------------------");

        Student s4 = new Student();
        // 如果直接输出一个对象的名称，其实输出的是该对象调用toString()方法后的字符串。
        System.out.println(s4);             // Student [name=null, age=0]
        System.out.println(s4.toString());  // Student [name=null, age=0]
        String s = s4.getClass().getName() + "@" + Integer.toHexString(s4.hashCode());
        System.out.println(s);  // org.frank.reference.object_class.p1.Student@3d8c7aca

        System.out.println("-------------------- 分割线 --------------------");

        Student s5 = new Student("王祖贤", 28);
        System.out.println(s5); // Student [name=王祖贤, age=28]
    }
}
