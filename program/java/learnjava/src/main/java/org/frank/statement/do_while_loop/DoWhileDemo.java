package org.frank.statement.do_while_loop;
/*
    do...while 格式：
        do {
            语句体;
        }while(条件表达式);

    其他格式：
        初始化语句;
        do {
            循环体语句;
            控制条件语句;
        }while(条件表达式);
 */
public class DoWhileDemo {
    public static void main(String[] args) {
        // 求和
        // 使用 for 循环
//        int sum = 0;
//        for(int x = 0; x < 10; x++) {
//            sum += x;
//        }
//        System.out.println("sum = " + sum);

        // 使用 do...while 循环
        int sum = 0;
        int x = 1;
        do {
            sum += x;
            x++;
        }while(x < 10);
        System.out.println("sum = " + sum);
    }
}
