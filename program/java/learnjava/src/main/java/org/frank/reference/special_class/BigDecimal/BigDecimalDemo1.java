package org.frank.reference.special_class.BigDecimal;

import java.math.BigDecimal;
/*
    BigDecimal add、subtract、multiply、divide methods
 */

public class BigDecimalDemo1 {
    public static void main(String[] args) {
        // float 和 double 很容易丢失精度
        System.out.println(0.09 + 0.01);    // 0.09999999999999999
        System.out.println(1.0 - 0.32);     // 0.6799999999999999
        System.out.println(1.015 * 100);    // 101.49999999999999
        System.out.println(1.301 / 100);    // 0.013009999999999999

        BigDecimal bd1 = new BigDecimal("0.09");
        BigDecimal bd2 = new BigDecimal("0.01");
        System.out.println(bd1 + " + " + bd2 + " = " + bd1.add(bd2));

        BigDecimal bd3 = new BigDecimal("1.0");
        BigDecimal bd4 = new BigDecimal("0.32");
        System.out.println(bd3 + " - " + bd4 + " = " + bd3.subtract(bd4));

        BigDecimal bd5 = new BigDecimal("1.015");
        BigDecimal bd6 = new BigDecimal("100");
        System.out.println(bd5 + " * " + bd6 + " = " + bd5.multiply(bd6));

        BigDecimal bd7 = new BigDecimal("1.301");
        BigDecimal bd8 = new BigDecimal("100");
        System.out.println(bd7 + " / " + bd8 + " = " + bd7.divide(bd8));

        System.out.println(bd7.divide(bd8, 2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd7.divide(bd8, 3, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd7.divide(bd8, 4, BigDecimal.ROUND_HALF_UP));
    }
}
