package org.frank.basic.ternary;
/*
	三元运算符：
	格式
		(关系表达式)?表达式1：表达式2；

	执行流程：
		计算关系表达式，看其返回值
			true:表达式1就是整个表达式的值
			false:表达式2就是整个表达式的值

*/
public class OperatorDemo {
    public static void main(String[] args) {
        // 获取两个数据中的较大值
        int x = 3;
        int y = 5;
        int z = (x > y)? x : y;
        System.out.println(z);

        // 比较两个数是否相等
        int m = 10;
        int n = 10;
//        boolean flag = (m == n)? true: false;
        boolean flag = (m == n);
        System.out.println(flag);

        // 获取三个数据中的最大值
        int a = 11;
        int b = 22;
        int c = 33;
//        int max = (a > b)?(a > c? a : c) : (b > c? b : c);
        int temp = (a > b)? a : b;
        int max = (temp > c)? temp: c;
        System.out.println(max);
    }
}
