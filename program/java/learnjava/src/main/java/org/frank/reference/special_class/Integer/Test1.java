package org.frank.reference.special_class.Integer;
/*
    需求1：
        给出一个数据，判断这个数据是不是在int范围。
    需求2：
        给出一个数据100，得到这个数的二进制、八进制、十六进制、三进制、五进制、七进制。

    Java针对每种基本类型提供了一个包装类类型，可以对基本类型数据进行更复杂的操作。

    byte        Byte
    short       Short
    int         Integer
    long        Long
    float       Float
    double      Double
    char        Character
    boolean     Boolean

 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toOctalString(100));
        System.out.println(Integer.toHexString(100));
    }
}
