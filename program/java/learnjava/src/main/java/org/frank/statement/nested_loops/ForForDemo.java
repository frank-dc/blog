package org.frank.statement.nested_loops;
/*
    需求：请输出一个4行5列的星星(*)图案。
			*****
			*****
			*****
			*****
	循环嵌套中：
	    外循环控制行数
	    内循环控制列数
 */
public class ForForDemo {
    public static void main(String[] args) {
        // 定义外循环次数
        int x = 4;

        // 定义内循环次数
        int y = 5;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
