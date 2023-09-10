package org.frank.reference.special_class.BigInteger.p1;

import java.math.BigInteger;

/*
    BigInteger:可以实现大整数的计算
    构造方法：BigInteger(String val)
 */

public class BigIntegerDemo1 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);  // -2147483648
        System.out.println(Integer.MAX_VALUE);  // 2147483647

        BigInteger bi = new BigInteger("2147483648");
        System.out.println(bi);
    }
}
