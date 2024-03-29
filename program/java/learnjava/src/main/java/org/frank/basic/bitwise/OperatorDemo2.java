package org.frank.basic.bitwise;
/*
        位 << 运算符：左移，右边补 0
        位 >> 运算符：右移，左边用 1(有符号) 或 0 补充
        位 >>> 运算符: 无符号右移 左边补0

 */

public class OperatorDemo2 {
    public static void main(String[] args) {
        System.out.println(5 >> 2); // 1
        System.out.println(5 << 2); // 20

        System.out.println(5 >>> 2);    // 1 等同于 5 >> 2
        System.out.println(-32 >> 2);   // -8
        System.out.println(-32 >>> 2);  // 1073741816
    }
}

/*

    A) 5 >> 2
      00000000 00000000 00000000 00000101
     ------------------------------------
        000000 00000000 00000000 00000001 01

    B) 5 << 2
      00000000 00000000 00000000 00000101
     ------------------------------------
      00000000 00000000 00000000 00010100

    -32原码 10000000 00000000 00000000 00100000
    -32反码 11111111 11111111 11111111 11011111
    -32补码 11111111 11111111 11111111 11100000

    D) -32 >> 2
      11111111 11111111 11111111 11100000
     ------------------------------------
      11111111 11111111 11111111 11111000  符号位为 1，右移两位，左边用 1 补齐，此为补码
      11111111 11111111 11111111 11110111  补码减 1，得到反码
      10000000 00000000 00000000 00001000  符号位保持不变，其余取反得到原码，此二进制转十进制，即-8

    E) -32 >>> 2
      11111111 11111111 11111111 11100000
     ------------------------------------
      00111111 11111111 11111111 11111000  无符号右移两位，左边用 0 补齐，此为原码
                                           转换为十进制，即 1073741816
 */
