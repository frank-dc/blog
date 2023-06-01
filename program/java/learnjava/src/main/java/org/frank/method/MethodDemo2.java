package org.frank.method;
/*
    方法的注意事项：
        1. 方法不调用不执行
        2. 方法与方法是平级关系，不能嵌套定义
        3. 方法定义的时候参数之间用逗号隔开
        4. 方法调用的时候不用再传递数据类型
            可以传变量，也可以是常量。就是不能加数据类型
        5. 如果方法有明确的放回值，一定要有 return 带一个值
 */
public class MethodDemo2 {
    public static void main(String[] args) {
        int x = 11;
        int y = 22;

        // 调用方法时传递变量
        int c = sum(x, y);
        System.out.println(c);

        // 调用方式时传递常量
        int d = sum(11, 22);
        System.out.println(d);

    }

    public static int sum(int a, int b) {
        // return a + b;
        int c = a + b;
        return c;
    }
}
