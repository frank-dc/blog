package org.frank.statement.control;
/*
    return 的作用：结束方法
 */
public class ReturnDemo {
    public static void main(String[] args) {
        for(int x = 1; x <= 10; x++) {
            if(x % 3 == 0) {
                // break;
                // continue;
                return;
            }
            System.out.println(x);
        }

        System.out.println("over");
    }
}
