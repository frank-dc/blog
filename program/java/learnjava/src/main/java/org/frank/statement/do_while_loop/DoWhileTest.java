package org.frank.statement.do_while_loop;
/*
    三种循环的区别：
        1. do...while循环至少会执行一次循环体
        2. for 循环和 while 循环只有在条件成立的时候才回去执行循环体

    注意事项：
        1. 写程序优先考虑 for 循环，再考虑 while 循环，最后考虑 do...while 循环
        2. 最简单的死循环代码
            for(;;){}
 */
public class DoWhileTest {
    public static void main(String[] args) {
        for(int x = 10; x < 20; x++) {
            System.out.println("For loop");
        }

        int y = 10;
        while(y < 20) {
            System.out.println("While loop");
            y++;
        }

        int z = 10;
        do{
            System.out.println("Do...while loop");
            z++;
        }while(z < 20);


        /*
        for(;;){
            System.out.println("dead loop");
        }
         */

//        while(true) {
//            System.out.println("dead loop");
//        }
    }
}
