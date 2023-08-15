package org.frank.reference.special_class.Integer;
/*
    Integer的构造方法：
        Integer(int value)： 把int类型的值包装成Integer类型
        Integer(String s): 把数字类型的字符串转换成Integer类型
 */
public class StructureDemo {
    public static void main(String[] args) {
        // 将int类型的值包装成Integer类型
        int number = 100;
        Integer i = new Integer(number);
        System.out.println(i);

        // 将数字类型的字符串包装成Integer类型
        String s = "100";
        Integer i2 = new Integer(s);
        System.out.println(i2);
    }
}
