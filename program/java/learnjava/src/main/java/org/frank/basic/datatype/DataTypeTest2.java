package org.frank.basic.datatype;

public class DataTypeTest2 {
    public static void main(String[] args) {
        byte b = (byte) 130;
        System.out.println(b);  // -126
    }
}

/*
    在 Java 中，byte 类型的取值范围是 -128 ~ 127。
    因此，当你尝试将小于-128或大于127的整数赋值给 byte 类型的变量时，就会发生数据溢出，导致变量
    存储的值不再是原始值。
    整数 130 的二进制表示
    00000000 00000000 00000000 10000010
    因为 130 是正数，所以补码也是
    00000000 00000000 00000000 10000010

    做强制转换后，截取为
    10000010
            符号位      数值位
    补码      1       000 0010
    反码      1       000 0001
    原码      1       111 1110    即 -126
 */
