package org.frank.reference.special_class.BigInteger.p1;

import java.math.BigInteger;

/*
    BigInteger add、subtract、multiply、divide methods
 */
public class BigIntegerDemo2 {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("30");
        BigInteger bi2 = new BigInteger("11");

        System.out.println(bi1 + " + " + bi2 + " = " + bi1.add(bi2));

        System.out.println(bi1 + " - " + bi2 + " = " + bi1.subtract(bi2));

        System.out.println(bi1 + " * " + bi2 + " = " + bi1.multiply(bi2));

        System.out.println(bi1 + " / " + bi2 + " = " + bi1.divide(bi2));

        BigInteger[] bis = bi1.divideAndRemainder(bi2);
        for(int x = 0; x < bis.length; x++) {
            System.out.println(bis[x]);
        }
    }
}
