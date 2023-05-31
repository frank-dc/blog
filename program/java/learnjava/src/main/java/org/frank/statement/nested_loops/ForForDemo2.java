package org.frank.statement.nested_loops;
/*
    需求：请输出如下图形
        *
        **
        ***
        ****
        *****
 */
public class ForForDemo2 {
    public static void main(String[] args) {
        // 定义外循环五次
        int row = 5;

        for(int i = 0; i < row; i++) {
            // 内循环次数逐步增加
            for(int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
