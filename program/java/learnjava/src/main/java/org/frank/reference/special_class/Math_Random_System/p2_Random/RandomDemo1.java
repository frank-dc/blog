package org.frank.reference.special_class.Math_Random_System.p2_Random;
/*
    Random: 产生随机数的类

    构造方法：
        public Random(): 每次产生的随机数都不同
        public Random(long seed): 每次产生的随机数相同

    成员方法：
        public nextInt(): -2^31 < 随机数 < 2^31 - 1
        public nextInt(int n): 0 <= 随机数 < n
 */
import java.util.Random;

public class RandomDemo1 {
    public static void main(String[] args) {
        Random r = new Random(15);

        for(int x = 0; x < 10; x++) {
            System.out.println(r.nextInt());
        }
    }
}
