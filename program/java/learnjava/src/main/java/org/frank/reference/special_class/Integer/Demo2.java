package org.frank.reference.special_class.Integer;
/*
    自动装箱：int -> Integer
        public static Integer valueOf(int i)
    自动拆箱：Integer -> int
        public int intValue()

    注意：对象不能为null
 */
public class Demo2 {
    public static void main(String[] args) {
//        Integer i = new Integer(100);
        Integer i = 100;
        Integer i2 = Integer.valueOf(100);
        System.out.println(i);
        System.out.println(i2);

        i += 200;
//        i = Integer.valueOf(i.intValue() + 200);
        System.out.println(i);
    }
}
