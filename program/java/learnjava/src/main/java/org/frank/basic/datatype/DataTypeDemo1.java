package org.frank.basic.datatype;
/*
    为了更好地表达现实世界的事物，Java针对不同的事物提供了不同的数据类型。

    数据类型：
        基本类型：4类8种
        引用类型：类、接口、数组

    基本类型：
        整数：               占用的内存空间
            byte            1字节
            short           2字节
            int             4字节
            long            8字节
        浮点数：
            float           4字节
            double          8字节
        字符：
            char            2字节
        布尔：
            boolean         1字节

    注意：
        整数默认是 int 类型
        浮点数默认是 double 类型

        long 类型的变量要加 l 或 L
        float 类型的变量要加 f 或 F

        在同一对{}里面，是不能由同名的变量
 */

public class DataTypeDemo1 {
    public static void main(String[] args) {
        // 定义 byte 类型的变量，范围是 -128 ~ 127
        byte b = 127;   // -128 ~ 127
        System.out.println(256);
        System.out.println(b);

        // 定义 short 类型的变量，范围是 -32768 ~ 32767
        short s = 32767;
        System.out.println(s);

        // 定义 int 类型的变量，范围是 -2^31 ~ 2^31 - 1
        int i = 2147483647;
        System.out.println(i);

        // 定义 long 类型的变量，范围是 -2^63 ~ 2^63 - 1
        long l = 9223372036854775807L;
        System.out.println(l);

        // 定义 float 类型的变量
        float f = 12.34f;
        System.out.println(f);

        // 定义 double 类型的变量
        double d = 23.56;
        System.out.println(d);

        // 定义 char 类型的变量
        char c = 'a';
        System.out.println(c);

        // 定义 boolean 类型的变量
        boolean flag = true;
        System.out.println(flag);

    }
}
