package org.frank.basic.datatype;
/*
    +: 做加法操作
        A: 针对数据操作
        B: 针对字符进行操作
            ASCII码表
                '0': 48
                'A': 65
                'a': 97
        C: 针对字符串进行操作
            在字符串的操作中，叫做字符串连接符

    不同类型相加总结：
        1. 当两个<字符>类型的值相加时，Java 会将它们的 ASCII 码值相加并得到一个<整数>类型的值。
            字符 + 字符 = 整数
        2. 当一个<字符>类型的值与另一个<非字符>类型的值相加时，Java 会将字符类型的值按照 ASCII 码值进行相加。
            字符 + 整数 = 整数
            字符 + 字符串 = 字符串
        3. 当一个<字符串>类型的值与另一个<非字符串>类型的值相加时，Java 会将非字符串类型的值转换为字符串并进行拼接。
            字符串 + 非字符串 = 字符串
 */

public class DataTypeDemo3 {
    public static void main(String[] args) {
        System.out.println("\n打印字符 'a'");
        System.out.println('a');
        System.out.println("\n'a' + 1 字符+数字等同于 97 + 1");
        System.out.println('a' + 1);
        System.out.println("\n'A' + 1 字符+数字等同于 65 + 1");
        System.out.println('A' + 1);
        System.out.println("\n'0' + 1 == 48 + 1");
        System.out.println('0' + 1);

        System.out.println("\n'a' + 'b' 字符+字符是ASCII码相加");
        System.out.println('a' + 'b');

        System.out.println("\n\"a\" + \"b\" 字符串+字符串还是字符串");
        System.out.println("a" + "b");

        System.out.println("\n\"hello\" + 'a' + 1 左边是字符串，往后拼的都是字符串");
        System.out.println("hello" + 'a' + 1);

        System.out.println("\n'a' + 1 + \"hello\" 当一个字符类型的值与另一个非字符类型的值相加时，Java 会将字符类型的值按照ASCII码值进行相加");
        System.out.println('a' + 1 + "hello");

        System.out.println("\n\"5+5=\" + 5 + 5 当一个字符串类型的值与另一个非字符串类型的值相加时，Java 会将非字符串类型的值转换为字符串并进行拼接");
        System.out.println("5+5=" + 5 + 5);

        System.out.println("\n5 + 5 + \"=5+5\" 整数加整数还是整数类型，整数类型与字符串类型相加，Java 会将整数类型转化为字符串类型并进行拼接");
        System.out.println(5 + 5 + "=5+5");
    }
}
