package org.frank.reference.thinking.formal_parameters;
/*
    形式参数如果是基本类型，只需要传递基本类型的值即可。
 */

class Demo {
    public int sum(int a, int b) {
        return a + b;
    }
}

public class ArgsDemo {
    public static void main(String[] args) {
        Demo d = new Demo();

        // 变量
        int x = 10;
        int y = 20;
        int z = d.sum(x, y);
        System.out.println(z);

        // 常量
        int zz = d.sum(10, 20);
        System.out.println(zz);
    }

}
