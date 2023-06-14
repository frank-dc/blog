package org.frank.reference.lei_class.formal_params;
/*
    基本类型作为形式参数传递，直接传递基本类型的值即可。
 */

class Demo {
    public int sum(int a, int b) {
        return a + b;
    }
}

public class BasicTypeTest {
    public static void main(String[] args) {
        // 定义变量
        int a = 10;
        int b = 20;

        // 创建对象
        Demo d = new Demo();
        int result = d.sum(a, b);
        System.out.println(result);
    }
}
