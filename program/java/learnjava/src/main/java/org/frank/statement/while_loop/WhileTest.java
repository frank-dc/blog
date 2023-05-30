package org.frank.statement.while_loop;
/*
    我国最高山峰是珠穆朗玛峰：8848m，我现在有一张足够大的纸张，厚度为：0.01m。
	请问，我折叠多少次，就可以保证厚度不低于珠穆朗玛峰的高度?
 */
public class WhileTest {
    public static void main(String[] args) {
        // 初始条件
        double x = 0.01;

        // 定义统计变量
        int count = 0;

        while(x < 8848) {
            count++;

            // 每折叠一次，纸张厚度就是之前的两倍
            x *= 2;
        }
        System.out.println("需要折叠 " + count + " 次");
    }
}
