package org.frank.reference.special_class.Math_Random_System.p3_System;

public class SystemDemo1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int x = 0; x <= 10000000; x++) {
            System.out.println(x);
        }

        long end = System.currentTimeMillis();

        System.out.println("共耗时：" + (end - start) + " 毫秒");
    }
}
