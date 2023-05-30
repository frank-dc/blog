package org.frank.statement.while_loop;
/*
    while 循环的格式：
        while(条件表达式) {
            循环语句体;
        }

    其它格式：
        初始化语句;
        while(判断条件语句) {
            循环语句体;
            控制条件语句;
        }

        for(初始化语句;判断条件语句;控制条件语句) {
            循环语句体;
        }

    while 循环和 for 循环是可以等价转换的
 */
public class WhileDemo {
    public static void main(String[] args) {
        // 水仙花数 for
        System.out.println("使用for循环打印所有三位数的水仙花数");
        for(int x = 100; x < 1000; x++) {
            int ge = x % 10;
            int shi = x / 10 % 10;
            int bai = x / 100 % 10;

            if(x == (int)(Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3))) {
                System.out.println(x);
            }
        }

        // 水仙花数 while
        System.out.println("使用while循环打印所有三位数的水仙花数");
        int y = 100;
        while(y < 1000) {
            int ge = y % 10;
            int shi = y / 10 % 10;
            int bai = y / 100 % 10;

            if(y == (int)(Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3))) {
                System.out.println(y);
            }

            y++;
        }
    }
}
