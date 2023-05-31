package org.frank.statement.nested_loops;
/*
    需求：在控制台输出九九乘法表。

		1*1=1
		1*2=2	2*2=4
		1*3=3	2*3=6	3*3=9
		...
		1*9=9	2*9=18	3*9=27	4*9=36	...

	转移字符：
		\t	tab键的位置
 */
public class ForForDemo3 {
    public static void main(String[] args) {
        // 定义外循环次数
        int row = 9;

        for(int x = 1; x <= row; x++) {
            for(int y = 1; y <= x; y++) {
                System.out.printf("%d*%d=%d\t", y, x, y * x);
            }
            System.out.println();
        }

    }
}
