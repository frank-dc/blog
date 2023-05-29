package org.frank.statement.for_loop;
/*
    需求：在指定范围内，统计`水仙花数`共有多少个？
    `水仙花数`，也被称为"阿姆斯特朗数"，是指一个 n 位数，其各个位数上的数字的 n 次幂之和等于该数本身。
    例如，153是一个`水仙花数`，因为 1³ + 5³ + 3³ = 153。

    任意一个数 num，求各个位数
        个位: num % 10
        十位: num / 10 % 10
        百位: num / 100 % 10
        千位: num / 1000 % 10
 */
public class ForDemo3 {
    public static void main(String[] args) {
        int count = 0;
        for(int x = 100; x < 1000; x++) {
            if(is_armstrong_number(x)) {
                System.out.println(x);
                count++;
            }
        }
        System.out.println("三位数的`水仙花数`有：" + count + " 个");
    }

    public static boolean is_armstrong_number(int num) {
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num  / 100 % 10;
        return num == (int)(Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3));
    }
}
